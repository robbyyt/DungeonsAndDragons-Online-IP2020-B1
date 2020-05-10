package ServerControllers.gameProtocols.dungeonMaster;

import com.mongodb.util.JSON;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import utils.DiceRoll;

public class ActionRoll {
    public static JSONObject rollDice(JSONObject object){
        JSONArray jsonArray = (JSONArray) object.get("dices");



        return success();
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
    static JSONObject success(){
        JSONObject object= new JSONObject();

        object.put("PROTOCOL","ROLL_DICE");
        object.put("SUCCESS",1);
        return object;
    }
}
