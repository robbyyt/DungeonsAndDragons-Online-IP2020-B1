import java.util.*;
public class DungeonMaster extends User
{
//Game game
    int id;
    List<Player> playerList;
    //List<Npc> nps = new ArrayList<>();
    public DungeonMaster(int id ){
        this.id = id;
    }

    /*
    public void narate(Game game){
       System.out.println('some story actions here ');
    }*/
    /*

    public void end(Game game){
       System.out.println('Ending the game');
    }
     */
    /*
    void endTurn(Game game){
    }
     */

    public void setPlayersOrder(List<Player> players){
        this.playerList= players;
    }
    /*
    public void addNpc(Npc npc){
        npcs.add(npc);
    }
     */
    /*
    public void removeNpc(Npc npc){
        npc.remove(npc);
    }
     */
    /*
    public Npc getNpc(id){
        for(Npc npc : npcs){
        if(npc.getId()==id)
        return nr;
        }
        return null;
    }
     */
    public int diceRoll(Player player){
        return player.getDice();
    }

    public boolean isConnected(){
        /*
        if(game.checkConnection(id)){
            return true;
        }*/
        return false;
    }
    





}
