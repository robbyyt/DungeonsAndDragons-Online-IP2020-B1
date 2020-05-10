package controllers;

import DAO.CharacterDAO;
import utils.CharacterGenerator;
import models.*;
import models.Character;
import org.bson.types.ObjectId;

import java.util.*;

public class CharacterController {
    public static ObjectId createCharacterBarbarian() {
        Character barbarian = CharacterGenerator.generateBarbarian();
        return CharacterDAO.createNewCharacter(barbarian);
    }
    public static ObjectId createCharacterCleric() {
        Character cleric = CharacterGenerator.generateCleric();
        return CharacterDAO.createNewCharacter(cleric);
    }
    public static ObjectId createCharacterFighter() {
        Character fighter = CharacterGenerator.generateFighter();
        return CharacterDAO.createNewCharacter(fighter);
    }
    public static ObjectId createCharacterPaladin() {
        Character paladin = CharacterGenerator.generatePaladin();
        return CharacterDAO.createNewCharacter(paladin);
    }
    public static ObjectId createCharacterWarlock() {
        Character warlock = CharacterGenerator.generateWarlock();
        return CharacterDAO.createNewCharacter(warlock);
    }
    public static Character findCharacterByIdAndName(ObjectId id, String name){
        return CharacterDAO.findCharacterByIdAndName(id,name);
    }

}
/*
MOBI
    IMP
    SKELETET
    GOLEM
    MINI-GOLEM
ACTIUNI:
    COMBAT:
        MOVEMENT: -
    IMPLEMENTAT SPELURI
    IMPLEMENTAT ARME
    MOBS: AU UN HP CAP CARE REPREZINTA HIT-UL, DACA DA ZARUL
    ALEGEM ACTIUNEA
    FIREBAL;
    ATTACK:DICE+ ARMA DMG /SPELL
    HEAL : DICE
    SPELL HEAL;
    LONG SWORD,
    SHORT SWORD
    TABLA DIN COMBAT DECIDERE DIMENSIUNE
 */

