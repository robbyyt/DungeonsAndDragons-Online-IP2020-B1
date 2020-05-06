package ServerControllers;

import controllers.CharacterController;
import controllers.LobbyController;
import controllers.UserController;
import models.Character;
import models.Lobby;
import models.User;
import org.bson.types.ObjectId;
import org.json.simple.JSONObject;

import java.util.List;

public class StartGame {

    public static JSONObject start(JSONObject object) {
        String roomId;
        String playerName;
        try {
            roomId = object.get("ROOM_ID").toString();
            playerName = object.get("PLAYER_NAME").toString();
        }catch (Exception e){
            return exceptionHandler();
        }

        ObjectId id = new ObjectId(roomId.toString());
        Lobby l = LobbyController.findById(id);
        l.getUserList();
        if(l.getDungeonMaster()==null){
            return noDungeonMaster();
        }
        else if(l.getDungeonMaster().compareTo(playerName)!=0) {
            return invalidDungeonMaster();
        }
        List<User> playerList = l.getUserList();
        for(User p : playerList){
            User user = UserController.findUser(p.getUsername());
            ObjectId userId;
            try {
                userId = parseCharacter(user.getCharacterName());
                if(userId == null){
                    return nullError();
                }
            }
            catch(Exception e){
                return nullError();
            }
            Character c = CharacterController.findCharacterByIdAndName(userId,p.getUsername());
            user.setCharacter(c);
            UserController.updateUser(user);
        }

        JSONObject json = new JSONObject();
        json.put("PROTOCOL", "START_GAME");
        json.put("SUCCESS", 1);
        json.put("ANSWER", "GAME STARTED");
        //SendToPlayers.sendToMore(playerList,json);
        return json;
    }


    static JSONObject noDungeonMaster(){
        JSONObject json = new JSONObject();
        json.put("PROTOCOL", "START_GAME");
        json.put("SUCCESS", 0);
        json.put("ANSWER", "NO SET DUNGEON MASTER");
        return json;
    }
    static JSONObject invalidDungeonMaster(){
        JSONObject json = new JSONObject();
        json.put("PROTOCOL", "START_GAME");
        json.put("SUCCESS", 0);
        json.put("ANSWER", "NO VALID DUNGEON MASTER");
        return json;
    }



    static ObjectId parseCharacter(String character) {
        if(character.compareTo("Barabarian")==0){
            return CharacterController.createCharacterBarbarian();
        }
        else if(character.compareTo("Cleric")==0)
        {
            return CharacterController.createCharacterCleric();
        }
        else if(character.compareTo("Fighter")==0)
        {
            return CharacterController.createCharacterFighter();
        }
        else if(character.compareTo("Paladin")==0)
        {
            return CharacterController.createCharacterPaladin();
        }
        else if(character.compareTo("Warlock")==0)
        {
            return CharacterController.createCharacterWarlock();
        }
        return null;
    }
    static public JSONObject nullError(){
        JSONObject json = new JSONObject();
        json.put("PROTOCOL","START_GAME");
        json.put("SUCCES",0);
        json.put("ANSWER","NOT ALL USERS HAVE SET THEIR CLASS");
        return json;
    }
    static JSONObject exceptionHandler() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("PROTOCOL", "START_GAME");
        jsonObject.put("SUCCESS", 0);
        return jsonObject;
    }
}




