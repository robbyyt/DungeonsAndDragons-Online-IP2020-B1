using System;
using System.Collections;
using Conectivitate.Server_Communication.models.Create_Lobby;

namespace DefaultNamespace
{
    [Serializable]
    public class CreateLobbyResponse: ServerResponse
    {
        public ArrayList userList = new ArrayList();
        public string name;
        public string dungeonMaster;
        public string id;
        public int maxPlayersLimit;
    }
}