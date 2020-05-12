package models;

import org.bson.types.ObjectId;

import java.util.List;

public class NPC {
    ObjectId id;
    String name;
    int armourClass;
    int hitPoints;
    int hitDice;
    int speed;
    SavingThrows savingThrows;
    List<String> damageVulnerabilities;
    List<String> damageImmunities;
    List<String> conditionImmunities;
    List<String> senses;
    List<String> languages;
    int challenge;
    List<AttackAndSpell> attackAndSpell;

    public NPC(String name, int armourClass, int hitPoints, int hitDice, int speed, SavingThrows savingThrows, List<String> damageVulnerabilities, List<String> damageImmunities, List<String> conditionImmunities, List<String> senses, List<String> languages, int challenge, List<AttackAndSpell> attackAndSpell) {
        this.name = name;
        this.savingThrows = savingThrows;
        this.armourClass = armourClass;
        this.hitPoints = hitPoints;
        this.hitDice = hitDice;
        this.speed = speed;
        this.damageVulnerabilities = damageVulnerabilities;
        this.damageImmunities = damageImmunities;
        this.conditionImmunities = conditionImmunities;
        this.senses = senses;
        this.languages = languages;
        this.challenge = challenge;
        this.attackAndSpell = attackAndSpell;
    }

    public SavingThrows getSavingThrows() {
        return savingThrows;
    }

    public void setSavingThrows(SavingThrows savingThrows) {
        this.savingThrows = savingThrows;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArmourClass() {
        return armourClass;
    }

    public void setArmourClass(int armourClass) {
        this.armourClass = armourClass;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getHitDice() {
        return hitDice;
    }

    public void setHitDice(int hitDice) {
        this.hitDice = hitDice;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public List<String> getDamageVulnerabilities() {
        return damageVulnerabilities;
    }

    public void setDamageVulnerabilities(List<String> damageVulnerabilities) {
        this.damageVulnerabilities = damageVulnerabilities;
    }

    public List<String> getDamageImmunities() {
        return damageImmunities;
    }

    public void setDamageImmunities(List<String> damageImmunities) {
        this.damageImmunities = damageImmunities;
    }

    public List<String> getConditionImmunities() {
        return conditionImmunities;
    }

    public void setConditionImmunities(List<String> conditionImmunities) {
        this.conditionImmunities = conditionImmunities;
    }

    public List<String> getSenses() {
        return senses;
    }

    public void setSenses(List<String> senses) {
        this.senses = senses;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public int getChallenge() {
        return challenge;
    }

    public void setChallenge(int challenge) {
        this.challenge = challenge;
    }

    public List<AttackAndSpell> getAttackAndSpell() {
        return attackAndSpell;
    }

    public void setAttackAndSpell(List<AttackAndSpell> attackAndSpell) {
        this.attackAndSpell = attackAndSpell;
    }
}
