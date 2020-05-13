package DAO;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import models.CombatMode;
import models.DM;
import org.bson.types.ObjectId;

public class DMDAO {
    static String collectionName = "DM";
    public static ObjectId create(DM dm){
        Gson gson = new Gson();
        String json = gson.toJson(dm);
        DBObject dbObject = (DBObject) JSON.parse(json);
        return Database.createDocument(collectionName,dbObject);
    }
    public static void update(DM dm){
        Gson gson = new Gson();
        String json = gson.toJson(dm);
        DBObject dbObject = (DBObject) JSON.parse(json);
        BasicDBObject query = new BasicDBObject();
        query.put("username", dm.getUsername());
        Database.updateDocument(collectionName,query,dbObject);
    }
    public static DM findById(String username){
        Gson gson = new Gson();
        BasicDBObject query = new BasicDBObject();
        query.put("username", username);
        DBObject dbObject = Database.findDocument(collectionName,query);
        DM dm= gson.fromJson(dbObject.toString(),DM.class);
        return dm;
    }
}
