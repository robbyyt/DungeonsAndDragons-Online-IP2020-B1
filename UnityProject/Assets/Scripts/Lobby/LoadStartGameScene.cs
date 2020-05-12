using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class LoadStartGameScene : MonoBehaviour
{
   public void loadMapScene()
   {
      SceneManager.LoadScene("MultiplayerSceneDemo");
   }
}
