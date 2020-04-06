namespace Conectivitate.Authentication.Models
{
    public class User
    {
        public string userName;
        public string localId;
        public string idToken;

        public User(string userName, string localId, string idToken)
        {
            this.userName = userName;
            this.localId = localId;
            this.idToken = idToken;
        }
    }
}