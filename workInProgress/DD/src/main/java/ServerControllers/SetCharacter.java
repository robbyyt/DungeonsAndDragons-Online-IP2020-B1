package ServerControllers;

import com.google.gson.JsonObject;
import com.mongodb.util.JSON;
import controllers.UserController;
import models.User;
import org.json.simple.JSONObject;

public class SetCharacter {
    public JSONObject setCharacter(JsonObject object){
        String playerName = object.get("PLAYER_NAME").toString();
        String character = object.get("CHARACTER_NAME").toString();

        if(parseCharacter(character)==-1){
            return unkownClass();
        }
        User user=null;
        try {
            user = UserController.findUser(playerName);
        }
        catch(Exception e ){
            return unknowPlayer();
        }
        user.setCharacterName(character);

        JSONObject json = new JSONObject();
        json.put("PROTOCOL","SET_CHARACTER");
        json.put("ANSWER","CLASS HAS BEEN SET");
        json.put("SUCCES",1);

        return json;
    }


    int parseCharacter(String character){
        if(character.compareTo("Barabarian")==0){
            return 1;
        }
        else if(character.compareTo("Cleric")==0)
        {
            return 2;
        }
        else if(character.compareTo("Fighter")==0)
        {
            return 3;
        }
        else if(character.compareTo("Paladin")==0)
        {
            return 4;
        }
        else if(character.compareTo("Warlock")==0)
        {
            return 5;
        }
        return -1;
    }


    public JSONObject unkownClass(){
        JSONObject json = new JSONObject();
        json.put("PROTOCOL","SET_CHARACTER");

        json.put("SUCCES",0);
        json.put("ANSWER","NO KNOWN CLASS");
        return json;
    }
    JSONObject unknowPlayer(){
        JSONObject json = new JSONObject();
        json.put("PROTOCOL","SET_CHARACTER");

        json.put("SUCCES",0);
        json.put("ANSWER","NO KNOWN PLAYER");
        return json;
    }
}
