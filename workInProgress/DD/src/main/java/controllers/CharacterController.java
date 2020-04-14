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
    public static Character findCharacterByIdAndName(ObjectId id, String name){
        return CharacterDAO.findCharacterByIdAndName(id,name);
    }
}
