using Photon.Pun;
using Photon.Realtime;
using UnityEngine;
using System.Collections;
using UnityEngine.UI;

//CustomMatchmakingRoomController
public class RoomController : MonoBehaviourPunCallbacks
{
    [SerializeField] 
		private int multiPlayerSceneIndex; //scene index for loading multiplayer scene

    [SerializeField] 
		private GameObject lobbyPanel; //display for when in lobby

    [SerializeField] 
		private GameObject roomPanel; //display for when in room

    [SerializeField] 
		private GameObject startButton; // only for the master client; used to start the game 

    [SerializeField] 
		private Transform playersContainer; // used to display all the players in the current room

    [SerializeField] 
		private GameObject playerListingPrefab; // instantiate to display each player in the room

    [SerializeField] 
		private Text roomNameDisplay; // display for the name of the room


    void ClearPlayerListings()
    {
        for (int i = playersContainer.childCount - 1; i >= 0; i--)
            Destroy(playersContainer.GetChild(i).gameObject);
    }

    void ListPlayers()
    {
        foreach (Player player in PhotonNetwork.PlayerList)
        {
            GameObject tempListing = Instantiate(playerListingPrefab, playersContainer);
            Text tempText = tempListing.transform.GetChild(0).GetComponent<Text>();
            tempText.text = player.NickName;
        }
    }

    public override void OnJoinedRoom() // called when the local player joins the room
    {
        roomPanel.SetActive(true); //activate the display for being in a room
        lobbyPanel.SetActive(false); // hide the display for being in a lobby
        roomNameDisplay.text = PhotonNetwork.CurrentRoom.Name; // update room name display

        if (PhotonNetwork.IsMasterClient)
            startButton.SetActive(true);
        else
            startButton.SetActive(false);
        
        //photonPlayers = PhotonNetwork.PlayerList;
        ClearPlayerListings(); // remove all old player listings
        ListPlayers(); // relist all current player listings
    }

    public override void OnPlayerEnteredRoom(Player newPlayer)
    {
        ClearPlayerListings(); //remove all old player listings
        ListPlayers(); // relist all current player listings
    }

    public override void OnPlayerLeftRoom(Player otherPlayer)
    {
        ClearPlayerListings();
        ListPlayers();
        if (PhotonNetwork.IsMasterClient)
            startButton.SetActive(true);
    }
    
    public void StartGame()
    {
        if (PhotonNetwork.IsMasterClient)
        {
            PhotonNetwork.CurrentRoom.IsOpen = false;
            PhotonNetwork.LoadLevel(multiPlayerSceneIndex);
        }
    }

    IEnumerator rejoinLobby()
    {
        yield return new WaitForSeconds(1);
        PhotonNetwork.JoinLobby();
    }

    public void BackOnClick()
    {
        lobbyPanel.SetActive(true);
        roomPanel.SetActive(false);
        PhotonNetwork.LeaveRoom();
        PhotonNetwork.LeaveLobby();
        StartCoroutine(rejoinLobby());

    }
}