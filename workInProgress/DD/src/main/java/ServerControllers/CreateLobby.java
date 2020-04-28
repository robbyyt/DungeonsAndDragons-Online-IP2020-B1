package ServerControllers;

import com.google.gson.Gson;
import models.Lobby;
import controllers.LobbyController;
import org.bson.types.ObjectId;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CreateLobby {
    public JSONObject createLobby(JSONObject object) {
        try {
            String playerName = object.get("PLAYER_NAME").toString();
            String roomName = object.get("roomName").toString();
            String str = object.get("maxPlayersLimit").toString();
            int maxPlayers = Integer.parseInt(str);
            Lobby lobby = new Lobby();
            lobby.setMaxPlayersLimit(maxPlayers);
            lobby.setName(roomName);
            lobby.setDungeonMaster(playerName);
            ObjectId id = LobbyController.create(lobby);
            lobby.setId(id.toString());
            LobbyController.update(lobby);
            String rawData = new Gson().toJson(lobby);
            JSONObject out = null;
            try {
                out = (JSONObject) new JSONParser().parse(rawData);
            } catch (Exception e) {
                return null;
            }
            out.put("PROTOCOL", "CREATE_LOBBY");
            out.put("SUCCESS", "1");
            out.put("ANSWER", "Room Created Successfully");
            return out;
        } catch (Exception e) {
            System.out.println(e);
            return exceptionHandler();
        }
    }

    private JSONObject exceptionHandler() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("PROTOCOL", "CREATE_LOBBY");
        jsonObject.put("SUCCESS", 0);
        jsonObject.put("ANSWER", "BAD CALLING");
        return jsonObject;
    }
}
