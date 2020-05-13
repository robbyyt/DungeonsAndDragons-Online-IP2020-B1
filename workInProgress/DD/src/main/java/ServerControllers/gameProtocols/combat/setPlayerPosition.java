package ServerControllers.gameProtocols.combat;

import DAO.DMDAO;
import models.CombatMode;
import models.DM;
import org.json.simple.JSONObject;

public class setPlayerPosition {
    public static  JSONObject setPlayerPosition (JSONObject object)
    {

        String dm=null;
        String playerId=null;
        int position_x=0;
        int position_y=0;
        try {
            dm = object.get("DM").toString();
            position_x = Integer.valueOf(object.get("POS_X").toString());
            position_y = Integer.valueOf(object.get("POS_Y").toString());
            playerId = object.get("PLAYER_ID").toString();
        }
        catch (Exception e){
            return  exceptionHandler();
        }

        DM dun = DMDAO.findById(dm);
        CombatMode cbm = dun .getCombatMode();
        String table [][] = cbm.getCombatTable();
        if(table[position_x][position_y]!="_")
            return samePosition();
        table[position_x][position_y]=playerId;
        cbm.setCombatTable(table);
        dun.setCombatMode(cbm);
        DMDAO.update(dun);
        return  success();
    }

    static JSONObject success(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("PROTOCOL","SET_PLAYER_POSITION");
        jsonObject.put("SUCCESS",1);
        return jsonObject;
    }
    static private JSONObject exceptionHandler() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("PROTOCOL", "SET_PLAYER_POSITION");
        jsonObject.put("SUCCESS", 0);
        jsonObject.put("ANSWER", "WRONG DATA");
        return jsonObject;
    }
    static private JSONObject samePosition(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("PROTOCOL", "SET_NPC");
        jsonObject.put("SUCCESS", 0);
        jsonObject.put("ANSWER", "POSITION_COLIDE");
        return jsonObject;
    }
}
