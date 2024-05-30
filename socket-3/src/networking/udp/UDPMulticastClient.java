package networking.udp;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPMulticastClient {
    public static void main(String[] argv) throws Exception {
        InetSocketAddress remoteAddress = new InetSocketAddress("192.168.3.255", 5100);

        String str = "HELLO";
        byte[] sendBuffer = str.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, remoteAddress);

        DatagramSocket socket = new DatagramSocket();
        socket.setBroadcast(true);
        socket.send(sendPacket);
        System.out.println(str);

        socket.close();
    }
}
