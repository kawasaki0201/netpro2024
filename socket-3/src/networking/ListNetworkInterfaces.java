package networking;

import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class ListNetworkInterfaces {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface ni = interfaces.nextElement();
                System.out.println("Interface: " + ni.getName());
                System.out.println("  Display Name: " + ni.getDisplayName());
                System.out.println("  Is Up: " + ni.isUp());
                System.out.println("  Supports Multicast: " + ni.supportsMulticast());
                System.out.println("  Hardware Address: " + (ni.getHardwareAddress() != null ? bytesToHex(ni.getHardwareAddress()) : "null"));
                for (InterfaceAddress ia : ni.getInterfaceAddresses()) {
                    System.out.println("  Address: " + ia.getAddress());
                }
                System.out.println();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X:", b));
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
    }
}