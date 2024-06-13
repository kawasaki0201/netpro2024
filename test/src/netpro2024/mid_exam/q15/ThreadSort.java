package netpro2024.mid_exam.q15;
public class ThreadSort {

    public static void main(String[] args) {
				// int の配列を与える
        sortPrint(new int[]{3, 1, 4, 15, 9, 21});
    }

    public static void sortPrint(int[] arr) {
        Item[] items = new Item[arr.length];

        for (int i = 0; i < items.length; i++) {
            items[i] = new Item(arr[i]);
        }

        // 各 Item オブジェクトに対してスレッドを作成して開始
        for (Item item : items) {
            new Thread(item).start();
        }
    }

    static class Item implements Runnable {
        int n;

        Item(int n) {
            this.n = n;
        }

        public void run() {
            try {
                Thread.sleep(n * 100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(n);
        }
    }
}