package org.IP;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      Item[] items=new Item[3];
      items[0]=new Weapon(1,new Attributes(10,0,5));
      items[1]=new Armor(2,new Attributes(0,20,-5));
      items[2]=new Weapon("Duskblade of Draktharr",3,new Attributes(60,0,0));
      System.out.println(items[0].getItemType());
      System.out.println(items[1].getItemType());
      System.out.println(items[2].getName());

    }
}
