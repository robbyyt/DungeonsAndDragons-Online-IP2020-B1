using Conectivitate.Authentication.Models;
using Proyecto26;
using UnityEngine;

public class AuthenticationController
{
    private string authKey = "AIzaSyDIL9FeYzduvqF3jA5h1osoLhJEj5hBmQw";
    private string databaseURL = "https://dungeonsanddragons-ip2020.firebaseio.com/";

    public string convertToJson(string email, string password)
    {
        return "{\"email\":\"" + email + "\",\"password\":\"" + password + "\",\"returnSecureToken\":true}";
    }

    public User RegisterUser(RegisterPayload payload)
    {
        string userData = convertToJson(payload.email, payload.password);
        RestClient.Post<AuthResponse>(
            "https://www.googleapis.com/identitytoolkit/v3/relyingparty/signupNewUser?key=" + authKey, userData).Then(
            response =>
            {
                User user = new User(payload.username, response.localId, response.idToken);
                PostToDatabase(user);
                return user;
            }).Catch(error =>
        {
            Debug.Log(error);
            return null;
        });
        return null;
    }

    public void PostToDatabase(User user)
    {
        RestClient.Put(databaseURL + "/" + user.localId + ".json?auth=" + user.idToken, user);
    }
}