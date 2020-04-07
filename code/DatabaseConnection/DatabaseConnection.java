import java.util.ArrayList;
import java.util.List;

    public class DatabaseConnection {
    List<List<String>> data = new ArrayList<>();
    List<User> users;
    String db_URI = "localhost@test.com";
    public void updateUserData(){
        //must be implemented
    }
    public void getDataUser(){
        //must be implemented
    }

    public void insertGameData(List<List<String>> data){
        //must be implemented

    }

    public void insertUserData(int id, List<List<String>> data){
        //must be implemented

    }

    public boolean checkInput(List<List<String>>data){
        //will check if the input from user is matching the db data;
        return true;
    }
}
