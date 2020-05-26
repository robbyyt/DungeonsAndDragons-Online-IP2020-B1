package workInProgress.DD.src.main.java.utils;

public class ArmorGenerator {
    public static models.Armor generatePadded(String id){
        models.Armor padded = new models.Armor("padded", "Light Armour", "1", 50, 11, "dex modifier", 0, 8 );
        return padded;
    }
    public static models.Armor generateLeather(String id){
        models.Armor leather = new models.Armor("leather", "Light Armour", "2", 100, 11, "dex modifier", 0, 10 );
        return leather;
    }
    public static models.Armor generateStuddedLeather(String id){
        models.Armor studdedLeather = new models.Armor("studded leather", "Light Armour", "3", 450, 12, "dex modifier", 0, 13 );
        return studdedLeather;
    }
    public static models.Armor generateHide(String id){
        models.Armor hide = new models.Armor("hide", "Medium Armour", "4", 100, 12, "dex modifier-max2", 0, 12 );
        return hide;
    }
    public static models.Armor generateChainShirt(String id){
        models.Armor chainShirt = new models.Armor("chain shirt", "Medium Armour", "5", 500, 13, "dex modifier-max2", 0, 20 );
        return chainShirt;
    }
    public static models.Armor generateBreastPlate(String id){
        models.Armor breastPlate = new models.Armor("breast plate", "Medium Armour", "6", 4000, 14, "dex modifier-max2", 0, 20 );
        return breastPlate;
    }
    public static models.Armor generateHalfPlate(String id){
        models.Armor halfPlate = new models.Armor("half plate", "Medium Armour", "7", 7500, 15, "dex modifier-max2", 0, 40 );
        return halfPlate;
    }
    public static models.Armor generateRingMail(String id){
        models.Armor ringMail = new models.Armor("ring mail", "Heavy Armour", "8", 300, 14, " ", 0, 40 );
        return ringMail;
    }
    public static models.Armor generatePlate(String id){
        models.Armor plate = new models.Armor("plate", "Heavy Armour", "9", 150000, 18, " ", 15, 65 );
        return plate;
    }
    public static models.Armor generateSplint(String id){
        models.Armor splint = new models.Armor("splint", "Heavy Armour", "10", 2000, 17, " ", 15, 60 );
        return splint;
    }
    public static models.Armor generateShield(String id){
        models.Armor shield = new models.Armor("shield", "Shield", "11", 100, 2, " ", 0, 6);
        return shield;
    }

}
