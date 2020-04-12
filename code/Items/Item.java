package Items;

import java.util.jar.Attributes;

public abstract class Item {
     protected String name;
     protected int id;
     protected Items.Attributes attributes;
     protected ItemType itemType;
     public  void setId(int id)
     {
         this.id=id;
     }
     public  int getId()
     {
          return id;
     }

     public void setAttributes(Attributes attributes)
     {
          this.attributes= (Items.Attributes) attributes;
     }
     public Attributes getAttributes()
     {
          return attributes;
     }
     public String getItemType()
     {
          return itemType.toString();
     }

}
