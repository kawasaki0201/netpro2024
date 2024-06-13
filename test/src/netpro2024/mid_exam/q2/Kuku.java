package netpro2024.mid_exam.q2;

public class Kuku {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            StringBuilder row = new StringBuilder("|");
            for (int j = 1; j <= 9; j++) {
                int result = i * j;
                if (result < 10) {
                    row.append(" ").append(result);
                } else {
                    row.append(result);
                }
                row.append("|");
            }
            System.out.println(row.toString());
        }
    }
}
