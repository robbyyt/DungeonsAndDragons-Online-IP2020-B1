package models;

import org.bson.types.ObjectId;

import java.util.List;

public class CombatMode {
    ObjectId id;
    List<User> users;
    String DM;
    List<NPC> npcs;
    String  CombatTable [][] = new String[10][10];

    public CombatMode(List<User> users, String DM, List<NPC> npcs, String [][] combatTable) {
        this.users = users;
        this.DM = DM;
        this.npcs = npcs;
        CombatTable = combatTable;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getDM() {
        return DM;
    }

    public void setDM(String DM) {
        this.DM = DM;
    }

    public List<NPC> getNpcs() {
        return npcs;
    }

    public void setNpcs(List<NPC> npcs) {
        this.npcs = npcs;
    }

    public String [][] getCombatTable() {
        return CombatTable;
    }

    public void setCombatTable(String [][] combatTable) {
        CombatTable = combatTable;
    }
    public boolean setPlayerPosition(String userName, int posX, int posY){
        if (this.CombatTable[posX][posY]!=null){
            this.CombatTable[posX][posY]=userName;
            return true;
        }
        return false;
    }

}

