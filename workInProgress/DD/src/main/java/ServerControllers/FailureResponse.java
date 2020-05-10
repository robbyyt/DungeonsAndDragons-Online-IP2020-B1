package ServerControllers;

import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FailureResponse {
    public static JSONObject unknown() {
        JSONObject json = new JSONObject();
        json.put("PROTOCOL", "NO_JSON_FORMAT");
        json.put("SUCCESS", 0);
        json.put("ANSWER", "Please send in a JSON format Or protocol doesn't exists");
        return json;
    }
}
