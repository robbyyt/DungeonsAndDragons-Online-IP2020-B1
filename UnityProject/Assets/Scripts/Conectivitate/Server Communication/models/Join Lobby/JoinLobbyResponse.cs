using System;
using System.Collections;
using Conectivitate.Server_Communication.models.Create_Lobby;

namespace Conectivitate.Server_Communication.models.Join_Lobby
{
    [Serializable]
    public class JoinLobbyResponse: ServerResponse
    {
        public ArrayList userList = new ArrayList();
    }
}