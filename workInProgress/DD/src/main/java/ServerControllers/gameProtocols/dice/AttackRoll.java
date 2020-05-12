package ServerControllers.gameProtocols.dice;

import controllers.UserController;
import models.Character;
import models.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static ServerControllers.gameProtocols.dice.Dice.sumDice;

/*

DICE + ACTION => RESULT
 MODIFIER: STR / DEX
 PLAYER_ID:id_player
 MONSTER_ID:monster_id
 WEAPON:
 */
public class AttackRoll {
    public static JSONObject rollDice(JSONObject object){
        JSONArray jsonArray=null;
        String modifier=null;
        String id_player ;
        try {
            jsonArray = (JSONArray) object.get("DICES");
            modifier = object.get("MODIFIER").toString();
            id_player = object.get("PLAYER_ID").toString();
        }
        catch (Exception e) {
            return  failed();
        }
        int sum = sumDice(jsonArray);
        User user = UserController.findUser(id_player);
        Character character = user.getCharacter();

        if(modifier.compareTo("STR")==0){
            sum+=character.getStrength();
        }
        else if(modifier.compareTo("DEX")==0){
            sum+=character.getDexterity();
        }

        //ACTION ,
        return success(sum);
    }



    /*
    INPUT :{PROTOCOL
    DICES:[{n:1},{n:2},{n:3}],
            id_player:"some_id",
            ,monster_id:""
            actiune:"some_id",

    }
    ACTIUNI : OUT_OF_COMBAT
     */
    static JSONObject success(int sum){
        JSONObject object= new JSONObject();
        object.put("PROTOCOL","ACTION_ROLL");
        object.put("DICE_ROLL",sum);
        object.put("SUCCESS",1);

        return object;
    }
    static JSONObject failed(){
        JSONObject object= new JSONObject();
        object.put("PROTOCOL","ACTION_ROLL");
        object.put("SUCCESS",0);
        return object;
    }
}
