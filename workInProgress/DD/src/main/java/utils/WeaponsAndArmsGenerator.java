package utils;

import models.Weapon;
import models.WeaponAndArms;

public class WeaponsAndArmsGenerator {
    public static WeaponAndArms generateDagger(String id){
        String whyToUse="When Making an Attack with a finesse weapon, you use your choice of your Strength or Dexterity modifier for the Attack and Damage Rolls. You must use the same modifier for both rolls.\n"+
                "A light weapon is small and easy to handle, making it ideal for use when fighting with two Weapons.\n"+
                "If a weapon has the thrown property, you can throw the weapon to make a ranged Attack. If the weapon is a melee weapon, you use the same ability modifier for that Attack roll and damage roll that you would use for a melee Attack with the weapon. For example, if you throw a Handaxe, you use your Strength, but if you throw a Dagger, you can use either your Strength or your Dexterity, since the Dagger has the finesse property.";
        String weight="1 lb";
        String costAndDamage="1 sp, 1d4 bludgeoning ";
        Weapon weapon=new Weapon();
        WeaponAndArms dagger = new WeaponAndArms("dagger", "Simple Melee Weapons", "Finesse, light, thrown", whyToUse, weight, costAndDamage);
        weapon.idPerWeapon(dagger);
        return dagger;
    }
    public static WeaponAndArms generateJavelin(String id){
        String whyToUse="If a weapon has the thrown property, you can throw the weapon to make a ranged Attack. If the weapon is a melee weapon, you use the same ability modifier for that Attack roll and damage roll that you would use for a melee Attack with the weapon. For example, if you throw a Handaxe, you use your Strength, but if you throw a Dagger, you can use either your Strength or your Dexterity, since the Dagger has the finesse property.";
        String weight="2 lb";
        String costAndDamage="5 sp, 1d6 piercing ";
        Weapon weapon=new Weapon();
        WeaponAndArms javelin = new WeaponAndArms("javelin", "Simple Melee Weapons", "Thrown", whyToUse, weight, costAndDamage );
        weapon.idPerWeapon(javelin);
        return javelin;
    }
    public static WeaponAndArms generateCrossbowLight(String id){
        String whyToUse="You can use a weapon that has the Ammunition property to make a ranged Attack only if you have Ammunition to fire from the weapon. Each time you Attack with the weapon, you expend one piece of Ammunition. Drawing the Ammunition from a Quiver, case, or other container is part of the Attack (you need a free hand to load a one-handed weapon). At the end of the battle, you can recover half your expended Ammunition by taking a minute to Search the battlefield. If you use a weapon that has the Ammunition property to make a melee Attack, you treat the weapon as an Improvised Weapon\n"+
                "Because of the time required to load this weapon, you can fire only one piece of Ammunition from it when you use an action, Bonus Action, or Reaction to fire it, regardless of the number of attacks you can normally make.\n"+
                "This weapon requires two hands when you Attack with it.\n";
        String weight="5 lb";
        String costAndDamage="25 gp, 1d8 piercing ";
        Weapon weapon=new Weapon();
        WeaponAndArms crossbowLight = new WeaponAndArms("crossbow light", "Simple Ranged Weapons", "Ammunition, loading, two-handed", whyToUse, weight, costAndDamage );
        weapon.idPerWeapon(crossbowLight);
        return crossbowLight;
    }
    public static WeaponAndArms generateDart(String id){
        String whyToUse="When Making an Attack with a finesse weapon, you use your choice of your Strength or Dexterity modifier for the Attack and Damage Rolls. You must use the same modifier for both rolls.\n"+
                "If a weapon has the thrown property, you can throw the weapon to make a ranged Attack. If the weapon is a melee weapon, you use the same ability modifier for that Attack roll and damage roll that you would use for a melee Attack with the weapon. For example, if you throw a Handaxe, you use your Strength, but if you throw a Dagger, you can use either your Strength or your Dexterity, since the Dagger has the finesse property.";
        String weight="1/4 lb";
        String costAndDamage="5 cp, 1d4 piercing ";
        Weapon weapon=new Weapon();
        WeaponAndArms dart = new WeaponAndArms("dart", "Simple Ranged Weapons", "Finesse, thrown", whyToUse, weight, costAndDamage );
        weapon.idPerWeapon(dart);
        return dart;
    }
    public static WeaponAndArms generateSling(String id){
        String whyToUse="You can use a weapon that has the Ammunition property to make a ranged Attack only if you have Ammunition to fire from the weapon. Each time you Attack with the weapon, you expend one piece of Ammunition. Drawing the Ammunition from a Quiver, case, or other container is part of the Attack (you need a free hand to load a one-handed weapon). At the end of the battle, you can recover half your expended Ammunition by taking a minute to Search the battlefield. If you use a weapon that has the Ammunition property to make a melee Attack, you treat the weapon as an Improvised Weapon ";
        String weight="-";
        String costAndDamage="1 sp, 1d4 bludgeoning ";
        Weapon weapon=new Weapon();
        WeaponAndArms sling = new WeaponAndArms("sling", "Simple Ranged Weapons", "Ammunition", whyToUse, weight, costAndDamage );
        weapon.idPerWeapon(sling);
        return sling;
    }

