package ServerControllers;

import org.json.simple.JSONObject;

public class Unkown {
    public JSONObject unknown(){
        JSONObject json = new JSONObject();
        json.put("PROTOCOL","UNKNOWN");
        json.put("ANSWER","Non existing protocol");
        json.put("SUCCES",0);
        return json;
    }
}
