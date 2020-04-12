package Ability;

public abstract class Ability {
    protected int value;

    public int getValue() {
        return value;
    }
    public void levelUp(){
        this.value+=5;
    }
}
