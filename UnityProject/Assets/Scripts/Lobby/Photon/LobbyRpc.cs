using Photon.Pun;
using UnityEngine;
using System;
using System.Linq;
using Photon.Realtime;

public class LobbyRpc : MonoBehaviourPunCallbacks
{
    public LobbyPlayersManager lobbyPlayersManager;
    private PhotonView photonView;

    private void Awake()
    {
        photonView = GetComponent<PhotonView>();
    }

    public void UpdateForGodSake(string playerId, Role role)
    {
        photonView.RPC("RPC_UpdateSpecificPlayerRole", RpcTarget.AllBuffered, new object[] { playerId, role });
    }
    [PunRPC]
    public void RPC_UpdateSpecificPlayerRole(string playerId, Role role)
    {
        Guid playerGuid = Guid.Parse(playerId);
        PlayerPanel playerObject = lobbyPlayersManager.GetPlayerPanels().FirstOrDefault(x => x.LobbyPlayer.id == playerGuid);
        if (playerObject)
        {
            playerObject.GetComponent<PlayerPanel>().UpdateRole(role);
            lobbyPlayersManager.lobbyManager.UpdatePlayerReccomandationRoles();
        }
    }

    [PunRPC]
    private void RPC_KickPlayer()
    {
        PhotonNetwork.LeaveRoom();
    }
}
