package Server;

import ServerControllers.gameProtocols.dice.AttackRoll;
import org.json.simple.JSONObject;
import ServerControllers.*;

import java.net.Socket;

public class ProtocolHandler {
    //TAKES THE DATA AND PICKS A PROTOCOL ACCORDINGLY
    //returns a number for each protocol detected

    public static JSONObject parse(JSONObject object, Socket s) {
        //DEFINESTI PROTOCOALE
        String protocol = object.get("PROTOCOL").toString();
        System.out.println(object);
        if (protocol.compareTo("CREATE_LOBBY") == 0) {
            return CreateLobby.createLobby(object);
        } else if (protocol.compareTo("JOIN_LOBBY") == 0) {
            return JoinLobby.joinLobby(object);
        } else if (protocol.compareTo("SHOW_LOBBIES") == 0) {
            return new ShowLobbies().showLobbies(object);
        } else if (protocol.compareTo("SET_DM") == 0) {
            return setDM.setDM(object);
        } else if (protocol.compareTo("START_GAME") == 0) {
            return StartGame.start(object);
        }else if(protocol.compareTo("SET_CHARACTER")==0) {
            return SetCharacter.setCharacter(object);
        }else if(protocol.compareTo("ACTION_DICE")==0){
            return AttackRoll.rollDice(object);
        }
        return FailureResponse.unknown();
    }

}