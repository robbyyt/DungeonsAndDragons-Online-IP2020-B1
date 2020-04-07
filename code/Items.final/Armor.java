

public class Armor extends Item {
    Armor(int id,Attributes attributes)
    {
     this.itemType= ItemType.ARMOR;
     this.id=id;
     this.attributes=attributes;
     this.attributes.setAttackAttribute(0);
    }


}
