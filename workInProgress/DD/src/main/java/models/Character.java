package models;

import java.util.List;

public class Character {
    String name;
    String background;
    String race;
    int level=1;
    int experiencePoints;
    int hitDice;
    //ability check... modifiers

    int strength;
    int dexterity;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;

    ///////////
    int profienceBonus;
    int armourClass;
    int intiative;
    int speed;

    int hitPointMaximum;
    List<AttackAndSpell> attacksAndSpellCast;
    SavingThrows savingThrows;
    Skills skills;
    OtherProficienciesAndLanguages otherProficienciesAndLanguages;
    String equipment;
    String personalityTraits;
    String ideals;
    String bonds;
    String flaws;
    String featureAndTraits;
    int passiveWisdom;
    public Character(
            String name,
            String background,
            String race,
            int experiencePoints,
            int strength,
            int dexterity,
            int constitution,
            int intelligence,
            int wisdom,
            int charisma,
            int passiveWisdom,
            int profienceBonus,
            int armourClass,
            int intiative,
            int speed,
            int hitPointMaximum,
            List<AttackAndSpell> attacksAndSpellCast,
            SavingThrows savingThrows,
            Skills skills,
            OtherProficienciesAndLanguages otherProficienciesAndLanguages,
            String equipment,
            String personalityTraits,
            String ideals,
            String bonds,
            String flaws,
            String featureAndTraits){
        this.name = name;
        this.race=race;
        this.passiveWisdom = passiveWisdom;
        this.background = background;
        this.experiencePoints =experiencePoints;
        this.strength=strength;
        this.dexterity = dexterity;
        this.constitution=constitution;
        this.intelligence=intelligence;
        this.wisdom=wisdom;
        this.charisma=charisma;
        this.profienceBonus=profienceBonus;
        this.armourClass=armourClass;
        this.intiative=intiative;
        this.speed=speed;
        this.hitPointMaximum=hitPointMaximum;
        this.attacksAndSpellCast=attacksAndSpellCast;
        this.savingThrows=savingThrows;
        this.skills=skills;
        this.otherProficienciesAndLanguages=otherProficienciesAndLanguages;
        this.equipment = equipment;
        this.personalityTraits=personalityTraits;
        this.ideals=ideals;
        this.bonds=bonds;
        this.flaws=flaws;
        this.featureAndTraits=featureAndTraits;
    }
    public String getName() {
        return name;
    }

    public int getHitDice() {
        return hitDice;
    }

    public void setHitDice(int hitDice) {
        this.hitDice = hitDice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
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

    public int getProfienceBonus() {
        return profienceBonus;
    }

    public void setProfienceBonus(int profienceBonus) {
        this.profienceBonus = profienceBonus;
    }

    public int getArmourClass() {
        return armourClass;
    }

    public void setArmourClass(int armourClass) {
        this.armourClass = armourClass;
    }

    public int getIntiative() {
        return intiative;
    }

    public void setIntiative(int intiative) {
        this.intiative = intiative;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHitPointMaximum() {
        return hitPointMaximum;
    }

    public void setHitPointMaximum(int hitPointMaximum) {
        this.hitPointMaximum = hitPointMaximum;
    }

    public List<AttackAndSpell> getAttacksAndSpellCast() {
        return attacksAndSpellCast;
    }

    public void setAttacksAndSpellCast(List<AttackAndSpell> attacksAndSpellCast) {
        this.attacksAndSpellCast = attacksAndSpellCast;
    }

    public SavingThrows getSavingThrows() {
        return savingThrows;
    }

    public void setSavingThrows(SavingThrows savingThrows) {
        this.savingThrows = savingThrows;
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    public OtherProficienciesAndLanguages getOtherProficienciesAndLanguages() {
        return otherProficienciesAndLanguages;
    }

    public void setOtherProficienciesAndLanguages(OtherProficienciesAndLanguages otherProficienciesAndLanguages) {
        this.otherProficienciesAndLanguages = otherProficienciesAndLanguages;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getPersonalityTraits() {
        return personalityTraits;
    }

    public void setPersonalityTraits(String personalityTraits) {
        this.personalityTraits = personalityTraits;
    }

    public String getIdeals() {
        return ideals;
    }

    public void setIdeals(String ideals) {
        this.ideals = ideals;
    }

    public String getBonds() {
        return bonds;
    }

    public void setBonds(String bonds) {
        this.bonds = bonds;
    }

    public String getFlaws() {
        return flaws;
    }

    public void setFlaws(String flaws) {
        this.flaws = flaws;
    }

    public String getFeatureAndTraits() {
        return featureAndTraits;
    }

    public void setFeatureAndTraits(String featureAndTraits) {
        this.featureAndTraits = featureAndTraits;
    }

    public int getPassiveWisdom() {
        return passiveWisdom;
    }

    public void setPassiveWisdom(int passiveWisdom) {
        this.passiveWisdom = passiveWisdom;
    }
}
