using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class MessagesManager : MonoBehaviour
{
    public GameObject messagePrefab;
    public GameObject messagesArea;
    public Text messagesTextInput;
    
    public void AddMessage()
    {
        GameObject newMessage = Instantiate(messagePrefab, messagesArea.transform);
        newMessage.GetComponent<ChatMessage>().SetText("Player 1",  messagesTextInput.text);
        messagesTextInput.text = "";
    }

    public void AddMessage(string playerName, string message)
    {
        GameObject newMessage = Instantiate(messagePrefab, messagesArea.transform);
        newMessage.GetComponent<ChatMessage>().SetText(playerName, message);
        messagesTextInput.text = "";
    }
}
