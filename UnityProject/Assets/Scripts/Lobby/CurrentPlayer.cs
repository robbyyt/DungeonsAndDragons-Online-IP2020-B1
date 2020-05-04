using Photon.Pun;
using UnityEngine;

public class CurrentPlayer : MonoBehaviourPunCallbacks
{
    public bool IsAdmin;
    public string NickName;
    // Start is called before the first frame update
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {
        IsAdmin = PhotonNetwork.LocalPlayer.IsMasterClient;
        NickName = PhotonNetwork.LocalPlayer.NickName;
    }
}
