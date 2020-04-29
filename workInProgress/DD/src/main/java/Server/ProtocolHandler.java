package Server;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ServerControllers.*;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ProtocolHandler {
    LobbyHandler lobbyHandler ;
    public ProtocolHandler (){
        lobbyHandler = new LobbyHandler();
    }
    //TAKES THE DATA AND PICKS A PROTOCOL ACCORDINGLY
    //returns a number for each protocol detected
    public int parse(JSONObject object) {
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
        }
        return 0;
    }

    public JSONObject response(JSONObject object,Socket s) {
        JSONObject response = new JSONObject();
        int n = parse(object);
        if (n == 1) {
            return new CreateLobby().createLobby(object,s,lobbyHandler);
        } else if (n == 2) {
            return new JoinLobby().joinLobby(object,s,lobbyHandler);
        } else if (n == 3) {
            return new ShowLobbies().showLobbies(object);
        } else if (n == 4) {
            return new setDM().setDM(object);
        }
        else if(n==5){
            return new StartGame().start(object,lobbyHandler);
        }
        return new Unkown().unknown();
    }
}