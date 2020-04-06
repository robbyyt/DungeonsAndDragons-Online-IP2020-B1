using System;

namespace Conectivitate.Authentication.Models
{
    [Serializable]
    public class AuthResponse
    {
        public string localId;
        public string idToken;
    }
}