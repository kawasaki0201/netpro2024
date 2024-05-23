import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket;
import java.util.Scanner;

public class TaskClientWhile {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            scanner.nextLine();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");

            while (true) {
                Socket socket = new Socket("localhost", port);
                System.out.println("接続されました");
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                System.out.println("数値を入力してください(1以下の数値を入力すると終了します) ↓");
                int message = scanner.nextInt();
                scanner.nextLine();
                if (message <= 1) {
                    System.out.println("接続を終了します。");
                    TaskObject present = new TaskObject();
                    present.setExecNumber(message);
                    oos.writeObject(present);
                    oos.flush();
                    oos.close();
                    socket.close();
                    break;
                }

                TaskObject present = new TaskObject();
                present.setExecNumber(message);

                oos.writeObject(present);
                oos.flush();

                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

                TaskObject okaeshiPresent = (TaskObject) ois.readObject();

                int replayMsg = okaeshiPresent.getResult();
                System.out.println("最大の素数は" + replayMsg);

                ois.close();
                oos.close();
                socket.close();
            }

            scanner.close();
        } catch (BindException be) {
            be.printStackTrace();
            System.err.println("ポート番号が不正か、サーバが起動していません");
            System.err.println("サーバが起動しているか確認してください");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
