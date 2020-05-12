using Photon.Pun;
using System.IO;
using UnityEngine;

public class GameSetupController : MonoBehaviour
{
    public Role PlayerRole;

    private CurrentPlayer Player;
    // Start is called before the first frame update
    void Start()
    {
        createPlayer();
    }

    private void createPlayer()
    {
        if (PhotonNetwork.LocalPlayer.IsMasterClient == true)
        {
            PlayerRole = Role.ADMIN;
        }
        else
        {
            PlayerRole = Player.getRole();
        }
        
        Debug.Log("Creating Player");
        if (PhotonNetwork.LocalPlayer.IsMasterClient == true)
        {
            PhotonNetwork.Instantiate(Path.Combine("PhotonPrefabs", "DM"), new Vector3(4,4,4), Quaternion.identity,0);
        }

        if (PlayerRole == Role.ROGUE)
        {
            PhotonNetwork.Instantiate(Path.Combine("PhotonPrefabs", "ROGUE"), new Vector3(2,2,2), Quaternion.identity,0);
        }
        if(PlayerRole== Role.WARRIOR)
        {
            PhotonNetwork.Instantiate(Path.Combine("PhotonPrefabs", "WARRIOR"), new Vector3(6,6,6), Quaternion.identity,0);
        }
        if(PlayerRole == Role.MAGE)
        {
            PhotonNetwork.Instantiate(Path.Combine("PhotonPrefabs", "MAGE"), new Vector3(8,8,8), Quaternion.identity,0);
        }
        if(PlayerRole == Role.CLERIC)
        {
            PhotonNetwork.Instantiate(Path.Combine("PhotonPrefabs", "CLERIC"), new Vector3(1,1,1), Quaternion.identity,0);
        }

        if (PlayerRole == Role.ARCHER)
        {
            PhotonNetwork.Instantiate(Path.Combine("PhotonPrefabs", "ARCHER"), new Vector3(3,3,3), Quaternion.identity,0);
        }
       
    }
    // Update is called once per frame
}
