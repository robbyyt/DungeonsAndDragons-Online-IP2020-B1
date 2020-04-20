package controllers;

import DAO.LobbyDAO;
import models.Lobby;
import org.bson.types.ObjectId;

public class LobbyController {

    public static ObjectId create(Lobby lobby) {
        return LobbyDAO.create(lobby);
    }

    public static void update(Lobby lobby) {
        LobbyDAO.update(lobby);
    }
    public static Lobby findById(ObjectId id) {
        return LobbyDAO.findById(id);
    }
}
