package netpro2024.mid_exam.q3;

public class Dots {
    public static void main(String[] args) {
        int n = 7; // ギザギザ模様の最大長さ

        // 模様を3回繰り返す
        for (int k = 0; k < 3; k++) {
            // 上半分のギザギザ模様を書く↓
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("●");
                }
                System.out.println();
            }

            // 下半分のギザギザ模様を書く↓
            for (int i = n; i >= 1; i--) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("●");
                }
                System.out.println();
            }
        }
    }
}
