package ServerControllers.gameProtocols.dice;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static ServerControllers.gameProtocols.dice.Dice.sumDice;

public class SavingThrows {

    public static JSONObject rollDice(JSONObject object){
        JSONArray jsonArray=null;
        try {
            jsonArray = (JSONArray) object.get("dices");
        }
        catch (Exception e) {

        }
        int sum = sumDice(jsonArray);

        System.out.println(jsonArray);
        return success();
    }
    static JSONObject success(){
        JSONObject object= new JSONObject();
        object.put("PROTOCOL","SAVING_THROWS");
        object.put("SUCCESS",1);
        return object;
    }
}
