package ServerControllers;

import com.google.gson.Gson;
import controllers.LobbyController;
import models.Lobby;
import org.bson.types.ObjectId;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class StartGame {

    public JSONObject start(JSONObject object) {

        String message = " Jocul a inceput";
        String rawData = new Gson().toJson(message);
        JSONObject json;
        try {
            json = (JSONObject) new JSONParser().parse(rawData);
        } catch (Exception e) {
            return null;
        }
        json.put("PROTOCOL", "START_GAME");
        json.put("SUCCESS", 1);
        json.put("ANSWER", "GAME STARTED!");
        json.put("GAME", rawData);
        return json;
    }
}

