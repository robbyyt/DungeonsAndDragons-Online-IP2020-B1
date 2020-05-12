package DAO;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import models.CombatMode;
import org.bson.types.ObjectId;

public class CombatModeDAO {
    static String collectionName = "CombatMode";
    public static ObjectId create(CombatMode combatMode){
        Gson gson = new Gson();
        String json = gson.toJson(combatMode);
        DBObject dbObject = (DBObject) JSON.parse(json);
        return Database.createDocument(collectionName,dbObject);
    }
    public static void update(CombatMode combatMode){
        Gson gson = new Gson();
        String json = gson.toJson(combatMode);
        DBObject dbObject = (DBObject) JSON.parse(json);
        BasicDBObject query = new BasicDBObject();
        query.put("_id", combatMode.getId());
        Database.updateDocument(collectionName,query,dbObject);
    }
    public static CombatMode findById(ObjectId id){
        Gson gson = new Gson();
        BasicDBObject query = new BasicDBObject();
        query.put("_id", id);
        DBObject dbObject = Database.findDocument(collectionName,query);
        CombatMode combatMode= gson.fromJson(dbObject.toString(),CombatMode.class);
        return combatMode;
    }
}
