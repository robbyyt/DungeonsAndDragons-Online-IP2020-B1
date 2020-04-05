using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class ChatMessage : MonoBehaviour
{
    public string senderName { get; private set; }
    public string message { get; private set; }
    public Text MessageField;
    public Text SenderField;

    public void SetText(string senderName, string message)
    {
        this.senderName = senderName;
        this.message = message;
        SenderField.text = senderName + ":";
        MessageField.text = message;
        TextGenerator textGen = new TextGenerator();
        TextGenerationSettings generationSettings = MessageField.GetGenerationSettings(MessageField.rectTransform.rect.size);
        GetComponent<RectTransform>().sizeDelta = new Vector2(
            GetComponent<RectTransform>().sizeDelta.x,
            textGen.GetPreferredHeight(MessageField.text, generationSettings));
    }

}
