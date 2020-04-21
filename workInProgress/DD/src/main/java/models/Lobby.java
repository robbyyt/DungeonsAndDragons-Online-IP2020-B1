package models;
import java.util.*;
public class Lobby {
    String name;
    String id;
    String dungeonMaster;
    int maxPlayersLimit;
    List<User> userList= new ArrayList<User>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDungeonMaster() {
        return dungeonMaster;
    }

    public void setDungeonMaster(String dungeonMaster) {
        this.dungeonMaster = dungeonMaster;
    }

    public int getMaxPlayersLimit() {
        return maxPlayersLimit;
    }

    public void setMaxPlayersLimit(int maxPlayersLimit) {
        this.maxPlayersLimit = maxPlayersLimit;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}