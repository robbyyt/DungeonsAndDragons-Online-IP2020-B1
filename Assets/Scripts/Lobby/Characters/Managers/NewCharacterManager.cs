using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class NewCharacterManager : MonoBehaviour
{
    public Role NewCharacterRole { get; private set; }
    public Text NewCharacterName;
    public CharactersManager CharactersManager;
    public void SetNewCharacterRole(Role characterRole)
    {
        NewCharacterRole = characterRole;
    }

    public void CreateNewCharacter()
    {
        Character newCharacter = null;
        switch(NewCharacterRole)
        {
            case Role.ARCHER: {
                    newCharacter = new Archer(NewCharacterName.text);
                    break;
                }
            case Role.WARRIOR: {
                    newCharacter = new Warrior(NewCharacterName.text);
                    break;
                }
            case Role.MAGE: {
                    newCharacter = new Mage(NewCharacterName.text);
                    break;
                }
            case Role.CLERIC: {
                    newCharacter = new Cleric(NewCharacterName.text);
                    break;
                }
            case Role.ROGUE: {
                    newCharacter = new Rogue(NewCharacterName.text);
                    break;
                }
        }
        if(newCharacter != null)
        {
            CharactersManager.AddCharacter(newCharacter);
            gameObject.SetActive(false);
        }
    }

    public void CloseWindow()
    {
        gameObject.SetActive(false);
    }
}
