package models;

public class OtherProficienciesAndLanguages {
    String Languages;
    String Armour;
    String Weapons;
    String Tools;
    String Skills;
    public OtherProficienciesAndLanguages(String Languages,
            String Armour,
            String Weapons,
            String Tools,
            String Skills){
        this.Armour=Armour;
        this.Languages = Languages;
        this.Skills = Skills;
        this.Tools = Tools;
        this.Weapons =Weapons;
    }

    public String getLanguages() {
        return Languages;
    }

    public void setLanguages(String languages) {
        Languages = languages;
    }

    public String getArmour() {
        return Armour;
    }

    public void setArmour(String armour) {
        Armour = armour;
    }

    public String getWeapons() {
        return Weapons;
    }

    public void setWeapons(String weapons) {
        Weapons = weapons;
    }

    public String getTools() {
        return Tools;
    }

    public void setTools(String tools) {
        Tools = tools;
    }

    public String getSkills() {
        return Skills;
    }

    public void setSkills(String skills) {
        Skills = skills;
    }
}
