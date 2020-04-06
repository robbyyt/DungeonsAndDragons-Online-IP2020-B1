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
    public LobbyPlayer lobbyPlayer { get; private set; }

    public void SetPlayer(LobbyPlayer player, int number)
    {
        lobbyPlayer = player;
        PlayerNumber.text = number.ToString();
        PlayerLevel.text = "Level: " + player.level;
        PlayerName.text = player.name;
        PlayerRole.text = player.role;
        UpdateMuteText();
    }

    public void MuteButton()
    {
        if(lobbyPlayer.muted)
        {
            UnmutePlayer();
        } else {
            MutePlayer();
        }
        UpdateMuteText();
    }

    private void MutePlayer()
    {
        lobbyPlayer.MutePlayer();
        UpdateMuteText();
    }

    private void UnmutePlayer()
    {
        lobbyPlayer.UnmutePlayer();
        UpdateMuteText();
    }

    private void UpdateMuteText()
    {
        MuteText.text = lobbyPlayer.muted ? "Unmute" : "Mute";
    }
    
    public void UpdateNumber(int newNumber)
    {
        PlayerNumber.text = newNumber.ToString();
    }

    public void Kick()
    {
        LobbyPlayersManager.KickPlayer(lobbyPlayer.id);
    }
}
