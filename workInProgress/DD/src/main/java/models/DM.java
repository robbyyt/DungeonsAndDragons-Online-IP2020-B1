package models;

public class DM {
    String username;
    CombatMode combatMode;
    public void setCombatMode(CombatMode combatMode) {
        this.combatMode = combatMode;
    }

    public CombatMode getCombatMode() {
        return combatMode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
