package netpro2024.mid_exam.q5;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyGetPCIPv4 {

    public static void main(String[] args) {
        try {
//            // ここにコードを記載する
            InetAddress localHost = InetAddress.getLocalHost();
            String ip = localHost.getHostAddress();
            System.out.println("IPアドレス: " + ip);
        } catch (UnknownHostException e) {
            System.out.println("Error");
        }
    }
}