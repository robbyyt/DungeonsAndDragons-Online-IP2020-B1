using Photon.Pun;
using System.Collections.Generic;
using UnityEngine;
using System.Linq;
using UnityEngine.UI;

public class LobbyManager : MonoBehaviourPunCallbacks
{
    private List<RoleRecommendation> roleRecommendationList;
    public LobbyPlayersManager lobbyPlayersManager;


    public GameObject ScenarioDescriprionPanel;
    public GameObject RecommandedRolesPanel;

    public Button StartButton;

    public bool IsGameMaster =false;

    public void Awake()
    {
        
        roleRecommendationList = RecommandedRolesPanel.transform
                                    .GetComponentsInChildren<RoleRecommendation>()
                                    .ToList();
    }

    private void Start()
    {
        //PhotonNetwork.SetMasterClient(PhotonNetwork.PlayerList[1]);
        //UpdateAdminRights();
        
    }

    public void UpdateAdminRights()
    {
        if (PhotonNetwork.LocalPlayer.IsMasterClient == true)
        {
           
            ShowAdminRights();

        }
        else
        {
            DisableAdminRights();
        }
    }

    
    public void UpdatePlayerReccomandationRoles()
    {
        roleRecommendationList.ForEach(x =>
                x.UpdateCurrentNumberOfPlayers(
                    lobbyPlayersManager
                        .GetPlayers()
                        .Count(player => player.role == x.Role)));
    }

    public void ShowScenarioDescription()
    {
        ScenarioDescriprionPanel.SetActive(true);
        RecommandedRolesPanel.SetActive(false);

    }

    public void ShowRecommandedRoles()
    {
        ScenarioDescriprionPanel.SetActive(false);
        RecommandedRolesPanel.SetActive(true);
        UpdatePlayerReccomandationRoles();
    }

    public void DisableAdminRights()
    {
        StartButton.interactable = false;
        roleRecommendationList.ForEach(x => x.HideSlider());
        lobbyPlayersManager.HideKickButton();
        lobbyPlayersManager.HideMuteButton();
    }

    public void ShowAdminRights()
    {
        StartButton.interactable = true;
        roleRecommendationList.ForEach(x => x.ShowSlider());
        lobbyPlayersManager.ShowKickButton();
        lobbyPlayersManager.ShowMuteButton();
    }

    private void Update()
    {
        UpdateAdminRights();
    }

}