    public static WeaponAndArms generateBattleaxe(String id){
        String whyToUse= "This weapon can be used with one or two hands. A damage value in parentheses appears with the property—the damage when the weapon is used with two hands to make a melee Attack.";
        String weight="4 lb";
        String costAndDamage="10 gp, 1d8 slashing ";
        Weapon weapon=new Weapon();
        WeaponAndArms battleaxe = new WeaponAndArms("battleaxe",  "Martial Melee Weapons", "Versatile", whyToUse, weight, costAndDamage );
        weapon.idPerWeapon(battleaxe);
        return battleaxe;
    }
    public static WeaponAndArms generateGreatSword(String id){
        String whyToUse="Small creatures have disadvantage on Attack rolls with heavy Weapons. A heavy weapon’s size and bulk make it too large for a Small creature to use effectively.\n"+
                "This weapon requires two hands when you Attack with it.";
        String weight="6 lb";
        String costAndDamage="50 gp, 2d6 slashing ";
        Weapon weapon=new Weapon();
        WeaponAndArms greatsword = new WeaponAndArms("greatsword",  "Martial Melee Weapons", "Heavy, two-handed", whyToUse, weight, costAndDamage );
        weapon.idPerWeapon(greatsword);
        return greatsword;
    }
    public static WeaponAndArms generateLongsword(String id){
        String whyToUse= "This weapon can be used with one or two hands. A damage value in parentheses appears with the property—the damage when the weapon is used with two hands to make a melee Attack.";
        String weight="4 lb";
        String costAndDamage="15 gp, 1d8 slashing ";
        Weapon weapon=new Weapon();
        WeaponAndArms longsword = new WeaponAndArms("longsword", "Martial Melee Weapons", "Versatile", whyToUse, weight, costAndDamage );
        weapon.idPerWeapon(longsword);
        return longsword;
    }
    public static WeaponAndArms generateHalberd(String id){
        String whyToUse= "Small creatures have disadvantage on Attack rolls with heavy Weapons. A heavy weapon’s size and bulk make it too large for a Small creature to use effectively.\n"+
                "This weapon requires two hands when you Attack with it.\n"+
                "This weapon adds 5 feet to your reach when you Attack with it, as well as when determining your reach for Opportunity Attacks with it.";
                String weight="6 lb";
        String costAndDamage="20 gp, 1d10 slashing ";
        Weapon weapon=new Weapon();
        WeaponAndArms halberd = new WeaponAndArms("halberd", "Martial Melee Weapons", "Heavy, reach, two-handed", whyToUse, weight, costAndDamage );
        weapon.idPerWeapon(halberd);
        return halberd;
    }
    public static WeaponAndArms generateBlowgun(String id){
        String whyToUse="You can use a weapon that has the Ammunition property to make a ranged Attack only if you have Ammunition to fire from the weapon. Each time you Attack with the weapon, you expend one piece of Ammunition. Drawing the Ammunition from a Quiver, case, or other container is part of the Attack (you need a free hand to load a one-handed weapon). At the end of the battle, you can recover half your expended Ammunition by taking a minute to Search the battlefield. If you use a weapon that has the Ammunition property to make a melee Attack, you treat the weapon as an Improvised Weapon ";
        String weight="1 lb";
        String costAndDamage="10 gp, 1 piercing ";
        Weapon weapon=new Weapon();
        WeaponAndArms blowgun = new WeaponAndArms("blowgun", "Martial Ranged Weapons", "Ammunition", whyToUse, weight, costAndDamage );
        weapon.idPerWeapon(blowgun);
        return blowgun;
    }
}
