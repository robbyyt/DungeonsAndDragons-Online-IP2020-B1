using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using Conectivitate.Authentication.Models;
using Conectivitate.Database;
using Firebase;
using Firebase.Auth;
using Firebase.Extensions;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class AuthenticationHandler : MonoBehaviour
{
    protected Firebase.Auth.FirebaseAuth auth;
    private Firebase.Auth.FirebaseAuth otherAuth;

    protected Dictionary<string, Firebase.Auth.FirebaseUser> userByAuth =
        new Dictionary<string, Firebase.Auth.FirebaseUser>();

    private string logText = "";
    public InputField emailField;
    public InputField passwordField;
    public InputField passwordVerificationField;
    public InputField usernameField;
    public InputField loginEmailField;
    public InputField loginPasswordField;
    public InputField passwordResetInputField;
    private bool fetchingToken = false;
    private bool UserSignedIn = false;
    const int kMaxLogSize = 16382;
    DependencyStatus dependencyStatus = DependencyStatus.UnavailableOther;

    // Start is called before the first frame update
    private void Start()
    {
        Firebase.FirebaseApp.CheckAndFixDependenciesAsync().ContinueWith(task =>
        {
            dependencyStatus = task.Result;
            if (dependencyStatus == Firebase.DependencyStatus.Available)
            {
                InitializeFirebase();
            }
            else
            {
                Debug.LogError(
                    "Could not resolve all Firebase dependencies: " + dependencyStatus);
            }
        });
        DontDestroyOnLoad(this);
    }

    void OnDestroy()
    {
        //auth.StateChanged -= AuthStateChanged;
        //auth.IdTokenChanged -= IdTokenChanged;
        auth = null;
    }

    private void DebugLog(string s)
    {
        Debug.Log(s);
        logText += s + "\n";

        while (logText.Length > kMaxLogSize)
        {
            int index = logText.IndexOf("\n", StringComparison.Ordinal);
            logText = logText.Substring(index + 1);
        }
    }

    private void InitializeFirebase()
    {
        DebugLog("Setting up Firebase Auth");
        auth = FirebaseAuth.DefaultInstance;
        auth.StateChanged += AuthStateChanged;
        auth.IdTokenChanged += IdTokenChanged;
        AuthStateChanged(this, null);
    }

    //  Track state changes of the auth object.
    private void AuthStateChanged(object sender, System.EventArgs eventArgs)
    {
        FirebaseAuth senderAuth = sender as FirebaseAuth;
        FirebaseUser user = null;
        if (senderAuth != null) userByAuth.TryGetValue(senderAuth.App.Name, out user);
        if (senderAuth == auth && senderAuth?.CurrentUser != user)
        {
            bool signedIn = user != senderAuth.CurrentUser && senderAuth.CurrentUser != null;
            if (!signedIn && user != null)
            {
                DebugLog("Signed out " + user.UserId);
                //user is logged out, load login screen
            }

            user = senderAuth.CurrentUser;
            userByAuth[senderAuth.App.Name] = user;
            if (signedIn)
            {
                DebugLog("Signed in " + user.UserId);
            }
        }
    }

    void IdTokenChanged(object sender, System.EventArgs eventArgs)
    {
        FirebaseAuth senderAuth = sender as FirebaseAuth;
        if (senderAuth == auth && senderAuth?.CurrentUser != null && !fetchingToken)
        {
            senderAuth.CurrentUser.TokenAsync(false).ContinueWith(
                task => DebugLog($"Token[0:8] = {task.Result.Substring(0, 8)}"));
        }
    }

    private bool LogTaskCompletion(Task task, string operation)
    {
        bool complete = false;
        if (task.IsCanceled)
        {
            DebugLog(operation + " canceled.");
        }
        else if (task.IsFaulted)
        {
            DebugLog(operation + " encountered an error.");
            if (task.Exception != null)
                foreach (var exception in task.Exception.Flatten().InnerExceptions)
                {
                    string authErrorCode = "";

                    if (exception is FirebaseException firebaseEx)
                    {
                        authErrorCode = $"AuthError.{((Firebase.Auth.AuthError) firebaseEx.ErrorCode).ToString()}: ";
                    }

                    DebugLog(authErrorCode + exception.ToString());
                }
        }
        else if (task.IsCompleted)
        {
            DebugLog(operation + " completed");
            complete = true;
        }

        return complete;
    }

    public void CreateUserAsync()
    {
        DebugLog($"Attempting to create user {emailField.text}...");

        // This passes the current displayName through to HandleCreateUserAsync
        // so that it can be passed to UpdateUserProfile().  displayName will be
        // reset by AuthStateChanged() when the new user is created and signed in.

        if (string.Compare(passwordField.text, passwordVerificationField.text, StringComparison.Ordinal) != 0)
        {
            DebugLog("Password does not match");
            return;
        }
        auth.CreateUserWithEmailAndPasswordAsync(emailField.text, passwordField.text)
            .ContinueWith(task => {
                return HandleCreateUserAsync(task, usernameField.text);
            }).Unwrap();
    }

    Task HandleCreateUserAsync(Task<Firebase.Auth.FirebaseUser> authTask, string newDisplayName = null) {
        if (LogTaskCompletion(authTask, "User Creation")) {
            if (auth.CurrentUser != null) {
                DebugLog(String.Format("User Info: {0}  {1}", auth.CurrentUser.Email,
                    auth.CurrentUser.UserId));

                DatabaseHandler databaseHandler = new DatabaseHandler();
                databaseHandler.AddUserToDatabase(new User(usernameField.text, auth.CurrentUser.UserId));
                Debug.Log("Added to db..");
                mailVerification(auth.CurrentUser);
                return UpdateUserProfileAsync(newDisplayName: newDisplayName);
            }
        }

        // Nothing to update, so just return a completed Task.
        return Task.FromResult(0);
    }

    public void mailVerification(Firebase.Auth.FirebaseUser user)
    {
        if (user != null) {
            user.SendEmailVerificationAsync().ContinueWith(task => {
                if (task.IsCanceled) {
                    Debug.LogError("canceled.");
                    return;
                }
                if (task.IsFaulted) {
                    Debug.LogError("encountered an error: " + task.Exception);
                    return;
                }

                Debug.Log("Email sent successfully.");
            });
        }
    }
    // Update the user's display name with the currently selected display name.
    private Task UpdateUserProfileAsync(string newDisplayName = null)
    {
        if (auth.CurrentUser == null)
        {
            DebugLog("Not signed in, unable to update user profile");
            return Task.FromResult(0);
        }
        DebugLog("Updating user profile");
        return auth.CurrentUser.UpdateUserProfileAsync(new Firebase.Auth.UserProfile
        {
            DisplayName = usernameField.text,
        });
    }


    public void SigninAsync()
    {
        DebugLog(String.Format("Attempting to sign in as {0}...", emailField.text));
        auth.SignInWithEmailAndPasswordAsync(loginEmailField.text, loginPasswordField.text)
            .ContinueWithOnMainThread(HandleSigninResult);
    }

    private void HandleSigninResult(Task<Firebase.Auth.FirebaseUser> authTask)
    {
        LogTaskCompletion(authTask, "Sign-in");
        DatabaseHandler databaseHandler = new DatabaseHandler();
        bool retrieved = databaseHandler.RetrieveUserFromDatabase();
        Debug.Log("Retrieved: "+retrieved);
        if(retrieved){
            Debug.Log("AppUser username: " + AppUser.username);
            Debug.Log(AppUser.Instance.id);
            LoadLobbyScene();
        }
        else
        {
            Debug.Log("Eroare la logare");
        }
    }


    public void GetUserToken()
    {
        if (auth.CurrentUser == null)
        {
            DebugLog("Not signed in, unable to get token.");
            return;
        }

        DebugLog("Fetching user token");
        fetchingToken = true;
        auth.CurrentUser.TokenAsync(false).ContinueWith(HandleGetUserToken);
    }

    //functia verifica daca este un user logat in momentul apelarii. (variabila de tipul bool tine evidenta logarii unui user) Daca nu e nimeni logat,
    //apare in consola mesajul respectiv si se face return. Daca e cinema logat se apeleaza metoda auth.SignOut(), UserSignedIn devine false (nu mai e nimeni logat) si se transfera la scena Login_Register
    public void SignOut()
    {

        if (UserSignedIn == false)
        {
            DebugLog("Can't Sign Out, the user is not Signed In");
            return;
        }
        else
        {
            DebugLog("Signing out");
            auth.SignOut();
            UserSignedIn = false;
            SceneManager.LoadSceneAsync("Login_Register");
        }
    }

    private void HandleGetUserToken(Task<string> authTask) {
        fetchingToken = false;
        if (LogTaskCompletion(authTask, "User token fetch"))
        {
            DebugLog("Token = " + authTask.Result);
        }
    }

    public void SendResetPasswordEmail()
    {
        string email = passwordResetInputField.text;
        auth.SendPasswordResetEmailAsync(email).ContinueWith(task =>
        {
            if (task.IsFaulted || task.IsCanceled)
            {
                Debug.Log("Email is not recognized!");
            }
            else
            {
                Debug.Log("Email sent successfully!");
            }
        });
    }

    private void LoadLobbyScene()
    {   
        DebugLog("Loading scene..");
        SceneManager.LoadScene("CreateLobby");
        Debug.Log("Scene loaded..");
    }
}
