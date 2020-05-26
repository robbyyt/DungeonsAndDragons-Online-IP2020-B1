package models;

public class Armor {
    String name;
    String type;
    String id;
    int cost;
    int armourClass;
    String modifier;
    int strength;
    int weight;

    public Armor(String name, String type, String id, int cost, int armourClass, String modifier, int strength, int weight) {
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.armourClass = armourClass;
        this.modifier = modifier;
        this.strength = strength;
        this.weight = weight;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getArmourClass() {
        return armourClass;
    }

    public void setArmourClass(int armourClass) {
        this.armourClass = armourClass;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
