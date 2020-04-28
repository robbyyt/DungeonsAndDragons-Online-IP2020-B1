package Server;

import java.net.Socket;
//retine socketele unui jucator, trebe un nume ca sa identific
//
public class Player {
    String name;//pentru identificare
    Socket socket;

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Socket getSocket() {
        return socket;
    }

    public String getName() {
        return name;
    }
}
