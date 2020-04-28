package Server;

import java.util.ArrayList;
import java.util.List;
//mai degraba clasa care retine sockete pentru un joc,
// eg. vreau sa dau tot odata la mai multi informatia
// server  da la mai multi clienti cand se intampla ceva
public class LobbyInfo {
    String id ;
    List<Player> playerList = new ArrayList<>();

    public void setId(String id) {
        this.id = id;
    }
   public void addPlayer(Player p) {
        playerList.add(p);
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public String getId() {
        return id;
    }
}
