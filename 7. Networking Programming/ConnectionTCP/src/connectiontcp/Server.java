package connectiontcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego Casignia
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port = 6000;
        ServerSocket serverSocket;
        Socket socket;
        DataInputStream input;
        DataOutputStream output;
        System.out.println("Server:");
        try {
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            String message = input.readUTF();
            System.out.println(message);
            output.writeUTF("Successful Connection");
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
