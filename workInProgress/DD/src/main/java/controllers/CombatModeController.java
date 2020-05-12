package controllers;

import DAO.CombatModeDAO;
import models.CombatMode;
import org.bson.types.ObjectId;

public class CombatModeController {
    public static ObjectId create(CombatMode combatMode) {
        return CombatModeDAO.create(combatMode);
    }
    public static void update(CombatMode combatMode) {
        CombatModeDAO.update(combatMode);
    }
    public static CombatMode findById(ObjectId id) {
        return CombatModeDAO.findById(id);
    }
}
