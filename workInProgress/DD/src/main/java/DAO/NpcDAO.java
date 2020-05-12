package DAO;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import models.NPC;
import org.bson.types.ObjectId;

public class NpcDAO {
    static String collectionName = "NPC";
    public static ObjectId createNewNPC(NPC npc){
        Gson gson = new Gson();
        String json = gson.toJson(npc);
        DBObject dbObject = (DBObject) JSON.parse(json);
        return Database.createDocument(collectionName,dbObject);
    }
    public static NPC findNPCById(ObjectId id){
        Gson gson = new Gson();
        BasicDBObject query = new BasicDBObject();
        query.put("_id", id);
        DBObject npc = Database.findDocument(collectionName,query);
        return gson.fromJson(npc.toString(),NPC.class);
    }

    public static NPC findNPCByName(String name){
        Gson gson = new Gson();
        BasicDBObject query = new BasicDBObject();
        query.put("name", name);
        DBObject npc = Database.findDocument(collectionName,query);
        return gson.fromJson(npc.toString(),NPC.class);
    }
}
