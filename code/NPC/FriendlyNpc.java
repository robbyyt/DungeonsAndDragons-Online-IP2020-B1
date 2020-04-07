package org.letos;

import java.util.ArrayList;
import java.util.List;

public class FriendlyNpc extends Npc{
    private int id;
    private List<Integer> drop = new ArrayList<>();
    private List<Integer> items = new ArrayList<>();

    public List<Integer> getDrop() {
        return drop;
    }

    public void setDrop(List<Integer> drop) {
        this.drop = drop;
    }

    public List<Integer> getItems() {
        return items;
    }

    public void setItems(List<Integer> items) {
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
