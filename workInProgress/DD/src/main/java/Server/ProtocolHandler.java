package Server;

import ServerControllers.gameProtocols.dice.AttackRoll;
import org.json.simple.JSONObject;
import ServerControllers.*;

import java.net.Socket;

public class ProtocolHandler {
    //TAKES THE DATA AND PICKS A PROTOCOL ACCORDINGLY
    //returns a number for each protocol detected

    public static int parse(JSONObject object) {
        //DEFINESTI PROTOCOALE
        String protocol = object.get("PROTOCOL").toString();
        System.out.println(object);
        if (protocol.compareTo("CREATE_LOBBY") == 0) {
            return 1;
        } else if (protocol.compareTo("JOIN_LOBBY") == 0) {
            return 2;
        } else if (protocol.compareTo("SHOW_LOBBIES") == 0) {
            return 3;
        } else if (protocol.compareTo("SET_DM") == 0) {
            return 4;
        } else if (protocol.compareTo("START_GAME") == 0) {
            return 5;
        }else if(protocol.compareTo("SET_CHARACTER")==0) {
            return 6;
        }else if(protocol.compareTo("ACTION_DICE")==0){
            return 7;
        }
        return 0;
    }

    public static JSONObject response(JSONObject object,Socket s) {
        JSONObject response = new JSONObject();
        int n = parse(object);
        if (n == 1) {
            return CreateLobby.createLobby(object);
        } else if (n == 2) {
            return JoinLobby.joinLobby(object);
        } else if (n == 3) {
            //return new ShowLobbies().showLobbies(object);
        } else if (n == 4) {
            return setDM.setDM(object);
        }
        else if(n==5){
            return StartGame.start(object);
        }
        else if(n==6){
            return SetCharacter.setCharacter(object);
        }else if(n==7){
            return AttackRoll.rollDice(object);
        }
            return FailureResponse.unknown();
    }
}