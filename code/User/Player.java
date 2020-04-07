

public class Player extends User{
    //variables
    int id ;
    int level;
    int dice;
    int order ;
    Player(int id){
        this.id = id;
    }
    boolean connected;
    //List<Item>items ;
    // ChosenClass chosenClass;
    public void setLevel(int level) {
        this.level = level;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public void setDice(int dice) {
        this.dice = dice;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getDice() {
        return dice;
    }

    public int getLevel() {
        return level;
    }

    public int getId() {
        return id;
    }

    public int getOrder() {
        return order;
    }

    public int getDiceRoll(){
        return (int)Math.random()*dice;//return a value from 1 to dice number
    }
/*
    public Item dropItm(Item itm){
        return Item;
    }*/
    /*
    public void addItem(Item itm){
       items.add(itm);
    }*/
    /*
    public setChosenClass(chosenClass)
    {
        this.chosenClass= chosenClass;
    }*/

    /*
    public ChosenClass getChosenClass(){
        return this.chosenClass;
    }*/

}

