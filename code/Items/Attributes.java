package Items;

public class Attributes extends java.util.jar.Attributes {
    private int attack;
    private int armor;
    private int attackPower;
    Attributes(int attack,int armor,int attackPower)
    {
        this.attack=attack;
        this.armor=armor;
        this.attackPower=attackPower;
    }
    public int getAttackAttribute() {
        return attack;
    }

    public void setAttackAttribute(int attack) {
        this.attack = attack;
    }

    public int getArmorAttribute() {
        return armor;
    }

    public void setArmorAttribute(int armor) {
        this.armor = armor;
    }

    public int getAttackPowerAttribute() {
        return attackPower;
    }

    public void setAttackPowerAttribute(int attackPower) {
        this.attackPower = attackPower;
    }

}
