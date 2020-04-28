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
    }
}