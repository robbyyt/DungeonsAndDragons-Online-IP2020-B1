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
   public class DatabaseHandler
   {
     private DatabaseReference _databaseReference;
     public DatabaseHandler()
     {
       FirebaseApp.CheckAndFixDependenciesAsync().ContinueWith(task =>
       {
         DependencyStatus dependencyStatus = task.Result;
         if (dependencyStatus == DependencyStatus.Available)
         {
           InitializeFirebase();
         }
         else
         {
           Debug.LogError(
             "Could not resolve all Firebase dependencies: " + dependencyStatus);
         }
       });
     }

     // Initialize the Firebase database:
     protected virtual void InitializeFirebase()
     {
       FirebaseApp app = FirebaseApp.DefaultInstance;
       app.SetEditorDatabaseUrl("https://dungeonsanddragons-ip2020.firebaseio.com/");
       _databaseReference = FirebaseDatabase.DefaultInstance.RootReference;
     }

     public bool addUserToDatabase(User userToAdd)
     {
       if(userToAdd==null)
         throw new NullReferenceException("User este nul.");
      
       var userJson = JsonUtility.ToJson(userToAdd);
       _databaseReference.Child("users").Child(userToAdd.id).SetRawJsonValueAsync(userJson);
       
       return true;
     }
   }
 }