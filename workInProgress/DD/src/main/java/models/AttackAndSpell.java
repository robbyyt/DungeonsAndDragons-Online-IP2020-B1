package models;

public class AttackAndSpell {
    String name;
    int attackBonus;
    int damage;
    public AttackAndSpell(String name,int attackBonus,int damage){
        this.name = name;
        this.attackBonus = attackBonus;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
