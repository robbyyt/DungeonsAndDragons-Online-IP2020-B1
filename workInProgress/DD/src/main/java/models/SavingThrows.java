package models;

public class SavingThrows {
    int strength;
    int dexteriry;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;
    public SavingThrows(int strength,int dexteriry,int constitution,int intelligence,int wisdom,int charisma){
        this.strength = strength;
        this.dexteriry = dexteriry;
        this.constitution=constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexteriry() {
        return dexteriry;
    }

    public void setDexteriry(int dexteriry) {
        this.dexteriry = dexteriry;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }
}
