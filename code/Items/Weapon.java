package Items;

public class Weapon extends Item{
    Weapon(int id,Attributes attributes)
    {   this.itemType= ItemType.WEAPON;
        this.id=id;
        this.attributes=attributes;
        this.attributes.setArmorAttribute(0);
    }

}
