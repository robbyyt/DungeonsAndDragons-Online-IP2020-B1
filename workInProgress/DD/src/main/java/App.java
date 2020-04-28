import DAO.Database;
import controllers.CharacterController;
import controllers.LobbyController;
import controllers.UserController;
import models.Character;
import models.Lobby;
import models.User;
import org.bson.types.ObjectId;
import Server.GameServer;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args)
    {
        GameServer server = new GameServer(8000);

      //testLobby();

    }
     public static void testLobby(){
        Lobby lobby = new Lobby();
        lobby.setDungeonMaster("DM");
        lobby.setMaxPlayersLimit(5);
        lobby.setName("BestLobby");
        ObjectId id =LobbyController.create(lobby);
        lobby.setId(id.toString());
        User user = UserController.findUser("firstUser");
        lobby.setUserList(Arrays.asList(user));
        lobby.setMaxPlayersLimit(9);
        LobbyController.update(lobby);
        System.out.println(lobby.getId());
    }
    public void testUser(){
        ObjectId id = CharacterController.createCharacterBarbarian();
         UserController.createUser("firstUser");
         User user = UserController.findUser("firstUser");
         user.setCharacterId(id.toString());
         Character character = CharacterController.findCharacterByIdAndName(id,"Barbarian");
         System.out.println(character.getName());
         controllers.UserController.updateUser(user);
    }

}
