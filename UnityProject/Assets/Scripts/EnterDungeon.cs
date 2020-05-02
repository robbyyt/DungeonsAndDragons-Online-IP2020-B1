using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
public class EnterDungeon : MonoBehaviour
{
    public string dungeonName;
    private GameObject player;

    private void Start()
    {
        player = GameObject.FindGameObjectWithTag("Player");
    }


    public void Update()
    {
        if(Vector3.Distance(this.transform.position, player.transform.position) < 4)
        {
            SceneManager.LoadScene(2);
        }
    }
}
