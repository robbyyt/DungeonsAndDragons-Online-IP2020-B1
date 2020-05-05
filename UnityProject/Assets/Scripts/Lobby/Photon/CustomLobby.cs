using System.Collections.Generic;
using Photon.Pun;
using Photon.Realtime;
using UnityEngine;
using UnityEngine.UI;
using System.Linq;
using UnityEngine.SceneManagement;

public class CustomLobby : MonoBehaviourPunCallbacks, ILobbyCallbacks  
{
    public static CustomLobby lobby;
    public GameObject createRoomButton;
    public string roomName;
    public int roomSize;
    public GameObject roomListingPrefab;
    public Transform roomsPanel;
    public Text playerName;

    private void Awake()
    {
        lobby = this;
        PhotonNetwork.ConnectUsingSettings();
    }

    public override void OnConnectedToMaster()
    {
        Debug.Log("Connected to materServer");
        PhotonNetwork.AutomaticallySyncScene = true;
        PhotonNetwork.JoinLobby();
        createRoomButton.GetComponent<Button>().interactable = true;
        playerName.text = PhotonNetwork.LocalPlayer.NickName;
    }

    public void CreateRoom()
    {
        RoomOptions roomOptions = new RoomOptions() { IsVisible = true, IsOpen = true, PublishUserId = true, MaxPlayers = (byte)roomSize };
        PhotonNetwork.CreateRoom(roomName, roomOptions);
        SceneManager.LoadScene("LobbyScene");
    }

    public override void OnCreateRoomFailed(short returnCode, string message)
    {
        Debug.Log("Room creation failed");
    }

    public override void OnRoomListUpdate(List<RoomInfo> roomList)
    {
        base.OnRoomListUpdate(roomList);
        RemoveRoomListings();
        roomList.ForEach(x => ListRoom(x));
    }

    public void RemoveRoomListings()
    {
        while(roomsPanel.childCount != 0)
        {
            Destroy(roomsPanel.GetChild(0).gameObject);
        }
    }

    public void ListRoom(RoomInfo room)
    {
        if(room.IsOpen && room.IsVisible == true)
        {
            GameObject tempListing = Instantiate(roomListingPrefab, roomsPanel);
            RoomButton roomButton = tempListing.GetComponent<RoomButton>();
            roomButton.roomName = room.Name;
            roomButton.roomSize = room.MaxPlayers;
            roomButton.SetRoom();
        }
    }

    public void OnRoomNameChanged(string nameIn)
    {
        roomName = nameIn;
    }

    public void OnRoomSizeChanged(string sizeIn)
    {
        roomSize = int.Parse(sizeIn);
    }

    public void OnNicknameChanged(string nicknameIn)
    {
        PhotonNetwork.LocalPlayer.NickName = nicknameIn;
    }

    public void JoinLobbyOnClick()
    {
        if(!PhotonNetwork.InLobby)
        {
            PhotonNetwork.JoinLobby();
        }
    }
}
