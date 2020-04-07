
import java.util.*;
public class PlayerInput {
    int socket ; // in java this is not int, we just build the skelet to build on
    List<List<String>> data = new ArrayList<>();

    List<List<String>>getInput(){
        return data;
    }

    void receiveInput(){
        //socket receiving implementation
    }

    boolean checkInput(DatabaseConnection db){
        return db.checkInput(data);
    }
}
