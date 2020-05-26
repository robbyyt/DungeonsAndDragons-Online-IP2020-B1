package utils;

public class WeaponsGenerator {
    public static models.Weapons generateDagger(String id){
        int cost=20;
        int dice=4;
        int weight=1;
        models.Weapons dagger = new models.Weapons("dagger", "1", "Simple Melee Weapons", cost, dice, "Finesse, light, thrown", weight);
        return dagger;
    }
    public static models.Weapons generateJavelin(String id){
        int cost=5;
        int dice=6;
        int weight=2;
        models.Weapons javelin = new models.Weapons("javelin", "2", "Simple Melee Weapons", cost, dice, "Thrown", weight);
        return javelin;
    }
    public static models.Weapons generateCrossbowLight(String id){
        int cost=250;
        int dice=8;
        int weight=5;
        models.Weapons crossbowLight = new models.Weapons("crossbow light", "3", "Simple Melee Weapons", cost, dice,"Ammunition, loading, two-handed", weight);
        return crossbowLight;
    }
    public static models.Weapons generateDart(String id){
        int cost=500;
        int dice=4;
        int weight=1;
        models.Weapons dart = new models.Weapons("dart", "4", "Simple Ranged Weapons", cost, dice,"Finesse, thrown", weight);
        return dart;
    }
    public static models.Weapons generateSling(String id){
        int cost=1;
        int dice=4;
        int weight=0;
        models.Weapons sling = new models.Weapons("sling", "5", "Simple Ranged Weapons", cost, dice,"Ammunition", weight);
        return sling;
    }

    public static models.Weapons generateBattleaxe(String id){
        int cost=100;
        int dice=8;
        int weight=4;
        models.Weapons battleaxe = new models.Weapons("battleaxe", "6", "Martial Melee Weapons", cost, dice,"Versatile", weight );
        return battleaxe;
    }
    public static models.Weapons generateGreatSword(String id){
        int cost=500;
        int dice=12;
        int weight=6;
        models.Weapons greatsword = new models.Weapons("greatsword", "7",  "Martial Melee Weapons", cost, dice, "Heavy, two-handed", weight);
        return greatsword;
    }
    public static models.Weapons generateLongsword(String id){
        int cost=150;
        int dice=8;
        int weight=3;
        models.Weapons longsword = new models.Weapons("longsword", "8", "Martial Melee Weapons",  cost, dice,"Versatile", weight );
        return longsword;
    }
    public static models.Weapons generateHalberd(String id){
        int cost=200;
        int dice=10;
        int weight=6;
        models.Weapons halberd = new models.Weapons("halberd", "9", "Martial Melee Weapons", cost, dice, "Heavy, reach, two-handed", weight);
        return halberd;
    }
    public static models.Weapons generateBlowgun(String id){
        int cost=100;
        int dice=1;
        int weight=1;
        models.Weapons blowgun = new models.Weapons("blowgun", "10", "Martial Ranged Weapons", cost, dice, "Ammunition", weight);
        return blowgun;
    }

}
