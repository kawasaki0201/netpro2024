package netpro2024.mid_exam.q12;
/* 変更不可 (package 補正は可)  */
public class BubbleSortRunnable implements Runnable {
    private int[] arr;
    public BubbleSortRunnable(int[] arr) {
        this.arr = arr;
    }
    public void run() {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int t = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = t;
                }
            }
        }
        System.out.println("bubble sort finish");
    }
}
