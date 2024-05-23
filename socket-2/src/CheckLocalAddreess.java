import java.net.InetAddress;
import java.net.UnknownHostException;

public class CheckLocalAddreess {
    public static void main(String[] args) {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            System.out.println("Host name is: " + addr.getHostName());
            System.out.println("Ip address is: " + addr.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("エラーです");
            e.printStackTrace();
        }
    }
}
