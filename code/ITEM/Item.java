package org.IP;

public abstract class Item {
     protected String name;
     protected int id;
     protected Attributes attributes;
     protected itemType itemType;
     public abstract void setId(int id);
     public abstract int getId();
     public abstract void setAttributes(Attributes attributes);
     public abstract Attributes getAttributes();
     public abstract String getItemType();
     public abstract void setName(String name);
     public abstract String getName();



}
