package DAO;
import models.User;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    static String collectionName = "User";

    public static ObjectId createUser(String username){
        BasicDBObject document = new BasicDBObject();
        document.put("username",username);
        List<String> array = new ArrayList<String>();
        document.put("charactersId",array);
         return Database.createDocument(collectionName,document);
    }
    public static User findUser(String username){
        Gson gson = new Gson();
        BasicDBObject query = new BasicDBObject();
        query.put("username", username);
        Database.connect();
        DBObject user = Database.findDocument(collectionName,query);
        User user1 = gson.fromJson(user.toString(), User.class);
        return user1;
    }
    public static void updateUser(User user){
        Gson gson = new Gson();
        String json = gson.toJson(user);
        DBObject dbObject = (DBObject) JSON.parse(json);
        BasicDBObject query = new BasicDBObject();
        query.put("username", user.getUsername());
        Database.connect();
        Database.updateDocument(collectionName,query,dbObject);
    }
}
