package org.IP;

public class Attributes {
    private int attack;
    private int armor;
    private int attackPower;
    Attributes(int attack,int armor,int attackPower)
    {
        this.attack=attack;
        this.armor=armor;
        this.attackPower=attackPower;
    }
    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

}
