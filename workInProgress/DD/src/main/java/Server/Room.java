package Server;

import java.util.ArrayList;
import java.util.List;

public class Room {
    int id ;
    String name;
    List<Player> playerList;

    public Room(int id, String name) {
        this.name = name;
        this.id = id;
        playerList = new ArrayList<>();
    }
    public void addPlayer(Player player){
        this. playerList.add(player);
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
    public String getName() {
        return  this.name;
    }

    public int getId() {
        return id;
    }

}
