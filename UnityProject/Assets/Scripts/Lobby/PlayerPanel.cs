using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class PlayerPanel : MonoBehaviour
{
    public Text PlayerNumber;
    public Text PlayerLevel;
    public Text PlayerName;
    public Text PlayerRole;
    public Text MuteText;
    public LobbyPlayer LobbyPlayer { get; private set; }
    public LobbyPlayersManager manager;

    public void SetPlayer(LobbyPlayer player, int number)
    {
        LobbyPlayer = player;
        PlayerNumber.text = number.ToString();
        PlayerLevel.text = "Level: " + player.level;
        PlayerName.text = player.name;
        PlayerRole.text = player.role.ToString();
        UpdateMuteText();
    }

    public void MuteButton()
    {
        if(LobbyPlayer.muted)
        {
            UnmutePlayer();
        } else {
            MutePlayer();
        }
        UpdateMuteText();
    }

    private void MutePlayer()
    {
        LobbyPlayer.MutePlayer();
        UpdateMuteText();
    }

    private void UnmutePlayer()
    {
        LobbyPlayer.UnmutePlayer();
        UpdateMuteText();
    }

    private void UpdateMuteText()
    {
        MuteText.text = LobbyPlayer.muted ? "Unmute" : "Mute";
    }
    
    public void UpdateNumber(int newNumber)
    {
        PlayerNumber.text = newNumber.ToString();
    }

    public void Kick()
    {
        manager.KickPlayer(LobbyPlayer.id);
    }
}
