package utils;

import models.AttackAndSpell;
import models.NPC;
import models.SavingThrows;
import models.Skills;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NPCGenerator {
    public static NPC generateSkeleton(){
        SavingThrows skeletonSavingThrows = new SavingThrows(0,2,2,-2,-1,-3);
        List<AttackAndSpell> attackAndSpellList = new ArrayList<AttackAndSpell>();
        attackAndSpellList.add(new AttackAndSpell("shortsword",5,2));
        attackAndSpellList.add(new AttackAndSpell("hortbow",5,2));
        List<String> damage = new ArrayList<>();
        damage.add("Bludgeoning");
        List<String> imunities = new ArrayList<>();
        imunities.add("Poison");
        List<String> conditions = new ArrayList<>();
        conditions.add("Exhaustion");
        conditions.add("Poisoned");
        List<String> senses = new ArrayList<>();
        senses.add("Darkvision");senses.add("Perception");
        List<String> languages = new ArrayList<>();
        languages.add("understands languages it knew in life but can’t speak");
        NPC skeleton = new NPC("Skeleton",13,13,6,30,skeletonSavingThrows,
                damage,imunities,conditions,senses,languages,50,attackAndSpellList);
        return skeleton;
    }
    public static NPC generateImp(){
        SavingThrows impSavingThrows = new SavingThrows(-2,3,1,0,1,2);
       List<AttackAndSpell> attackAndSpellList = new ArrayList<AttackAndSpell>();
        attackAndSpellList.add(new AttackAndSpell("invisibility",0,0));
        attackAndSpellList.add(new AttackAndSpell("sting ",5,3));
        attackAndSpellList.add(new AttackAndSpell("shapechanger(rat,raven,spider) ",0,0));
        List<String> damage = new ArrayList<>();
        damage.addAll(Arrays.asList("Bludgeoning","Cold","Piercing"));
        List<String> imunities = new ArrayList<>();
        imunities.addAll(Arrays.asList("Poison","Fire"));
        List<String> conditions = new ArrayList<>();
        conditions.addAll(Arrays.asList("Poisoned"));
        List<String> senses = new ArrayList<>();
        senses.add("Darkvision");senses.add("Perception");
        List<String> languages = new ArrayList<>();
        languages.addAll(Arrays.asList("Infernal","Common"));
        NPC imp = new NPC("Imp",13,10,6,20,impSavingThrows,
                damage,imunities,conditions,senses,languages,200,attackAndSpellList);
        return imp;
    }
    public static NPC generateIronGolem(){
        SavingThrows ironGolemSavingThrows = new SavingThrows(7,-1,5,-4,0,-5);
        List<AttackAndSpell> attackAndSpellList = new ArrayList<AttackAndSpell>();
        attackAndSpellList.add(new AttackAndSpell("sword attack",7,3));
        attackAndSpellList.add(new AttackAndSpell("slam ",7,3));
        attackAndSpellList.add(new AttackAndSpell("attack two times",0,0));
        List<String> damage = new ArrayList<>();
        damage.addAll(Arrays.asList("Bludgeoning","Piercing","Slashing From Nonmagical Attacks That Aren't Adamantine"));
        List<String> imunities = new ArrayList<>();
        imunities.addAll(Arrays.asList("Poison","Fire","Psychic"));
        List<String> conditions = new ArrayList<>();
        conditions.addAll(Arrays.asList("Poisoned","Charmed","Exhaustion","Petrified","Frightened","Paralyzed"));
        List<String> senses = new ArrayList<>();
        senses.add("Darkvision");senses.add("Perception");
        List<String> languages = new ArrayList<>();
        languages.addAll(Arrays.asList("Understands The Languages Of Its Creator But Can't Speak"));
       NPC ironGolem = new NPC(
                "Iron Golem", 12, 10,6, 20, ironGolemSavingThrows,damage,imunities,conditions,senses,languages,120,attackAndSpellList);

        return ironGolem;
    }
//    public static NPC generateMinotaur(){
//        SavingThrows minotaurSavingThrows = new SavingThrows(4,0,16,-2,3,-1);
//        Skills minotaurSkills = new Skills(0,0,0,0,0,0,0,0,0,0,0,7,0,0,0,0,0,0);
//        OtherProficienciesAndLanguages otherProficienciesAndLanguages = new OtherProficienciesAndLanguages("Abyssal","Natural Armor","Darkvision 60 Ft.","passive Perception 17");
//        List<AttackAndSpell> attackAndSpellList = new ArrayList<AttackAndSpell>();
//        attackAndSpellList.add(new AttackAndSpell("greataxe attack",6,4));
//        attackAndSpellList.add(new AttackAndSpell("gore attack ",6,4));
//        attackAndSpellList.add(new AttackAndSpell("charge attack",9,0));
//        String equipament = "natural armor\n"+
//                "greataxe";
//        String personalityTraits = "";
//        String ideals = "";
//        String bonds = "";
//        String flaws = "";
//        String featureAndTraits =
//                "Darkvision: 60 ft\n" +
//                        "Passive Perception 17\n" +
//                        "Labyrinthine Recall. The minotaur can perfectly recall any path it has traveled.\n" +
//                        "Reckless. At the start of its turn, the minotaur can gain advantage on all melee weapon attack rolls it makes during that turn, but attack rolls against it have advantage until the start of its next turn.";
//        NPC minotaur = new NPC(
//                "Minotaur", "chaotic evil", "Large monstrosity",0, 700, 18,
//                11, 16, 6, 16, 9, 17, 14, 0, 40,
//                100, attackAndSpellList, minotaurSavingThrows,minotaurSkills, otherProficienciesAndLanguages,
//                equipament, personalityTraits, ideals, bonds, flaws, featureAndTraits);
//        return minotaur;
//    }

}
