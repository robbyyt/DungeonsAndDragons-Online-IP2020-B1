package utils;

import models.*;
import models.Character;

import java.util.*;

public class CharacterGenerator {
    public static Character generateBarbarian(){
        SavingThrows barbarianSavingThrows = new SavingThrows(4, 1, 5, -1, 1, 0);
        Skills barbarianSkills = new Skills(1, 1, -1, 4, 0, -1, 1,
                2, -1, 1, -1, 3, 0, 0, -1, 1,
                1, 3);
        OtherProficienciesAndLanguages otherProficienciesAndLanguages = new OtherProficienciesAndLanguages("dwarven & common",
                "light & medium armor & shields", "simple & martial weapons", "gaming set, vehicles (land)",
                "perception & survival");
        List<AttackAndSpell> attackAndSpellList = new ArrayList<AttackAndSpell>();
        attackAndSpellList.add(new AttackAndSpell("battleaxa",4,2));
        attackAndSpellList.add(new AttackAndSpell("handaxe",4,2));
        String equipament = "insignia of rank\n" +
                "trophy from fallen enemy\n" +
                "gaming set\n" +
                "common clothes\n" +
                "pouch\n" +
                "\n" +
                "battleaxe\n" +
                "handaxe x2\n" +
                "javelins x4\n" +
                "explorer's pack: backpack, bedroll, mess kit, 10 torches, 10 days of rations, waterskin, 50 ft of hempen rope";
        String personalityTraits = "I’m haunted by memories o f war. I can’t get the images of violence out of my mind.\n" +
                "\n" +
                "I enjoy being strong and like breaking things.";
        String ideals = "Nation. My people are all that matter.";
        String bonds = "Those who fight beside me are those worth dying for.";
        String flaws = "My hatred of my enemies is blind and unreasoning.";
        String featureAndTraits = "ASI: +2 to CON & +1 to WIS\n" +
                "Speed: 25 ft (speed doesn't reduce because of wearing heavy armor)\n" +
                "Darkvision: 60 ft\n" +
                "Dwarven Resilience: advantage on poison saves & resistance to poison damage\n" +
                "Dwarven Combat Training: prof. in battleaxe, handaxe, light hammer & warhammer\n" +
                "Tool Proficiency: prof. in one artisan tools from: smith's tools, brewer's suppliers, or mason's tools.\n" +
                "Stonecunning: considered prof. in History (Intelligence) checks and double prof. related to stonework\n" +
                "Dwarven Toughness: +1 hit point per level\n" +
                "\n" +
                "Barbarian Class Features:\n" +
                "1st lvl: Rage ( 2 uses per long rest)\n" +
                "- to start or end rage cost bonus action\n" +
                "- rage lasts 1 minute\n" +
                "- advantage on STR saves & ability checks\n" +
                "- when making melee weapon attacks with STR, granted +2 on damage rolls\n" +
                "- have resistance to bludgeoning, piercing and slashing damage\n" +
                "\n" +
                "1st lvl: Unarmored Defense:\n" +
                "- AC = 10 + CON mod + DEX mod\n" +
                "- when not wearing armor, can use shield\n";
        Character barbarian = new Character(
                "Barbarian", "Soldier(Infantry)", "Shield(Hill) Dwarf", 0, 14,
                13, 17, 8, 13, 10, 13, 2, 14, 1,
                25, 16, attackAndSpellList, barbarianSavingThrows, barbarianSkills, otherProficienciesAndLanguages,
                equipament, personalityTraits, ideals, bonds, flaws, featureAndTraits);
        return barbarian;
    }
}
