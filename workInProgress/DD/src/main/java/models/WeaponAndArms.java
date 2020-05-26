package models;

public class WeaponAndArms {
    String name;
    String id;
    String type;
    String properties;
    String whyToUse;
    String weight;
    String cost;

    public WeaponAndArms(String name, String type, String properties, String whyToUse, String weight, String cost) {
        this.name = name;
        this.type = type;
        this.properties = properties;
        this.whyToUse = whyToUse;
        this.weight=weight;
        this.cost=cost;
    }

    public WeaponAndArms() {
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

    public String getWhyToUse() {
        return whyToUse;
    }

    public void setWhyToUse(String whyToUse) {
        this.whyToUse = whyToUse;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

}
