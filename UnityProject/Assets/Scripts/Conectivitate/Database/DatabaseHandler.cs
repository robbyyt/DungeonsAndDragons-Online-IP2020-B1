using Conectivitate.Authentication.Models;
using Firebase.Auth;

namespace Conectivitate.Database
{
    using Firebase;
    using Firebase.Database;
    using Firebase.Unity.Editor;
    using System.Collections;
    using UnityEngine;
    
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

            _databaseReference.Child("users").GetValueAsync().ContinueWith(task => //accesam baza de date "users" in mod asincron
            {
                if (task.IsFaulted)
                {
                    Debug.Log("TASK FAILED");
                }
                else if (task.IsCompleted)
                {
                    DataSnapshot snapshot = task.Result;
                    foreach (DataSnapshot user in snapshot.Children)//parcurgem baza de date (fiecare children din users)
                    {
                        IDictionary dictUser = (IDictionary) user.Value;//se creeaza un dictionar din json-ul luat din baza de date
                        if (!dictUser["id"].ToString().Equals(userId)) continue;//daca id-ul user-ului este egal cu id-ul cautat, continuam
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