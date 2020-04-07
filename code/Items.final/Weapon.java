

public class Weapon extends Item{
    Weapon(int id,Attributes attributes)
    {   this.itemType= itemType.WEAPON;
        this.id=id;
        this.attributes=attributes;
        this.attributes.setArmorAttribute(0);
    }

}
