

import java.util.ArrayList;
import java.util.List;

public class FriendlyNpc extends Npc{
  
    private List<Integer> items = new ArrayList<>();

    public List<Integer> getItems() {
        return items;
    }

    public void setItems(List<Integer> items) {
        this.items = items;
    }
}
