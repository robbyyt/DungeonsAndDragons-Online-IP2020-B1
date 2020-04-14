package DAO;
import models.Character;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import org.bson.types.ObjectId;

public class CharacterDAO {
    public static ObjectId createNewCharacter(Character character){
        String collectionName = "Character";
        Gson gson = new Gson();
        String json = gson.toJson(character);
        DBObject dbObject = (DBObject) JSON.parse(json);
        Database.connect();
        return Database.createDocument(collectionName,dbObject);
    }
    public static Character findCharacterByIdAndName(ObjectId id, String name){
        Gson gson = new Gson();
        String collectionName = "Character";
        BasicDBObject query = new BasicDBObject();
        query.put("_id", id);
        query.put("name", name);
        Database.connect();
        DBObject character = Database.findDocument(collectionName,query);
        Character character1= gson.fromJson(character.toString(),Character.class);
        return character1;
    }

}
