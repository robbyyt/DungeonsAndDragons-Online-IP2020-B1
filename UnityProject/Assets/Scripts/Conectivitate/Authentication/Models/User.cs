namespace Conectivitate.Authentication.Models
{
    public class User
    {
        public string userName;
        public string localId;

        public User()
        {
        }

        public User(string userName, string localId)
        {
            this.userName = userName;
            this.localId = localId;
        }
    }
}