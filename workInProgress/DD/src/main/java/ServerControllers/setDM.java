package ServerControllers;

import com.google.gson.Gson;
import com.mongodb.util.JSON;
import controllers.LobbyController;
import models.Lobby;
import models.User;
import org.bson.types.ObjectId;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class setDM {
    static public JSONObject setDM(JSONObject object) {

        String playerName = object.get("PLAYER_NAME").toString();
        String roomId = object.get("ROOM_ID").toString();
        ObjectId id = new ObjectId(roomId);
        Lobby lobby = null;
        try {
            lobby = LobbyController.findById(id);
        }
        catch (Exception e ){
            return  noKnownLobby();
        }
        lobby.setDungeonMaster(playerName);
        boolean found=false;
        for (User ur : lobby.getUserList()) {
            if (ur.getUsername().compareTo(playerName) == 0) {
                found=true;
                break;
            }
        }
        if(found==false)
            return invalidDm();
            LobbyController.update(lobby);
            String rawData = new Gson().toJson(lobby);
            JSONObject json;
            try {
                json = (JSONObject) new JSONParser().parse(rawData);
            } catch (Exception e) {
                return null;
            }
            return  succes();
    }

   static private JSONObject succes(){
        JSONObject json = new JSONObject();
        json.put("PROTOCOL", "SET_DM");
        json.put("SUCCESS", 1);
        json.put("ANSWER", "Dungeon Master Set Successfully");
        return json;
    }
    static private JSONObject invalidDm(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("PROTOCOL", "SET_DM");
        jsonObject.put("SUCCESS", 0);
        jsonObject.put("ANSWER", "Invalid Dungeon Master");
        return jsonObject;
    }
   static  JSONObject noKnownLobby(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("PROTOCOL", "SET_DM");
        jsonObject.put("SUCCESS", 0);
        jsonObject.put("ANSWER", "No valid lobby id");
        return jsonObject;
    }
}
