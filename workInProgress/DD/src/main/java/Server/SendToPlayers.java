package Server;

import org.json.simple.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
//testing
public class SendToPlayers {

    public static void  sendToMore(List<Player> playerList, JSONObject json){

        for(Player p : playerList){
            Socket s = p.getSocket();
            try {
                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                byte [] toSend = json.toString().getBytes();
                out.write(toSend);
            }
            catch (IOException e){
                e.getStackTrace();
            }
        }
    }


}
