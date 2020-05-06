package ServerControllers.gameProtocols.player;

import com.mongodb.util.JSON;
import org.json.simple.JSONObject;
import utils.DiceRoll;

public class rollDice {
    public static JSONObject rollDic(JSONObject object){
        int n = DiceRoll.roll();
        return success(n);
    }


    static JSONObject success(int n){
        JSONObject object= new JSONObject();
        object.put("PROTOCOL","ROLL_DICE");
        object.put("NUMBER", n);
        object.put("SUCCESS",1);
        return object;
    }
}
