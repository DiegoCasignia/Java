package connectionudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
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
        byte[] bufferInput = new byte[1024];
        byte[] bufferOutput = new byte[1024];
        System.out.println("Server:");
        try {
            DatagramSocket socket = new DatagramSocket(port);
            DatagramPacket input = new DatagramPacket(bufferInput, bufferInput.length);
            socket.receive(input);
            String message = new String(input.getData());
            System.out.println(message);
            int clientPort = input.getPort();
            InetAddress clientAddress = input.getAddress();
            message = "Successful Connection";
            bufferOutput = message.getBytes();
            DatagramPacket output = new DatagramPacket(bufferOutput, bufferOutput.length, clientAddress, clientPort);
            socket.send(output);
            socket.close();
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
