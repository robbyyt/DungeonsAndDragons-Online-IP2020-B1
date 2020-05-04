using Photon.Pun;
using Photon.Realtime;
using UnityEngine;
using System;

public class PlayerListing : MonoBehaviour
{
    private Player _player;
    public LobbyPlayersManager lobbyPlayersManager;

    public void SetPlayerInfo(Player player)
    {
        _player = player;
        LobbyPlayer lobbyPlayer = new LobbyPlayer(Guid.NewGuid(), 0, player.NickName, Role.MAGE);
        lobbyPlayersManager.AddPlayerToLobby(lobbyPlayer);
    }
}
