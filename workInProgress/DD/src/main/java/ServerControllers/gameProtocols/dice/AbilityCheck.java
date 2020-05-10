package ServerControllers.gameProtocols.dice;

import netscape.javascript.JSObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static ServerControllers.gameProtocols.dice.Dice.sumDice;

/*
DICE + ACTION => RESULT
 MODIFIER:

 */
public class AbilityCheck {
    public static JSONObject checkRoll(JSONObject object){
        JSONArray jsonArray=null;
        try {
            jsonArray = (JSONArray) object.get("dices");
        }
        catch (Exception e) {

        }
        int sum = sumDice(jsonArray);

        System.out.println(jsonArray);
        return success(3);

    }
    static JSONObject success(int value){
        JSONObject object= new JSONObject();

        object.put("PROTOCOL","ABILITY_CHECK");
        object.put("SUCCESS",1);
        return object;
    }
}
