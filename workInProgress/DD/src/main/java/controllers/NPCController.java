package controllers;

import DAO.NpcDAO;
import models.NPC;
import org.bson.types.ObjectId;
import utils.NPCGenerator;

public class NPCController {
    public static ObjectId createNPCSkeleton(){
        NPC npc = NPCGenerator.generateSkeleton();
        return NpcDAO.createNewNPC(npc);
    }
    public static ObjectId createNPCImp(){
        NPC npc = NPCGenerator.generateImp();
        return NpcDAO.createNewNPC(npc);
    }
    public static ObjectId createNPCIronGolem(){
        NPC npc = NPCGenerator.generateIronGolem();
        return NpcDAO.createNewNPC(npc);
    }
    public static NPC findNPCById(ObjectId id){
        return NpcDAO.findNPCById(id);
    }
}
