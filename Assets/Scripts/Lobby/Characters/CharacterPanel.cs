using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class CharacterPanel : MonoBehaviour
{
    public Text CharacterName;
    public Text CharacterLevel;
    public Text CharacterRole;
    public Image CharacterImage;
    public CharactersManager manager;
    public Character Character { get; private set; }
  
    public void SetCharacter(Character character)
    {
        this.Character = character;
        CharacterName.text = Character.Name;
        CharacterLevel.text = "Level: " + Character.Level;
        CharacterRole.text = character.GetClassName();
        switch (character.GetClassName())
        {
            case "Warrior":
                {
                    CharacterImage.sprite = manager.WarriorImage;
                    break;
                }
            case "Rogue":
                {
                    CharacterImage.sprite = manager.RogueImage;
                    break;
                }
            case "Mage":
                {
                    CharacterImage.sprite = manager.MageImage;
                    break;
                }
            case "Cleric":
                {
                    CharacterImage.sprite = manager.ClericImage;
                    break;
                }
            case "Archer":
                {
                    CharacterImage.sprite = manager.ArcherImage;
                    break;
                }
        }      
    }

    public void SelectCharacter()
    {
        manager.BigCharacterView.gameObject.SetActive(true);
        manager.BigCharacterView.SetCharacterFromPanel(this);
    }
}
