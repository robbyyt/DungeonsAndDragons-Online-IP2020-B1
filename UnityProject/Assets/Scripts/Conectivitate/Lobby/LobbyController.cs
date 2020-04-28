using Photon.Pun;
using Photon.Realtime;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class LobbyController : MonoBehaviourPunCallbacks
{
    [SerializeField] private GameObject lobbyConnectButton;

    [SerializeField] private GameObject lobbyPanel;

    [SerializeField] private GameObject mainPanel;

    [SerializeField] private string username; // trebuie modificat 

    [SerializeField] private Transform roomsContainer;

    [SerializeField] 
    private GameObject roomListPrefab;
    
    
    private string roomName;
    private int roomSize;
    private List<RoomInfo> roomList;

    public override void OnConnectedToMaster()
    {
        PhotonNetwork.AutomaticallySyncScene = true; //cand master-ul schimba scena, toti playerii trec la scena respectiva.
        lobbyConnectButton.SetActive(true); //activeaza butonul de conectare la lobby
        roomList = new List<RoomInfo>(); //RoomInfo e o clasa ce retine detaliile unei camere
        username = "UsernameStandard";//AppUser.userName; // username-ul trebuie sa primeasca valoare retinuta in baza de date
        PhotonNetwork.NickName = username;
    }

    public void ClickJoinLobby()
    {
        mainPanel.SetActive(false);
        lobbyPanel.SetActive(true);
        PhotonNetwork.JoinLobby(); 
    }

    public override void OnRoomListUpdate(List<RoomInfo> roomListInfo)
    {
        int index;
        foreach (RoomInfo room in roomListInfo) //parcurgem toate camerele din roomListInfo
        {
            if (roomList != null)
            {
                index = roomList.FindIndex(ByName(room.Name));
            }
            else
            {
                index = -1;
            }

            if (index != -1)
            {
                roomList.RemoveAt(index);
                Destroy(roomsContainer.GetChild(index).gameObject);
            }

            if (room.PlayerCount > 0)
            {
                roomList.Add(room);
                ListRoom(room);
            }
            
            
        }
    }

    public override void OnJoinedRoom() //se apeleaza cand un player intra in camera de joc
    {
        for (int i = roomsContainer.childCount - 1; i == 0; i--)
        {
            Destroy(roomsContainer.GetChild(i).gameObject);
        }
    }

    static System.Predicate<RoomInfo> ByName(string name) //functie care cauta in lista de camere
    {
        return delegate(RoomInfo room)
        {
            return room.Name == name;
        };
    }

    void ListRoom(RoomInfo room) //afiseaza noua lista de camera pentru camera curenta
    {
        if (room.IsOpen && room.IsVisible)
        {
            GameObject tempListing = Instantiate(roomListPrefab, roomsContainer);
            RoomButton tempButton = tempListing.GetComponent<RoomButton>();
            tempButton.SetRoom(room.Name, room.MaxPlayers, room.PlayerCount); 
        }
    }

    public void RoomChangeName(string nameInput) //functie ce schimba numele camerei de la un input
    {
        roomName = nameInput;
    }

    public void RoomSizeChange(string sizeInput)
    {
        roomSize = int.Parse(sizeInput);
    }

    public void CreateRoom()
    {
        Debug.Log("Creating room");
        RoomOptions roomOps = new RoomOptions()
        {
            IsVisible = true, 
            IsOpen = true, 
            MaxPlayers = (byte) roomSize
        };

        if (roomName == null)
        {
            Debug.Log("Please enter the name of the room");
            return;
        }
        else
        {
            PhotonNetwork.CreateRoom(roomName, roomOps); //se incearca creare unei noi camere 
        }
    }

    public override void OnCreateRoomFailed(short returnCode, string message) //crearea camerei esueaza daca numele camerei exista deja
    {
        Debug.Log("Room creation failed, there must already be a room with the same name");
        
    }

    public void ReturnToMenu()
    {
        mainPanel.SetActive(true);
        lobbyPanel.SetActive(false);
        PhotonNetwork.LeaveLobby();
    }
    
}
