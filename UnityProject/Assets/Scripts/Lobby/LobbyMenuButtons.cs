using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class LobbyMenuButtons : MonoBehaviour
{
   public void GoToJoinLobby()
    {
        Application.LoadLevel("JoinLobby");
    }

    public void GoToLobbyScene()
    {
        Application.LoadLevel("LobbyScene");
    }

    public void GoToCreateLobby()
    {
        Debug.Log("create lobby window");
        //Application.LoadLevel("LobbyScene");
    }
}
