package networking.udp;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPMulticastServer {
    public static void main(String[] argv) throws Exception {
        DatagramSocket receiveSocket = new DatagramSocket(5100);
        System.out.println("Server is listening on port 5100...");

        byte receiveBuffer[] = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

        while (true) {
            receiveSocket.receive(receivePacket);

            String receivedData = new String(receivePacket.getData(), 0, receivePacket.getLength());
        }
    }
}
