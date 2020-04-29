package Server;

import java.util.ArrayList;
import java.util.List;

public class LobbyHandler {
    List<LobbyInfo> lobbyList= new ArrayList<>();
    public void addLobby(LobbyInfo l ){
        lobbyList.add(l);
    }
    public LobbyInfo getLobby(String id ){
        for(LobbyInfo l: lobbyList){
            if(l.getId().compareTo(id)==0){
                return l;
            }
        }
        return null;
    }
}
