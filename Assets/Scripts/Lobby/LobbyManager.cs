﻿using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System.Linq;
using UnityEngine.UI;

public class LobbyManager : MonoBehaviour
{
    private List<RoleRecommendation> roleRecommendationList;
    public LobbyPlayersManager lobbyPlayersManager;

    
    public GameObject ScenarioDescriprionPanel;
    public GameObject RecommandedRolesPanel;

    public Button StartButton;

    public bool IsGameMaster;

    public void Awake()
    {
        roleRecommendationList = RecommandedRolesPanel.transform
                                    .GetComponentsInChildren<RoleRecommendation>()
                                    .ToList();
    }

    public void UpdatePlayerReccomandationRoles()
    {
        roleRecommendationList.ForEach(x =>
                x.UpdateCurrentNumberOfPlayers(
                    lobbyPlayersManager.GetPlayers()
                                        .Where(player => player.role == x.Role)
                                        .Count()));
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
}
