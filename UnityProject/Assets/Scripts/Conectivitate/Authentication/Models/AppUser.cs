using System.Collections;
using System.Runtime.CompilerServices;
using UnityEngine;

namespace Conectivitate.Authentication.Models
{
    public class AppUser : MonoBehaviour
    {
        public static AppUser Instance { get; private set; }

        public static string username="";
        public string id;
        public bool set;

        private void Awake()
        {
            if (Instance != null)
            {
                Destroy(gameObject);
            }
            else 
                Instance = this;
            DontDestroyOnLoad(this);
        }
    }
}