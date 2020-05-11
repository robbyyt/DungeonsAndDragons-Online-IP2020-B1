package ServerControllers.gameProtocols.player;

import com.google.gson.JsonObject;
import controllers.CharacterController;
import controllers.UserController;
import models.Character;
import org.json.simple.JSONObject;

public class LevelUp {
    public void checkLevelUp(JsonObject object) {

        String playerID = object.get("PLAYER_ID").toString();
        String name = object.get("CHARACTER_NAME").toString();
        Character character = CharacterController.findCharacterByName(name);
        int experience = character.getExperiencePoints();
        int constitutionModifier = (character.getConstitution()-10)/2;
        int hitPointMaximum = character.getHitPointMaximum();
        int hitDie = 6; // ROLL UL UNUI DICE
        //modifier = (ability - 10) / 2 (rounded down)

        if (experience < 300) {
            character.setLevel(1);
            character.setProfienceBonus(2);
            hitPointMaximum += hitDie+constitutionModifier;
            character.setHitPointMaximum(hitPointMaximum);

        } else if (experience < 900) {
            character.setLevel(2);
            hitPointMaximum += hitDie+constitutionModifier;
            character.setHitPointMaximum(hitPointMaximum);

        } else if (experience < 2700) {
            character.setLevel(3);
            hitPointMaximum += hitDie+constitutionModifier;
            character.setHitPointMaximum(hitPointMaximum);

        } else if (experience < 6500) {
            character.setLevel(4);
            hitPointMaximum += hitDie+constitutionModifier;
            character.setHitPointMaximum(hitPointMaximum);

        } else if (experience < 14000) {
            character.setLevel(5);
            character.setProfienceBonus(3);
            hitPointMaximum += hitDie+constitutionModifier;
            character.setHitPointMaximum(hitPointMaximum);

        } else if (experience < 23000) {
            character.setLevel(6);
            hitPointMaximum += hitDie+constitutionModifier;
            character.setHitPointMaximum(hitPointMaximum);

        } else if (experience < 34000) {
            character.setLevel(7);
            hitPointMaximum += hitDie+constitutionModifier;
            character.setHitPointMaximum(hitPointMaximum);

        } else if (experience < 48000) {
            character.setLevel(8);
            hitPointMaximum += hitDie+constitutionModifier;
            character.setHitPointMaximum(hitPointMaximum);

        } else if (experience < 64000) {
            character.setLevel(9);
            character.setProfienceBonus(9);
            hitPointMaximum += hitDie+constitutionModifier;
            character.setHitPointMaximum(hitPointMaximum);

        } else if (experience < 85000) {
            character.setLevel(10);
            hitPointMaximum += hitDie+constitutionModifier;
            character.setHitPointMaximum(hitPointMaximum);

        } else if (experience < 100000) {
            character.setLevel(11);
            hitPointMaximum += hitDie+constitutionModifier;
            character.setHitPointMaximum(hitPointMaximum);

        } else if (experience < 120000) {
            character.setLevel(12);
            hitPointMaximum += hitDie+constitutionModifier;
            character.setHitPointMaximum(hitPointMaximum);

        } else if (experience < 140000) {
            character.setLevel(13);
            character.setProfienceBonus(5);
            hitPointMaximum += hitDie+constitutionModifier;
            character.setHitPointMaximum(hitPointMaximum);

        } else if (experience < 165000) {
            character.setLevel(14);
            hitPointMaximum += hitDie+constitutionModifier;
            character.setHitPointMaximum(hitPointMaximum);

        } else if (experience < 195000) {
            character.setLevel(15);
            hitPointMaximum += hitDie+constitutionModifier;
            character.setHitPointMaximum(hitPointMaximum);

        } else if (experience < 225000) {
            character.setLevel(16);
            hitPointMaximum += hitDie+constitutionModifier;
            character.setHitPointMaximum(hitPointMaximum);

        } else if (experience < 265000) {
            character.setLevel(17);
            hitPointMaximum += hitDie+constitutionModifier;
            character.setHitPointMaximum(hitPointMaximum);

            character.setProfienceBonus(6);
        } else if (experience < 305000) {
            character.setLevel(18);
            hitPointMaximum += hitDie+constitutionModifier;
            character.setHitPointMaximum(hitPointMaximum);

        } else if (experience < 355000) {
            character.setLevel(19);
            hitPointMaximum += hitDie+constitutionModifier;
            character.setHitPointMaximum(hitPointMaximum);

        } else {
            character.setLevel(20);
            hitPointMaximum += hitDie+constitutionModifier;
            character.setHitPointMaximum(hitPointMaximum);

        }

    }
}
