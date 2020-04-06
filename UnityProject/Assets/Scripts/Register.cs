using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System;
using System.Text.RegularExpressions;
using Conectivitate.Authentication.Models;
using UnityEngine.UI;

public class Register : MonoBehaviour
{
    public GameObject username;
    public GameObject email;
    public GameObject password;
    public GameObject confPassword;
    private string Username;
    private string Email;
    private string Password;
    private string ConfPassword;
    private string form;
    private bool EmailValid=false;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    public void RegisterButton(){
        AuthenticationController auth = new AuthenticationController();
        auth.RegisterUser(new RegisterPayload(this.Username, this.Email, this.Password));

    }

    // Update is called once per frame
    void Update()
    {
        if(Input.GetKeyDown(KeyCode.Tab)){
            if(username.GetComponent<InputField>().isFocused){
                email.GetComponent<InputField>().Select();
            }
            if(email.GetComponent<InputField>().isFocused){
                password.GetComponent<InputField>().Select();
            }
            if(password.GetComponent<InputField>().isFocused){
                confPassword.GetComponent<InputField>().Select();
            }
        }
        if (Input.GetKeyDown(KeyCode.Return)){
            if(Username!=""&&Email!=""&&Password!=""&&ConfPassword!=""){
                RegisterButton();
            }
        }
        Username=username.GetComponent<InputField>().text;
        Email=email.GetComponent<InputField>().text;
        Password=password.GetComponent<InputField>().text;
        ConfPassword=confPassword.GetComponent<InputField>().text;
    }
}
