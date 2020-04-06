using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System;
using System.Linq;

public class LobbyPlayersManager : MonoBehaviour
{
    /// <summary>
    /// mock list of players
    /// </summary>
    private List<LobbyPlayer> lobbyPlayers = new List<LobbyPlayer>
    {
        new LobbyPlayer(Guid.NewGuid(), 102, "Sparg Copacu", "Mage"),
        new LobbyPlayer(Guid.NewGuid(), 12, "Rup Brandu", "Warior"),
        new LobbyPlayer(Guid.NewGuid(), 45, "Dau cu Sapa", "Cleric"),
        new LobbyPlayer(Guid.NewGuid(), 13, "Rup Lopata", "Rogue"),
    };

    private static List<GameObject> playerPanels;
    public GameObject playerPane;
    public GameObject playersScrollArea;
    private static int playersNumber;
    void Start()
    {
        playerPanels = new List<GameObject>();
        playersNumber = 1;
        lobbyPlayers.ForEach(player => {
            AddPlayerToLobby(player);
        });
    }

    public void AddPlayerToLobby(LobbyPlayer player)
    {
        GameObject pane = Instantiate(playerPane, Vector3.zero, Quaternion.identity, playersScrollArea.transform);
        pane.GetComponent<PlayerPanel>().SetPlayer(player, playersNumber);
        playersNumber += 1;
        playerPanels.Add(pane);
    }

    public void AddMockPlayer()
    {
        GameObject pane = Instantiate(playerPane, Vector3.zero, Quaternion.identity, playersScrollArea.transform);
        pane.GetComponent<PlayerPanel>().SetPlayer(new LobbyPlayer(Guid.NewGuid(), 13, "Mock Player", "sda"), playersNumber);
        playersNumber += 1;
        playerPanels.Add(pane);
    }

    public static void KickPlayer(Guid id)
    {
        GameObject playerPanelToDelete = playerPanels
            .FirstOrDefault(x => x.GetComponent<PlayerPanel>().lobbyPlayer.id == id);
        playerPanels.Remove(playerPanelToDelete);
        Destroy(playerPanelToDelete);
    }
  
}
