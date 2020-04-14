package models;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class User {
    String username;
    Character character;
    List<String> charactersId;
    User(String username, Character character){
        this.username=username;
        this.character = character;
        charactersId = new ArrayList<String>();
    }
    User(String username,List<String>  characters){
        this.username=username;
        this.charactersId.addAll(characters);
    }

    public List<String> getCharactersId() {
        return charactersId;
    }

    public void setCharactersId(List<String> charactersId) {
        if (this.charactersId == null)this.charactersId= new ArrayList<String>();
        this.charactersId.addAll(charactersId);
    }

    public void setCharacterId(String id){
        if (this.charactersId == null)this.charactersId= new ArrayList<String>();
        this.charactersId.add(id);
    }
    public String getUsername() {
        return username;
    }
}
