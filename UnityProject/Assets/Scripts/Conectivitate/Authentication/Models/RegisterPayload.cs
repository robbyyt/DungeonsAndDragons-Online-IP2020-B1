namespace Conectivitate.Authentication.Models
{
    public class RegisterPayload
    {
        public string username;
        public string email;
        public string password;

        public RegisterPayload(string username, string email, string password)
        {
            this.username = username;
            this.email = email;
            this.password = password;
        }
    }
}