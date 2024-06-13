package netpro2024.mid_exam.q12;

import java.util.Random;

public class SortBattle {
    public static void main(String[] args) {
        int count = 20000;
        Random r = new Random();

        Thread[] threads1 = new Thread[5];
        Thread[] threads2 = new Thread[5];

        for (int i = 0; i < 5; i++) {
            int[] nums = new int[count];
            for (int j = 0; j < count; j++) {
                nums[j] = r.nextInt(1000);
            }
            threads1[i] = new Thread(new BubbleSortRunnable(nums));
            threads2[i] = new Thread(new JavaUtilSortRunnable(nums));
        }

        for (int i = 0; i < 5; i++) {
            threads1[i].start();
            threads2[i].start();
        }
    }
}

