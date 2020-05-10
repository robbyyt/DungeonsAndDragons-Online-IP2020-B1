using Photon.Pun;
using Photon.Realtime;
using UnityEngine;
using System;
using Conectivitate.Authentication.Models;

public class CurrentPlayer : MonoBehaviourPunCallbacks
{
    public bool IsAdmin;
    public string NickName = "";
    public Role PlayerRole;
    public int PlayerLevel;
    public LobbyManager manager;
    public PlayerPanel panel = null;
    
    // Start is called before the first frame update
    void Start()
    {
        PlayerRole = Role.UNKNOWN;
        PlayerLevel = 0;
     
    }

    // Update is called once per frame
    public override void OnJoinedRoom()
    {
        if(NickName == "")
        {
            Player player = PhotonNetwork.LocalPlayer;
            IsAdmin = player.IsMasterClient;
            Debug.Log(AppUser.username);
            NickName = AppUser.username;
            if(NickName != "")
            {
                LobbyPlayer lobbyPlayer = new LobbyPlayer(Guid.Parse(player.UserId), PlayerLevel, NickName, PlayerRole);
                panel = manager.lobbyPlayersManager.AddPlayerToLobby(lobbyPlayer);
            }
          
        }
    }

    public void UpdateRole(Role role)
    {
        this.PlayerRole = role;
        if (this.panel != null)
        {
            this.panel.UpdateRole(role);
        }
        manager.UpdatePlayerReccomandationRoles();
        GetComponent<LobbyRpc>().UpdateForGodSake(PhotonNetwork.LocalPlayer.UserId, role);
    }
}
