import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HalloweenServer {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            scanner.close();
            System.out.println("localhostの" + port + "番ポートで待機します");
            ServerSocket server = new ServerSocket(port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("接続しました。相手の入力を待っています......");

                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                while (true) {
                    MyHalloweenGhost ghost = (MyHalloweenGhost) ois.readObject();
                    if (ghost == null) break;
                    System.out.println("クライアントから受信したお化け: " + ghost);

                    oos.writeObject(ghost);
                    oos.flush();
                }

                ois.close();
                oos.close();
                socket.close();
                System.out.println("クライアントとの接続を終了しました。");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}