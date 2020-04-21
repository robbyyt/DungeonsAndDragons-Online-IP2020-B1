package controllers;

import DAO.UserDAO;
import models.User;
import org.bson.types.ObjectId;

public class UserController {
    public static ObjectId createUser(String username){
        return UserDAO.createUser(username);
    }
    public static User findUser(String username){
        User user = UserDAO.findUser(username);
        return user;
    }
    public static void updateUser(User user){
        UserDAO.updateUser(user);
    }
}
