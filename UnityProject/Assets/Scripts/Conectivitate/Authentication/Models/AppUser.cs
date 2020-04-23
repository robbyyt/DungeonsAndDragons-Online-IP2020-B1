using System.Runtime.CompilerServices;

namespace Conectivitate.Authentication.Models
{
    public class AppUser
    {
        public static string userName;
        public static string id;
        public static bool set; // daca user-ul curent a fost setat

        public static void SetUser(User user)
        {
            userName = user.userName;
            id = user.id;
            set = true;
        }
    }
}