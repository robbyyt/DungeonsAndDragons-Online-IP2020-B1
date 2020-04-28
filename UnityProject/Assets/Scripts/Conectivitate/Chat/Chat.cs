using Photon.Chat;
using Photon.Pun;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
//using ExitGames.Client.Photon.Chat;

public class Chat : MonoBehaviour, IChatClientListener
{
    private ChatClient chatClient;
    public InputField plrName;
    public Text connectionState;
    private string worldChat;
    public InputField msgInput;
    public Text msgArea;

    public GameObject introPanel;
    public GameObject msgPanel;
    
    void Start()
    {
        Application.runInBackground = true;
        if (string.IsNullOrEmpty(PhotonNetwork.PhotonServerSettings.AppSettings.AppIdChat))
        {
            print("No chat ID provided");
            return;
        }

        connectionState.text = "Connecting...";
        worldChat = "world";
        //getConnected();
    }

    public void getConnected()
    {
        print("Trying to connect");
        this.chatClient = new ChatClient(this);
        this.chatClient.Connect(PhotonNetwork.PhotonServerSettings.AppSettings.AppIdChat, "anything",
            new Photon.Chat.AuthenticationValues(plrName.text));
        connectionState.text = "Connectiong to chat..";
    }
    // new ExitGame.Client. [...]
    
    void Update()
    {
        if(this.chatClient != null)
        this.chatClient.Service();
    }

    public void sendMsg()
    {
        this.chatClient.PublishMessage(worldChat, msgInput.text);
    }
    
    public void OnConnected ()
    {
        print ("******     Connected");
        introPanel.SetActive(false);
        msgPanel.SetActive(true);
    }
    
    public void OnDisconnected ()
    {
        
    }


    public void OnChatStateChange (ChatState state)
    {
        
    }

    public void DebugReturn (ExitGames.Client.Photon.DebugLevel level, string message)
    {
       
    }

    
    public void OnGetMessages (string channelName, string[] senders, object[] messages)
    {
       
    }

    public void OnPrivateMessage (string sender, object message, string channelName)
    {
        
    }

    public void OnSubscribed (string[] channels, bool[] results)
    {
        
    }

    public void OnUnsubscribed (string[] channels)
    {
        
    }

    public void OnStatusUpdate (string user, int status, bool gotMessage, object message)
    {
        
    }

    public void OnUserSubscribed(string channel, string user)
    {
        
    }

    public void OnUserUnsubscribed(string channel, string user)
    {
        
    }
    
}
