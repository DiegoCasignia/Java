package connectionudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego Casignia
 */
public class Client {

    public static void main(String[] args) {
        int serverPort = 6000;
        byte[] bufferInput = new byte[1024];
        byte[] bufferOutput = new byte[1024];
        DatagramSocket socket;
        System.out.println("Client:");
        try {
            InetAddress serverAdress = InetAddress.getByName("localhost");
            socket = new DatagramSocket();
            String message = "New Connection";
            bufferOutput = message.getBytes();
            DatagramPacket output = new DatagramPacket(bufferOutput, bufferOutput.length, serverAdress, serverPort);
            socket.send(output);
            DatagramPacket input = new DatagramPacket(bufferInput, bufferInput.length);
            socket.receive(input);
            message = new String(input.getData());
            System.out.println(message);
            socket.close();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
