package ServerControllers.gameProtocols.dice;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Dice {
    public static int sumDice(JSONArray jsonArray){
        int sum=0;
        for(int i =0;i<jsonArray.size();i++){
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            int value=Integer.valueOf( jsonObject.get("value").toString());
            int randomValue = (int)(Math.random()*value) +1;
            sum+=randomValue;
        }
        return sum;
    }
}
