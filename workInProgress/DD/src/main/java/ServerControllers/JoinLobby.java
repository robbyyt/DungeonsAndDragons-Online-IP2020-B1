package ServerControllers;
import com.google.gson.Gson;
import controllers.UserController;
import models.Lobby;
import controllers.LobbyController;
import models.User;
import org.bson.types.ObjectId;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.Socket;
import java.util.List;

// must add the thing that all users are uniq
public class JoinLobby {
    public static JSONObject joinLobby(JSONObject object) {

        String roomName, playerName;
        try {
            roomName = object.get("ROOM_NAME").toString();
            playerName = object.get("PLAYER_ID").toString();
        } catch (Exception e) {
            return exceptionHandler();
        }
        User user = new User();
        ObjectId id = new ObjectId(roomName);
        Lobby lobby = LobbyController.findById(id);
        user.setUsername(playerName);
        UserController.createUser(playerName);
        List<User> users = lobby.getUserList();
        users.add(user);
        lobby.setUserList(users);
        int nrPlayers = lobby.getNrPlayers();
        nrPlayers = nrPlayers + 1;
        lobby.setNrPlayers(nrPlayers);
        LobbyController.update(lobby);
        return succes();
    }

    static private JSONObject exceptionHandler() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("PROTOCOL", "JOIN_LOBBY");
        jsonObject.put("SUCCESS", 0);
        return jsonObject;
    }

    static private JSONObject noRoom() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("PROTOCOL", "JOIN_LOBBY");
        jsonObject.put("SUCCESS", 0);
        jsonObject.put("ANSWER", "NO ROOM WITH THIS ID ");
        return jsonObject;
    }

    static private JSONObject succes() {
        JSONObject json = new JSONObject();
        json.put("PROTOCOL", "JOIN_LOBBY");
        json.put("SUCCESS", "1");
        json.put("ANSWER", "Room Created Successfully");
        return json;
    }
}
