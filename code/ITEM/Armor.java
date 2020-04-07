package org.IP;

public class Armor extends Item {
    Armor(int id,Attributes attributes)
    {
     this.itemType= org.IP.itemType.ARMOR;
     this.id=id;
     this.attributes=attributes;
     this.attributes.setAttack(0);
    }
    Armor(String name,int id,Attributes attributes)
    {  this.name=name;
        this.itemType= org.IP.itemType.ARMOR;
        this.id=id;
        this.attributes=attributes;
        this.attributes.setAttack(0);
    }

    @Override
    public void setId(int id) {
        this.id=id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setAttributes(Attributes attributes) {
      this.attributes=attributes;
    }

    @Override
    public Attributes getAttributes() {
        return this.attributes;
    }
    @Override
    public String getItemType()
    {
        return itemType.toString();
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public String  getName() {
     return this.name;
    }

}
