using Conectivitate.Authentication.Models;
using PlayFab;
using PlayFab.ClientModels;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class PlayFabLogin : MonoBehaviour
{
    public InputField emailField;
    public InputField passwordField;
    public InputField passwordVerificationField;
    public InputField usernameField;
    public InputField loginEmailField;
    public InputField loginPasswordField;
    public InputField passwordRecoveryEmailField;
    public GameObject responsePanel;
    public Text responseText;
    public GameObject successText;
    public void Start()
    {
        //Note: Setting title Id here can be skipped if you have set the value in Editor Extensions already.
        if (string.IsNullOrEmpty(PlayFabSettings.TitleId)){
            PlayFabSettings.TitleId = "CD6E1"; // Please change this value to your own titleId from PlayFab Game Manager
        }
    }

    #region Login
    public void Login()
    {
        {
            var request = new LoginWithEmailAddressRequest
                {Email = loginEmailField.text, Password = loginPasswordField.text};
            PlayFabClientAPI.LoginWithEmailAddress(request, OnLoginSuccess, OnLoginFailure);
        }
    }
    private void OnLoginSuccess(LoginResult result)
    {
        successText.SetActive(true);
        var request = new GetAccountInfoRequest{Email = loginEmailField.text};
        PlayFabClientAPI.GetAccountInfo(request, task =>
        {
            AppUser.username = task.AccountInfo.Username;
            SceneManager.LoadScene("CreateLobby");
        }, task => { task.GenerateErrorReport(); });
    }

    private void OnLoginFailure(PlayFabError error)
    {
        Debug.LogWarning("Something went wrong with your login call.");
        EnableGuiElement(error.ErrorMessage);
    }
    #endregion
    #region Register
    public void Register()
    {
        string email = emailField.text;
        string password = passwordField.text;
        string verifyPassword = passwordVerificationField.text;
        string username = usernameField.text;
        if (email.Equals("") || password.Equals("") || username.Equals(""))
        {
            EnableGuiElement("Please fill in all of the inputs!");
            return;
        }
        if (!password.Equals(verifyPassword))
        {
            EnableGuiElement("The password do not match.");
            return;
        }
        var request = new RegisterPlayFabUserRequest
        {
            Email = email,
            Password = password,
            Username = username,
            DisplayName = username
        };
        PlayFabClientAPI.RegisterPlayFabUser(request, OnRegisterSuccess, OnRegisterFailure);
        
    }

    private void OnRegisterSuccess(RegisterPlayFabUserResult result)
    {
        EnableGuiElement("You have registered successfully!");
        var request = new AddOrUpdateContactEmailRequest
        {
            EmailAddress = emailField.text
        };
        PlayFabClientAPI.AddOrUpdateContactEmail(request, response =>
        {
            Debug.Log("Adresa de email a fost setata cu succes.");
        }, err =>
        {
            Debug.Log("Adresa de e-mail nu a putut fi setata.");
        });
    }

    private void EnableGuiElement(string message)
    {
        if (responsePanel != null)
        {
            responseText.text = message;
            responsePanel.SetActive(true);
        }
    }

    public void DisableGuiElement()
    {
        if (responsePanel != null)
        {
            responsePanel.SetActive(!responsePanel.activeSelf);
        }
    }

    private void OnRegisterFailure(PlayFabError error)
    {
        EnableGuiElement(error.ErrorMessage);
    }
    #endregion
    #region resetPwd
    public void ResetPassword()
    {
        var request= new SendAccountRecoveryEmailRequest
        {
            Email = passwordRecoveryEmailField.text,
            EmailTemplateId="4762DF73A6842281",
            TitleId = "CD6E1"
        };
        PlayFabClientAPI.SendAccountRecoveryEmail(request, OnAccountRecoverySuccess, OnAccountRecoveryFailure);
    }

    private void OnAccountRecoverySuccess(SendAccountRecoveryEmailResult obj)
    {
        Debug.Log("Email sent!");
    }

    private void OnAccountRecoveryFailure(PlayFabError error)
    {
        Debug.Log("Email not sent!");
        Debug.Log(error.GenerateErrorReport());
    }
    #endregion
}
