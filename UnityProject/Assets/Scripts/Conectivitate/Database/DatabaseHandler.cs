using Conectivitate.Authentication.Models;
using Firebase.Auth;

namespace Conectivitate.Database
{
    using Firebase;
    using Firebase.Database;
    using Firebase.Unity.Editor;
    using System;
    using System.Collections;
    using System.Collections.Generic;
    using System.Threading.Tasks;
    using UnityEngine;
    using UnityEngine.UI;
    
    public sealed class DatabaseHandler
    {
        private DatabaseReference _databaseReference;

        public DatabaseHandler()
        {
            //setez instanta bazei de date si preluam referinta catre baza
            FirebaseApp.DefaultInstance.SetEditorDatabaseUrl("https://dungeonsanddragons-ip2020.firebaseio.com/");
            _databaseReference = FirebaseDatabase.DefaultInstance.RootReference;
        }

        public void AddUserToDatabase(User userToAdd)
        {
            //cream un json format din atributele user-ului
            var json = JsonUtility.ToJson(userToAdd);

            //setez identificatorul unic egal cu id-ul user-ului Firebase curent si introduc in baza de date json-ul
            var userId = FirebaseAuth.DefaultInstance.CurrentUser.UserId;
            _databaseReference.Child("users").Child(userId).SetRawJsonValueAsync(json);
        }

        public User RetrieveUserFromDatabase()
        {
            User userRetrieved = new User();
            string userId = FirebaseAuth.DefaultInstance.CurrentUser.UserId;

            _databaseReference.Child("users").GetValueAsync().ContinueWith(task =>
            {
                if (task.IsFaulted)
                {
                    Debug.Log("TASK FAILED");
                }
                else if (task.IsCompleted)
                {
                    DataSnapshot snapshot = task.Result;
                    foreach (DataSnapshot user in snapshot.Children)
                    {
                        IDictionary dictUser = (IDictionary) user.Value;
                        if (!dictUser["id"].ToString().Equals(userId)) continue;
                        Debug.Log("" + dictUser["id"] + " - " + dictUser["userName"]);
                        User cUser= new User(dictUser);
                        AppUser.SetUser(cUser);
                        return cUser;
                    }
                }

                return null;
            });

            return userRetrieved;
        }
    }
}