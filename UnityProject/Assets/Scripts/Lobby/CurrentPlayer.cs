using Photon.Pun;
using Photon.Realtime;
using UnityEngine;
using System;

public class CurrentPlayer : MonoBehaviourPunCallbacks
{
    public bool IsAdmin;
    public string NickName = "";
    public  Role PlayerRole;
    public int PlayerLevel;
    public LobbyManager manager;
    public PlayerPanel panel = null;
    
    // Start is called before the first frame update
    void Start()
    {
        PlayerRole = Role.UNKNOWN;
        PlayerLevel = 0;
        DontDestroyOnLoad(gameObject);

    }

    public Role getRole()
    {
        return PlayerRole;
    }
    
    // Update is called once per frame
    public override void OnJoinedRoom()
    {
        if (NickName == "")
        {
            Player player = PhotonNetwork.LocalPlayer;
            IsAdmin = player.IsMasterClient;
            NickName = player.NickName;
            if (NickName != "")
            {
                if(IsAdmin==true)
                {
                    LobbyPlayer lobbyPlayer = new LobbyPlayer(Guid.Parse(player.UserId), PlayerLevel, NickName, Role.ADMIN);
                    panel = manager.lobbyPlayersManager.AddPlayerToLobby(lobbyPlayer);
                }
                else
                {
                    LobbyPlayer lobbyPlayer = new LobbyPlayer(Guid.Parse(player.UserId), PlayerLevel, NickName, PlayerRole);
                    panel = manager.lobbyPlayersManager.AddPlayerToLobby(lobbyPlayer);
                }

            }

        }
    }

    public void UpdateRole(Role role)
    {
		if(IsAdmin == false){
        	this.PlayerRole = role;

            if (this.panel != null)
        	{
            	this.panel.UpdateRole(role);
        	}
        	manager.UpdatePlayerReccomandationRoles();
        	GetComponent<LobbyRpc>().UpdateForGodSake(PhotonNetwork.LocalPlayer.UserId, role);
    	}
	}

}