package chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego Casignia
 */
public class Server extends Observable implements Runnable {
    private final int port;

    public Server(int port) {
        this.port = port;
    }
    
    @Override
    public void run() {
        Socket socket;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while(true){
                socket = serverSocket.accept();
                DataInputStream input = new DataInputStream(socket.getInputStream());
                String message = input.readUTF();
                this.setChanged();
                this.notifyObservers(message);
                this.clearChanged();
                socket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
