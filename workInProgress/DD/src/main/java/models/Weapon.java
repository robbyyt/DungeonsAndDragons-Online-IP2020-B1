package models;

public class Weapon {
    public String idPerWeapon(models.WeaponAndArms weaponAndArms){
        if(weaponAndArms.getName()=="dagger")
            weaponAndArms.setId("1");
        else if(weaponAndArms.getName()=="javelin")
            weaponAndArms.setId("2");
        else if(weaponAndArms.getName()=="crossbow light")
            weaponAndArms.setId("3");
        else if(weaponAndArms.getName()=="dart")
            weaponAndArms.setId("4");
        else if(weaponAndArms.getName()=="sling")
            weaponAndArms.setId("5");
        else if(weaponAndArms.getName()=="battleaxe")
            weaponAndArms.setId("6");
        else if(weaponAndArms.getName()=="greatsword")
            weaponAndArms.setId("7");
        else if(weaponAndArms.getName()=="longsword")
            weaponAndArms.setId("8");
        else if(weaponAndArms.getName()=="halberd")
            weaponAndArms.setId("9");
        else if(weaponAndArms.getName()=="blowgun")
            weaponAndArms.setId("10");

        return weaponAndArms.getId();
    }
}
