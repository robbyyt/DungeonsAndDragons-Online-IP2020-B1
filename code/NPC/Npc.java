package NPC;

import java.util.ArrayList;
import java.util.List;

public abstract class Npc {
    NpcType type;
    private int id;
    private List<Integer> drop = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getDrop() {
        return drop;
    }

    public void setDrop(List<Integer> drop) {
        this.drop = drop;
    }

    public NpcType getType() {
        return type;
    }

    public void setType(NpcType type) {
        this.type = type;
    }
}
