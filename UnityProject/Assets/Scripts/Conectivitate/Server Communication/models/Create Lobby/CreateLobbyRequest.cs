using System;
using Conectivitate.Server_Communication.models;

namespace DefaultNamespace
{
    [Serializable]
    public class CreateLobbyRequest: ServerRequest
    {
        public string PLAYER_NAME;
        public string ROOM_NAME;
        public string MAX_PLAYERS;

        public CreateLobbyRequest(string playerName, string roomName, string maxPlayers)
        {
            this.PROTOCOL ="CREATE_LOBBY";
            this.PLAYER_NAME = playerName;
            this.ROOM_NAME = roomName;
            this.MAX_PLAYERS = maxPlayers;
        }
    }
}