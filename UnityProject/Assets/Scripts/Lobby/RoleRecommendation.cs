using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

[System.Serializable]
public enum Role
{
    MAGE, WARRIOR, CLERIC, ROGUE, ARCHER, UNKNOWN, ADMIN
}

public class RoleRecommendation : MonoBehaviour
{
    public Role Role;
    public Text CurrentNumberOfPlayersText;
    public Text MaxNumberOfPlayersText;
    public Text RoleNameText;
    public Slider MaxNumberOfPlayersSlider;
    private int CurrentNumberOfPlayers;
    private int MaxNumberOfPlayers;

    public void Awake()
    {
        CurrentNumberOfPlayers = 0;
        MaxNumberOfPlayers = 0;
        UpdateTexts();
    }

    private void UpdateTexts()
    {
        CurrentNumberOfPlayersText.text = CurrentNumberOfPlayers.ToString();
        MaxNumberOfPlayersText.text = "/" + MaxNumberOfPlayers.ToString();
        if(CurrentNumberOfPlayers == MaxNumberOfPlayers)
        {
            CurrentNumberOfPlayersText.color = Color.green;
            MaxNumberOfPlayersText.color = Color.green;
            RoleNameText.color = Color.green;
        } else if (CurrentNumberOfPlayers > MaxNumberOfPlayers)
        {
            CurrentNumberOfPlayersText.color = Color.red;
            MaxNumberOfPlayersText.color = Color.red;
            RoleNameText.color = Color.red;
        } else
        {
            CurrentNumberOfPlayersText.color = Color.white;
            MaxNumberOfPlayersText.color = Color.white;
            RoleNameText.color = Color.white;
        }
    }

    public void UpdateMaxPlayers()
    {
        MaxNumberOfPlayers = (int)MaxNumberOfPlayersSlider.value;
        UpdateTexts();
    }

    public void UpdateCurrentNumberOfPlayers(int number)
    {
        Debug.Log(Role.ToString() + " " + number.ToString());
        CurrentNumberOfPlayers = number;
        UpdateTexts();
    }

    public void HideSlider()
    {
        MaxNumberOfPlayersSlider.gameObject.SetActive(false);
    }

    public void ShowSlider()
    {
        MaxNumberOfPlayersSlider.gameObject.SetActive(true);
    }

}
