using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using System.Linq;

public class CharactersManager : MonoBehaviour
{
    private List<GameObject> characterPanels;
    public GameObject CharacterPanelPrefab;
    public Sprite WarriorImage;
    public Sprite MageImage;
    public Sprite ClericImage;
    public Sprite RogueImage;
    public Sprite ArcherImage;

    public GameObject CharactersListView;
    public CharacterViewManager BigCharacterView;
    public ToggleGroup CharacterPanelsToggleGroup;

    public NewCharacterManager NewCharacterManager;

    public void Start()
    {
        characterPanels = new List<GameObject>();
        AddCharacter(new Mage("Mock mage"));
        AddCharacter(new Rogue("Mock Rogue"));
        AddCharacter(new Warrior("Mock war"));
        AddCharacter(new Cleric("Cleric"));
        AddCharacter(new Archer("Archer"));
    }

    public void AddCharacter(Character character)
    {
        GameObject pane = Instantiate(CharacterPanelPrefab, Vector3.zero, Quaternion.identity, CharactersListView.transform);
        pane.GetComponent<CharacterPanel>().manager = this;
        pane.GetComponent<CharacterPanel>().SetCharacter(character);
        pane.GetComponent<Toggle>().group = CharacterPanelsToggleGroup;
        characterPanels.Add(pane);
    }

    public void DeleteCharacter()
    {
        GameObject CharacterToDelete = characterPanels.First(x => x.GetComponent<Toggle>().isOn);
  
        if(CharacterToDelete != null)
        {
            characterPanels.Remove(CharacterToDelete);
            Destroy(CharacterToDelete);
            BigCharacterView.gameObject.SetActive(false);
        }
    }

    public void OpenNewCharacterWindow()
    {
        NewCharacterManager.gameObject.SetActive(true);
    }
}
