package connectiontcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego Casignia
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 6000;
        Socket socket;
        DataInputStream input;
        DataOutputStream output;
        System.out.println("Client:");
        try {
            socket = new Socket(host, port);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            output.writeUTF("New Connection");
            String message = input.readUTF();
            System.out.println(message);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
