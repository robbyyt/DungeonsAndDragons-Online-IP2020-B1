package ServerControllers;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import models.Lobby;
import controllers.LobbyController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.List;

public class ShowLobbies {
    public JSONObject showLobbies(JSONObject object){
        try{
            JSONObject json = new JSONObject();
            List<Lobby> lobbies = LobbyController.getAllLobbies();
            JSONArray array= new JSONArray();
            for(Lobby lobby : lobbies) {
                String rawData = new Gson().toJson(lobby);
                JSONObject out = null;
                try {
                    out = (JSONObject) new JSONParser().parse(rawData);
                } catch (Exception e) {
                    return null;
                }
                array.add(out);
            }
                json.put("PROTOCOL","SHOW_LOBBIES");
                json.put("LIST_LOBBIES",array);
                json.put("SUCCES",1);
                json.put("NR_LOBBIES",lobbies.size());
                return json;

        }catch(Exception e){
            return exceptionHandler();
        }
    }
    private JSONObject exceptionHandler(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("PROTOCOL","SHOW_LOBBIES");
        jsonObject.put("SUCCESS",0);
        jsonObject.put("ANSWER","BAD CALLING");
        return  jsonObject;
    }
}
