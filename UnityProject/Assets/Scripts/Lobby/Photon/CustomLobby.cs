using System.Collections.Generic;
using Photon.Pun;
using Photon.Realtime;
using UnityEngine;
using System.Linq;

public class CustomLobby : MonoBehaviourPunCallbacks, ILobbyCallbacks  
{
    public static CustomLobby lobby;
    public string roomName;
    public int roomSize;
    public GameObject roomListingPrefab;
    public Transform roomsPanel;

    private void Awake()
    {
        lobby = this;
    }

    public override void OnConnectedToMaster()
    {
        Debug.Log("Connected to materServer");
        PhotonNetwork.AutomaticallySyncScene = true;
    }

    public void CreateRoom()
    {
        RoomOptions roomOptions = new RoomOptions() { IsVisible = true, IsOpen = true, MaxPlayers = (byte)roomSize };
        PhotonNetwork.CreateRoom(roomName, roomOptions);
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

    public void JoinLobbyOnClick()
    {
        if(!PhotonNetwork.InLobby)
        {
            PhotonNetwork.JoinLobby();
        }
    }
}
