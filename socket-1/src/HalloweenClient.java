import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class HalloweenClient {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            while (true) {
                System.out.println("お化けの名前を入力してください: (半角英字でのみ入力(アルファベット),例:kabotya),(終了するにはexitと入力してください)");
                String name = scanner.next();
                if (name.equalsIgnoreCase("exit")) {
                    oos.writeObject(null);
                    break;
                }

                System.out.println("恐怖レベルを入力してください:(1~4の半角英数字で入力) ");
                int scareLevel = scanner.nextInt();

                MyHalloweenGhost ghost = new MyHalloweenGhost(name, scareLevel);
                oos.writeObject(ghost);
                oos.flush();

                MyHalloweenGhost receivedGhost = (MyHalloweenGhost) ois.readObject();
                System.out.println("サーバから返されたお化け: " + receivedGhost);
            }

            ois.close();
            oos.close();
            socket.close();
            System.out.println("サーバとの接続を終了しました。");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}