using System;
using System.Net.Sockets;
using System.Text;
using System.Threading;
using UnityEngine;

public class TCPClient : MonoBehaviour
{
    private static TcpClient socketConnection;

    private static Thread clientReceiveThread;

    // Start is called before the first frame update
    void Start()
    {
        ConnectToTcpServer();
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetKeyDown(KeyCode.Space)) {             
            SendMessage("{\"PROTOCOL\":\"RANDOM\"}");         
        }
    }

    private void ConnectToTcpServer()
    {
        try {
            if (clientReceiveThread == null)
            {
                clientReceiveThread = new Thread (new ThreadStart(ListenForData)); 			
                clientReceiveThread.IsBackground = true; 			
                clientReceiveThread.Start();   
            }
        } 		
        catch (Exception e) { 			
            Debug.Log("On client connect exception " + e); 		
        } 	
    }
    
    private void ListenForData() { 		
        try {
            if (socketConnection == null)
            {
                socketConnection = new TcpClient("89.38.74.214", 8000);
            }
            Byte[] bytes = new Byte[1024];             
            while (true) { 				
                // Get a stream object for reading 				
                using (NetworkStream stream = socketConnection.GetStream()) { 					
                    int length; 					
                    // Read incoming stream into byte array. 					
                    while ((length = stream.Read(bytes, 0, bytes.Length)) != 0) { 						
                        var incommingData = new byte[length]; 						
                        Array.Copy(bytes, 0, incommingData, 0, length); 						
                        // Convert byte array to string message. 						
                        string serverMessage = Encoding.ASCII.GetString(incommingData); 
                        HandleResponse(serverMessage);
                        //Debug.Log("Server message received as: " + serverMessage); 					
                    } 				
                } 			
            }         
        }         
        catch (SocketException socketException) {             
            Debug.Log("Socket exception: " + socketException);         
        }     
    }

    private static void SendMessage(string clientMessage)
    {
        if (socketConnection == null) {             
            return;         
        }
        
        try { 			
            // Get a stream object for writing. 			
            NetworkStream stream = socketConnection.GetStream(); 			
            if (stream.CanWrite) {
                // Convert string message to byte array.                 
                byte[] clientMessageAsByteArray = Encoding.ASCII.GetBytes(clientMessage); 				
                // Write byte array to socketConnection stream.                 
                stream.Write(clientMessageAsByteArray, 0, clientMessageAsByteArray.Length);                 
                Debug.Log("Client sent his message - should be received by server:" + clientMessage);             
            }         
        } 		
        catch (SocketException socketException) {             
            Debug.Log("Socket exception: " + socketException);         
        }
    }

    private void HandleResponse(string serverResponse)
    {
        Debug.Log(serverResponse);
    }
}