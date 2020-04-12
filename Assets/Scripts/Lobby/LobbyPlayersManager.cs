using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using UnityEngine;
using UnityEngine.UI;

public class LobbyPlayersManager : MonoBehaviour
{
    private List<GameObject> playerPanels;
    private int playersNumber;

    public GameObject playerPanePrefab;
    public GameObject playersScrollArea;
    public LobbyManager lobbyManager;

    public void Start()
    {
        playerPanels = new List<GameObject>();
        playersNumber = 1;
        Enumerable.Repeat(1, 5).ToList().ForEach(x => AddMockPlayer());
    }

    public void AddPlayerToLobby(LobbyPlayer player)
    {
        GameObject pane = Instantiate(playerPanePrefab, Vector3.zero, Quaternion.identity, playersScrollArea.transform);
        pane.GetComponent<PlayerPanel>().SetPlayer(player, playersNumber);
        pane.GetComponent<PlayerPanel>().manager = this;
        playersNumber += 1;
        playerPanels.Add(pane);
        lobbyManager.UpdatePlayerReccomandationRoles();
    }

    public void AddMockPlayer()
    {
        AddPlayerToLobby(new LobbyPlayer(Guid.NewGuid(), 13, "Mock Player " + playersNumber, Role.WARRIOR));     
    }

    public void KickPlayer(Guid id)
    {
        GameObject playerPanelToDelete = playerPanels
            .FirstOrDefault(x => x.GetComponent<PlayerPanel>().LobbyPlayer.id == id);
        playerPanels.Remove(playerPanelToDelete);
        Destroy(playerPanelToDelete);
        lobbyManager.UpdatePlayerReccomandationRoles();
    }

    public List<LobbyPlayer> GetPlayers()
    {
        return playerPanels
            .Select(x => x.GetComponent<PlayerPanel>().LobbyPlayer)
            .ToList();
    }

    public void HideKickButton()
    {
        playerPanels.ForEach(panel => panel.transform.GetChild(panel.transform.childCount - 1).GetComponent<Button>().interactable = false);
    }

    public void ShowKickButton()
    {
        playerPanels.ForEach(panel => panel.transform.GetChild(panel.transform.childCount - 1).GetComponent<Button>().interactable = true);
    }

    public void HideMuteButton()
    {
        playerPanels.ForEach(panel => panel.transform.GetChild(panel.transform.childCount - 2).GetComponent<Button>().interactable = false);
    }

    public void ShowMuteButton()
    {
        playerPanels.ForEach(panel => panel.transform.GetChild(panel.transform.childCount - 2).GetComponent<Button>().interactable = true);
    }
}
