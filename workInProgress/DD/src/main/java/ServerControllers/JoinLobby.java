package ServerControllers;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import controllers.UserController;
import models.Lobby;
import controllers.LobbyController;
import models.User;
import org.bson.types.ObjectId;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.List;

// must add the thing that all users are uniq
public class JoinLobby {
    public JSONObject joinLobby(JSONObject object){

        String roomId = object.get("ROOM_ID").toString();
        String playerName = object.get("PLAYER_NAME").toString();
        User user = new User();
        ObjectId id = new ObjectId(roomId);
        Lobby lobby = LobbyController.findById(id);
        for(User ur : lobby.getUserList()){
            if(ur.getUsername().compareTo(playerName)==0){
                return samePlayers();
            }
        }
        //
        user.setUsername(playerName);
        UserController.createUser(playerName);
        List<User> users = lobby.getUserList();
        users.add(user);
        lobby.setUserList(users);
        LobbyController.update(lobby);
        String rawData = new Gson().toJson(lobby);
        JSONObject json = new JSONObject();
        try {
            json = (JSONObject) new JSONParser().parse(rawData);
        }
        catch (Exception e ){
            return null;
        }
        json.put("PROTOCOL", "CREATE_LOBBY");
        json.put("SUCCESS", "1");
        json.put("ANSWER", "Room Created Successfully");
        json.put("LOBBY",rawData);
        return json;
    }

    private JSONObject exceptionHandler(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("PROTOCOL","JOIN_LOBBY");
        jsonObject.put("SUCCESS",0);
        jsonObject.put("ANSWER","BAD CALLING");
        return  jsonObject;
    }

    private JSONObject samePlayers(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("PROTOCOL","JOIN_LOBBY");
        jsonObject.put("SUCCESS",0);
        jsonObject.put("ANSWER","ALREADY IN LOBBY");
        return  jsonObject;
    }
}
