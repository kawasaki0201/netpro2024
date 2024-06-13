package netpro2024.mid_exam.q6;

import java.util.Random;
import java.util.Scanner;

public class Dice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalRolls = 0;

        while (true) {
            System.out.println("Enterを押してサイコロを振る");
            String input = scanner.nextLine();

            if (input.equals("0") || input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("exit")) {
                System.out.println("Diceプログラム終了します。");
                break;
            }

            int diceRoll = random.nextInt(6) + 1;
            totalRolls++;
            System.out.println(diceRoll + "(累計" + totalRolls + "回目)");
        }

        scanner.close();
    }
}
