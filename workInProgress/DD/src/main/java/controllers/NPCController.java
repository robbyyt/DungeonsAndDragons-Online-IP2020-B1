package controllers;

import DAO.NpcDAO;
import models.NPC;
import org.bson.types.ObjectId;
import utils.NPCGenerator;

public class NPCController {
    public static NPC createNPCSkeleton(){
        NPC npc = NPCGenerator.generateSkeleton();
        return npc;
    }
    public static NPC createNPCImp(){
        return NPCGenerator.generateImp();
    }
    public static NPC createNPCIronGolem(){
        NPC npc = NPCGenerator.generateIronGolem();
        return npc;
    }
    public static NPC findNPCById(ObjectId id){
        return NpcDAO.findNPCById(id);
    }
}
