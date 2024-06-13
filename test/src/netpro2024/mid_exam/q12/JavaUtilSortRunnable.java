package netpro2024.mid_exam.q12;

import java.util.Arrays;

public class JavaUtilSortRunnable implements Runnable {
    private int[] arr;

    public JavaUtilSortRunnable(int[] arr) {
        this.arr = arr;
    }

    public void run() {
        Arrays.sort(arr);
        System.out.println("no");
    }
}