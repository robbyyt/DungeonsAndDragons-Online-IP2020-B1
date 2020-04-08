using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using System.Text.RegularExpressions;
using System;

public class Login : MonoBehaviour
{
    public GameObject username;
    public GameObject password;
    private string Username;
    private string Password;
    private string form;
    private bool EmailValid=false;
    // Start is called before the first frame update
    void Start()
    {
    }

    public void LoginButton(){
        print("Login Successful!");
        Application.LoadLevel("LobbyMenu");
        //ScreenManager.LoadScene("Start Menu");
    }
    // Update is called once per frame
    void Update()
    {
        if(Input.GetKeyDown(KeyCode.Tab)){
            if(username.GetComponent<InputField>().isFocused){
                password.GetComponent<InputField>().Select();
            }
        }
        if (Input.GetKeyDown(KeyCode.Return)){
            if(Username!=""&&Password!=""){
                LoginButton();
            }
        }
        Username=username.GetComponent<InputField>().text;
        Password=password.GetComponent<InputField>().text;
    }
}
