

import java.util.ArrayList;
import java.util.List;

public class MonsterNpc extends Npc{
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
}
