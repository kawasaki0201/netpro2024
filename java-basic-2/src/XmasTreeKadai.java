import java.util.Scanner;

public class XmasTreeKadai {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = 0;
        int M = 0;

        while (N <= 0 || M <= 0) {
            System.out.print("葉の高さを入力してください:");
            N = scan.nextInt();
            System.out.print("木の幹の高さを入力してください:");
            M = scan.nextInt();

            if (N <= 0 || M <= 0) {
                System.out.println("正の整数を入力してください。");
            }
        }
        for (int j = 0; j < N; j++) {
            for (int i = 0; i <= N - j; i++) {
                if ((i + j) % 2 == 0)
                    System.out.print("+");
                else
                    System.out.print(" ");
            }

            for (int i = 0; i <= j * 2; i++) {
                System.out.print("*");
            }

            for (int i = 0; i <= N - j; i++) {
                if (i % 2 == 0)
                    System.out.print("+");
                else
                    System.out.print(" ");
            }

            System.out.println();
        }
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
                System.out.print(" ");
            }
            System.out.println("***");
        }

        scan.close();
    }
}