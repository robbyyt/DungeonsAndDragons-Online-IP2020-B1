using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System;
using System.Text.RegularExpressions;
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
        /*bool UN=false;
        bool EM=false;
        bool PW=false;
        bool CPW=false;
        if(Username!=""){
            if(System.IO.File.Exists(@"C:/Users/Tudor/Dungeons&Dragons/"+Username+".txt")){
                Debug.LogWarning("Username Taken!");
        }
        else{
           UN=true;
        }
        }
        else Debug.LogWarning("Username field is empty!");*/
        print("Registration Successful!");
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
