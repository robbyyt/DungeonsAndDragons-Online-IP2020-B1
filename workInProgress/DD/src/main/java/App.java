import controllers.CharacterController;
import controllers.UserController;
import models.Character;
import models.User;
import org.bson.types.ObjectId;

public class App {
     public static void main(String[] args) {
         //TESTING FUNCTIONALITY
         ObjectId id = CharacterController.createCharacterCleric();
        UserController.createUser("firstUser");
        User user = UserController.findUser("firstUser");
        user.setCharacterId(id.toString());
        Character character = CharacterController.findCharacterByIdAndName(id,"Cleric");
        System.out.println(character.getName());
        controllers.UserController.updateUser(user);
    }
}
