package DAO;
import models.Character;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import org.bson.types.ObjectId;

public class CharacterDAO {
    static String collectionName = "Character";
    public static ObjectId createNewCharacter(Character character){
        Gson gson = new Gson();
        String json = gson.toJson(character);
        DBObject dbObject = (DBObject) JSON.parse(json);
        return Database.createDocument(collectionName,dbObject);
    }
    public static Character findCharacterByIdAndName(ObjectId id, String name){
        Gson gson = new Gson();
        BasicDBObject query = new BasicDBObject();
        query.put("_id", id);
        query.put("name", name);
        DBObject character = Database.findDocument(collectionName,query);
         return gson.fromJson(character.toString(),Character.class);
    }

    public static Character findCharacterByName(String name){
        Gson gson = new Gson();
        BasicDBObject query = new BasicDBObject();
        query.put("name", name);
        DBObject character = Database.findDocument(collectionName,query);
        return gson.fromJson(character.toString(),Character.class);
    }

}
