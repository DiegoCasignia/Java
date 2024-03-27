package chat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego Casignia
 */
public class Client implements Runnable {
    private final int port;
    private final String message;

    public Client(int port, String message) {
        this.port = port;
        this.message = message;
    }
    
    @Override
    public void run() {
        String host = "127.00.1";
        Socket socket;
        try {
            socket = new Socket(host, port);
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            output.writeUTF(message);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
