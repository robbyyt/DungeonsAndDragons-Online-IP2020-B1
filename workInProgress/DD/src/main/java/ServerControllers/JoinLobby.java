package ServerControllers;
import Server.LobbyHandler;
import Server.LobbyInfo;
import Server.Player;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mongodb.util.JSON;
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
    public JSONObject joinLobby(JSONObject object, Socket s, LobbyHandler lobbyHandler){

        String roomId = object.get("ROOM_ID").toString();
        String playerName = object.get("PLAYER_NAME").toString();
        User user = new User();
        ObjectId id = new ObjectId(roomId);
        Lobby lobby = LobbyController.findById(id);
        if(lobby.getNrPlayers()==lobby.getMaxPlayersLimit()){
            return  limitReached();
        }
        if(lobby==null){
            return noRoom();
        }
        for(User ur : lobby.getUserList()){
            if(ur.getUsername().compareTo(playerName)==0){
                return samePlayers();
            }
        }
        //
        //
        try{
            Player p = new Player();
            p.setName(playerName);
            p.setSocket(s);
            LobbyInfo l = lobbyHandler.getLobby(id.toString());
            l.addPlayer(p);}
        catch(Exception e){
            return noRoom();
        }
        user.setUsername(playerName);
        UserController.createUser(playerName);
        List<User> users = lobby.getUserList();
        users.add(user);
        lobby.setUserList(users);
        int nrPlayers = lobby.getNrPlayers();
        nrPlayers = nrPlayers+1;
        lobby.setNrPlayers(nrPlayers);
        LobbyController.update(lobby);
        String rawData = new Gson().toJson(lobby);
        JSONObject json = new JSONObject();
        try {
            json = (JSONObject) new JSONParser().parse(rawData);
        }
        catch (Exception e ){
            return exceptionHandler();
        }
        json.put("PROTOCOL", "JOIN_LOBBY");
        json.put("SUCCESS", "1");
        json.put("ANSWER", "Room Created Successfully");
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

    private JSONObject noRoom(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("PROTOCOL","JOIN_LOBBY");
        jsonObject.put("SUCCESS",0);
        jsonObject.put("ANSWER","NO ROOM WITH THIS ID ");
        return  jsonObject;
    }
    private JSONObject limitReached(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("PROTOCOL","JOIN_LOBBY");
        jsonObject.put("SUCCESS",0);
        jsonObject.put("ANSWER","TOO_MANY_PLAYERS");
        return  jsonObject;
    }
}
