package models;

public class Armor {
    String name;
    int value;

    public Armor(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public void armourSet(Armor armor)
    {
        if(armor.getName().equals("light armor")) setValue(11);
        else if(armor.getName().equals("medium armor")) setValue(12);
        else if(armor.getName().equals("hard armor")) setValue(13);
        else if (armor.getName().equals("shield")) setValue(2);
    }
}
