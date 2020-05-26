package models;

public class Weapons {
    String name;
    String id;
    String type;
    int cost;
    int dice;
    String properties;
    int weight;

    public Weapons(String name, String id, String type, int cost, int dice, String properties, int weight) {
        this.name = name;
        this.id = id;
        this.type = type;
        this.cost = cost;
        this.dice = dice;
        this.properties = properties;
        this.weight=weight;
    }

    public Weapons() {
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }


    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDice() {
        return dice;
    }

    public void setDice(int dice) {
        this.dice = dice;
    }
}
