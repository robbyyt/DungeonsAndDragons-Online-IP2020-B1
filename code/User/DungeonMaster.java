package User;

import GameClass.Game;
import NPC.Npc;

import java.util.*;
public class DungeonMaster extends User
{
//Game game
    List<Player> playerList;
    List<Npc> npcs = new ArrayList<>();
    Game game;
    int turn;
    public DungeonMaster(int id ){
        this.id = id;
    }


    public void narate(Game game){
       System.out.println("some story actions here ");
    }


    public void end(){
       System.out.println("Ending the game");
    }


    void endTurn(){
        System.out.println("Ending the turn");
    }


    public void setPlayersOrder(List<Player> players){
        this.playerList= players;
    }

    public void addNpc(Npc npc){
        npcs.add(npc);
    }


    public void removeNpc(Npc npc){
        npcs.remove(npc);
    }


    public Npc getNpc(int id){
        for(Npc npc : npcs){
        if(npc.getId()==id)
            return npc;
        }
        return null;
    }

    public int diceRoll(Player player){
        return player.getDice();
    }

    public boolean isConnected(){
        if(game.checkConnection(id)){
            return true;
        }
        return false;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getTurn() {
        return turn;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setNpcs(List<Npc> npcs) {
        this.npcs = npcs;
    }

    public List<Npc> getNpcs() {
        return npcs;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
}
