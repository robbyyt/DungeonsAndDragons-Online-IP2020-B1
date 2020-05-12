using System;
using Photon.Pun;
using System.Collections.Generic;
using System.Linq;
using UnityEngine;
using UnityEngine.UI;
using Photon.Realtime;

public class LobbyPlayersManager : MonoBehaviourPunCallbacks
{
    private List<GameObject> playerPanels;
    private int  playersNumber = 1;
    //public GameObject CharactersPanel;
    //public GameObject CharacterDisplayed;
    public GameObject playerPanePrefab;
	public GameObject playerPanelAuxPrefab;
    public GameObject playersScrollArea;
    public LobbyManager lobbyManager;
	public LobbyPlayer lobbyPlayer;

    public void Start()
    {
        playerPanels = new List<GameObject>();
        playersNumber = 1;
    }


    public override void OnJoinedRoom()
    {


        PhotonNetwork.PlayerList.ToList().ForEach(x =>
        {

            if(!x.IsLocal)
            {
                if(x.IsMasterClient == true)
                {
                    lobbyPlayer = new LobbyPlayer(Guid.Parse(x.UserId), 0, x.NickName, Role.ADMIN);
                    AddPlayerToLobby(lobbyPlayer);
                    lobbyManager.UpdateAdminRights();
                    //CharacterDisplayed.SetActive(false);
                    //CharactersPanel.SetActive(false);
                }
                else
                {
                     lobbyPlayer = new LobbyPlayer(Guid.Parse(x.UserId), 0, x.NickName, Role.UNKNOWN);
                    AddPlayerToLobby(lobbyPlayer);
                    lobbyManager.UpdateAdminRights();
                    //CharacterDisplayed.SetActive(true);
                    //CharactersPanel.SetActive(true);
                }


            }
        });


    }

    public override void OnPlayerEnteredRoom(Player newPlayer)
    {
        LobbyPlayer lobbyPlayer = new LobbyPlayer(Guid.Parse(newPlayer.UserId), 0, newPlayer.NickName, Role.UNKNOWN);
        AddPlayerToLobby(lobbyPlayer);
        lobbyManager.UpdateAdminRights();
    }

    public override void OnPlayerLeftRoom(Player otherPlayer)
    {
        KickPlayer(Guid.Parse(otherPlayer.UserId));
    }

    public PlayerPanel AddPlayerToLobby(LobbyPlayer player)
    {
			GameObject pane ; //= null;
		if(PhotonNetwork.LocalPlayer.IsMasterClient == true)
        { pane = Instantiate(playerPanePrefab, Vector3.zero, Quaternion.identity, playersScrollArea.transform);  }//!!!!!!!!!!!!!!!!!!!!
			else
		{ pane = Instantiate(playerPanelAuxPrefab, Vector3.zero, Quaternion.identity, playersScrollArea.transform); } //!!!!!!!!!!!!!!!!!!!!

        pane.GetComponent<PlayerPanel>().SetPlayer(player, playersNumber);
        pane.GetComponent<PlayerPanel>().manager = this;
        playersNumber += 1;
        playerPanels.Add(pane);
        lobbyManager.UpdatePlayerReccomandationRoles();
        return pane.GetComponent<PlayerPanel>();
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
        playerPanels.ForEach(x => Debug.Log(x.GetComponent<PlayerPanel>().PlayerRole));
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
    public List<PlayerPanel> GetPlayerPanels()
    {
        return playerPanels.Select(x => x.GetComponent<PlayerPanel>()).ToList();
    }


}
