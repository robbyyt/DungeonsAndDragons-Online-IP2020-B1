package ServerControllers.gameProtocols.combat;

import DAO.DMDAO;
import DAO.UserDAO;
import com.google.gson.Gson;
import models.CombatMode;
import models.DM;
import models.NPC;
import models.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

public class beginCombat {
    public static JSONObject begincombat(JSONObject object ) throws ParseException {
        JSONArray players = null;
        String dm;
        try {
            players = (JSONArray) object.get("PLAYERS");
            dm = object.get("DM").toString();
        }
        catch (Exception e){
            return exceptionHandler();
        }

        List<NPC> npcs = new ArrayList<>();
        List<User >users = getListUsers(players);
        String [][] combatTable = initTable(10,10);
        CombatMode combatMode = new CombatMode(users,dm,npcs,combatTable);
        DM dungeonmaster = DMDAO.findById(dm);
        dungeonmaster.setCombatMode(combatMode);
        DMDAO.update(dungeonmaster);
        Gson gson = new Gson();
        String j = gson.toJson(dungeonmaster);
        JSONObject out = (JSONObject) new JSONParser().parse(j);
        return success(out);
    }

    static JSONObject success(JSONObject jsonObject){
        jsonObject.put("PROTOCOL","BEGIN_COMBAT");
        jsonObject.put("SUCCESS",1);
        return jsonObject;
    }



    static  String [][] initTable(int n,int m){
        String [][]table = new String[n][m];
        for(int i =0 ;i<n;i++){
            for(int j =0;j<m;j++){
                table[i][j]="_";
            }
        }
        return  table;
    }
    static List<User> getListUsers(JSONArray jsonArray){
        List<User> users = new ArrayList<>();
        for(int i = 0; i<jsonArray.size();i++){
            JSONObject jsonObject =  (JSONObject) jsonArray.get(i);
            String username = jsonObject.get("NAME").toString();
            User user = UserDAO.findUser(username);
            users.add(user);
        }
        return  users;
    }
    static private JSONObject exceptionHandler() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("PROTOCOL", "BEGIN_COMBAT");
        jsonObject.put("SUCCESS", 0);
        return jsonObject;
    }
}
