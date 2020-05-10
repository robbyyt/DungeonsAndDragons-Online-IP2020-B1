package ServerControllers;

import models.Lobby;
import controllers.LobbyController;
import org.bson.types.ObjectId;
import org.json.simple.JSONObject;

public class CreateLobby {

    static public JSONObject createLobby(JSONObject object) {
        String name;
        try {
            name = object.get("ROOM_NAME").toString();
        }
        catch (Exception e) {
            return exceptionHandler();
        }
        Lobby lobby = new Lobby();
        lobby.setName(name);
        ObjectId id_o = LobbyController.create(lobby);
        lobby.setId(id_o.toString());
        LobbyController.update(lobby);
        return success();
    }
    static JSONObject success(){
        JSONObject json = new JSONObject();
        json.put("PROTOCOL", "CREATE_LOBBY");
        json.put("SUCCESS", "1");
        json.put("ANSWER", "Room Created Successfully");
        return json;
    }

    static JSONObject exceptionHandler() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("PROTOCOL", "CREATE_LOBBY");
        jsonObject.put("SUCCESS", 0);
        return jsonObject;
    }


}
