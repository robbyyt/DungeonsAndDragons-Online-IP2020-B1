using System;

namespace Conectivitate.Server_Communication.models.Select_Character
{
    [Serializable]
    public class SelectCharacterRequest: ServerRequest
    {
        public string PLAYER_NAME;
        public string CHARACTER_NAME;
    }
}