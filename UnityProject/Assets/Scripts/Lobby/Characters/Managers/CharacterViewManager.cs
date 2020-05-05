using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class CharacterViewManager : MonoBehaviour
{
    public Text CharacterName;
    public Image CharacterImage;
    public Text CharacterRole;
    public Text Strength;
    public Text Dexterity;
    public Text Constiturion;
    public Text Inteligence;
    public Text Wisdom;
    public Text Charisma;
    public CurrentPlayer currentPlayer;
    public void SetCharacterFromPanel(CharacterPanel characterPanelSource)
    {
        Character character = characterPanelSource.Character;
        CharacterName.text = character.Name;
        CharacterImage.sprite = characterPanelSource.CharacterImage.sprite;
        CharacterRole.text = character.GetClassName();
        Strength.text = character.Strength.ToString();
        Dexterity.text = character.Dexterity.ToString();
        Constiturion.text = character.Constiturion.ToString();
        Inteligence.text = character.Inteligence.ToString();
        Wisdom.text = character.Wisdom.ToString();
        Charisma.text = character.Charisma.ToString();
        Debug.Log("sadA");
        gameObject.SetActive(true);
        currentPlayer.UpdateRole(character.GetRole());
    }
    
}
