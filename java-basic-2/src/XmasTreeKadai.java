public class XmasTreeKadai {
    public static void main(String[] args) {
        int height = 10; // ツリーの高さを設定します

        // ツリーの各行を表示します
        for (int i = 1; i <= height; i++) {
            // スペースを追加して左揃えにします
            for (int j = 1; j <= height - i; j++) {
                System.out.print(" ");
            }
            // アスタリスクを追加します
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            // 改行します
            System.out.println();
        }

        // 木の幹を表示します
        for (int i = 1; i <= height - 1; i++) {
            // スペースを追加します
            for (int j = 1; j <= height - 1; j++) {
                System.out.print(" ");
            }
            // 幹を追加します
            System.out.println("*");
        }
    }
}
