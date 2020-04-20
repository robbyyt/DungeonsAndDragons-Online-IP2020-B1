package DAO;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import models.Character;
import models.Lobby;
import models.User;
import org.bson.types.ObjectId;

public class LobbyDAO {
    static String collectionName = "Lobby";
    public static ObjectId create(Lobby lobby){
        Gson gson = new Gson();
        String json = gson.toJson(lobby);
        DBObject dbObject = (DBObject) JSON.parse(json);
        Database.connect();
        return Database.createDocument(collectionName,dbObject);
    }
    public static void update(Lobby lobby){
        Gson gson = new Gson();
        String json = gson.toJson(lobby);
        DBObject dbObject = (DBObject) JSON.parse(json);
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(lobby.getId()));
        Database.connect();
        Database.updateDocument(collectionName,query,dbObject);
    }
    public static Lobby findById(ObjectId id){
        Gson gson = new Gson();
        BasicDBObject query = new BasicDBObject();
        query.put("_id", id);
        Database.connect();
        DBObject dbObject = Database.findDocument(collectionName,query);
        Lobby lobby= gson.fromJson(dbObject.toString(),Lobby.class);
        return lobby;
    }
}
