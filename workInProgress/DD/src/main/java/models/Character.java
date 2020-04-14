package models;

import java.util.List;

public class Character {
    String name;
    String background;
    String race;
    int level=1;
    int experiencePoints;
    int strength;
    int dexteriry;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;
    int profienceBonus;
    int armourClass;
    int intiative;
    int speed;
    int hitPointMaximum;
    List<AttackAndSpell> attacksAndSpellCast;
    SavingThrows savingThrows;
    Skills skills;
    OtherProficienciesAndLanguages otherProficienciesAndLanguages;
    String equipament;
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
            int dexteriry,
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
            String equipament,
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
        this.dexteriry=dexteriry;
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
        this.equipament=equipament;
        this.personalityTraits=personalityTraits;
        this.ideals=ideals;
        this.bonds=bonds;
        this.flaws=flaws;
        this.featureAndTraits=featureAndTraits;
    }

    public String getName() {
        return name;
    }
}
