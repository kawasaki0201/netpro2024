package netpro2024.mid_exam.q18;

public class ReverseStringThread implements Runnable {
    private String str;

    public ReverseStringThread(String str) {
        this.str = str;
    }

    public void run() {
        String reversed = new StringBuilder(str).reverse().toString();
        System.out.println("逆順: " + reversed);
    }

    public static void main(String[] args) {
        String input = "hello";

        ReverseStringThread Thread1 = new ReverseStringThread(input);
        Thread original = new Thread(Thread1);
        original.setName("Original");

        Thread reverse = new Thread(() -> {
            System.out.println("元の文字列: " + input);
            try {
                original.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        reverse.setName("Reverse");

        // スレッドを開始してください。
        original.start();
        reverse.start();
    }
}
