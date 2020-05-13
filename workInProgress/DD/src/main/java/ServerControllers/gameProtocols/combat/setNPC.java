package ServerControllers.gameProtocols.combat;

import DAO.DMDAO;
import controllers.NPCController;
import models.CombatMode;
import models.DM;
import models.NPC;
import org.json.simple.JSONObject;
import java.util.List;


public class setNPC {
    static String npcs[]={"IMP","SKELETON","IRONGOLEM"};
    public static JSONObject setNPC(JSONObject object){
        String npc=null;
        String dm=null;
        int position_x=0;
        int position_y=0;
    try {
            npc = object.get("NPC_NAME").toString();
            dm = object.get("DM").toString();
            position_x = Integer.valueOf(object.get("POS_X").toString());
            position_y = Integer.valueOf(object.get("POS_Y").toString());
        }
    catch (Exception e){
        exceptionHandler();
    }
        NPC npc1= null;
        if(npc.compareTo("IMP")==0){
            npc1 = NPCController.createNPCImp();
        }else if(npc.compareTo("SKELETON")==0){
            npc1=NPCController.createNPCSkeleton();
        }else if(npc.compareTo("IRONGOLEM")==0){
            npc1=NPCController.createNPCIronGolem();
        }
        DM dun = DMDAO.findById(dm);
        CombatMode cbm = dun .getCombatMode();
        String table [][] = cbm.getCombatTable();
        List<NPC> npclist = cbm.getNpcs();
        if(table[position_x][position_y]!="_")
            return samePosition();
        table[position_x][position_y]=Integer.toString(genId(npclist,npc));
        npclist.add(npc1);
        cbm.setCombatTable(table);
        cbm.setNpcs(npclist);
        dun.setCombatMode(cbm);
        DMDAO.update(dun);
        return succes(table[position_x][position_y]);
    }
    static private JSONObject succes(String npcId){
        JSONObject json = new JSONObject();
        json.put("NPC_NAME",npcId);
        //json.put("STATS",);
        json.put("PROTOCOL", "SET_NPC");
        json.put("SUCCESS", 1);
        json.put("ANSWER", "SUCCESFULLY GENERATED AN NPC");
        return json;
    }

    static private JSONObject failure(){
        JSONObject json = new JSONObject();
        json.put("PROTOCOL", "SET_NPC");
        json.put("SUCCESS", 0);
        json.put("ANSWER", "NO KNOWN ENTITY");
        return json;
    }
    static private JSONObject exceptionHandler() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("PROTOCOL", "SET_NPC");
        jsonObject.put("SUCCESS", 0);
        jsonObject.put("ANSWER", "WRONG DATA");
        return jsonObject;
    }

  static int genId(List<NPC> npcs,String type){
        int id =0 ;
        for(NPC npc : npcs)
        {
            if(npc.getName().compareTo(type)==0){
                if(id<npc.getId()){
                    id = npc.getId();
                }
            }
        }
        return id+1;
  }
  static private JSONObject samePosition(){
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("PROTOCOL", "SET_NPC");
      jsonObject.put("SUCCESS", 0);
      jsonObject.put("ANSWER", "POSITION_COLIDE");
      return jsonObject;
  }
}
