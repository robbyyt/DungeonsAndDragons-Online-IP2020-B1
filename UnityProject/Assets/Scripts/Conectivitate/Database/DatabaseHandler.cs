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

// Handler for UI buttons on the scene.  Also performs some
// necessary setup (initializing the firebase app, etc) on
// startup.
   public sealed class DatabaseHandler
   {
     private DatabaseReference _databaseReference;
     public DatabaseHandler()
     {
       FirebaseApp.DefaultInstance.SetEditorDatabaseUrl("https://dungeonsanddragons-ip2020.firebaseio.com/");
       _databaseReference = FirebaseDatabase.DefaultInstance.RootReference;
     }

     public void AddUserToDatabase(User userToAdd)
     {
       Debug.Log("ADDING");
       Debug.Log(_databaseReference.Database);
        string key = _databaseReference.Child("users").Push().Key;
        Debug.Log("Cheia este: "+key);
        var json = JsonUtility.ToJson(userToAdd);
        _databaseReference.Child("users").Child(key).SetRawJsonValueAsync(json);
     }
   }
 }