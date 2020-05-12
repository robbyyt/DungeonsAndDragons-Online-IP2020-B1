using System;
using System.Collections;
using UnityEngine;

namespace Conectivitate.Authentication.Models
{
    public class User
    {
        public string userName;
        public string id;
        public bool set = false;

        public User()
        {
        }

        public User(IDictionary dictionary)
        {
            this.id = dictionary["id"].ToString();
            this.userName = dictionary["userName"].ToString();
            this.set = true;
        }

        public User(string userName, string localId)
        {
            this.userName = userName;
            this.id = localId;
        }

        public void print()
        {
            Debug.Log("USER: " + userName + " " + id);
        }
    }
}