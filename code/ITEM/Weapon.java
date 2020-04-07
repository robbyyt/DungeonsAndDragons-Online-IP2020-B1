package org.IP;

public class Weapon extends Item{
    Weapon(int id,Attributes attributes)
    {   this.itemType= org.IP.itemType.WEAPON;
        this.id=id;
        this.attributes=attributes;
        this.attributes.setArmor(0);
    }
    Weapon(String name,int id,Attributes attributes)
    {   this.name=name;
        this.itemType= org.IP.itemType.WEAPON;
        this.id=id;
        this.attributes=attributes;
        this.attributes.setArmor(0);
    }
    @Override
    public void setId(int id) {
    this.id=id;
    }

    @Override
    public int getId() {
        return id;
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
    public String getName() {
        return this.name;
    }
}
