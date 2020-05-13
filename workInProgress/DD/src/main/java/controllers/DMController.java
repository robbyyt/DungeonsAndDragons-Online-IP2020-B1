package controllers;

import DAO.DMDAO;
import DAO.LobbyDAO;
import models.DM;
import models.Lobby;
import org.bson.types.ObjectId;

import java.util.List;

public class DMController {
    public static ObjectId create(DM dm) { return DMDAO.create(dm); }
    public static void update(DM dm) { DMDAO.update(dm); }
    public static DM findById(String username) { return DMDAO.findById(username); }

}
