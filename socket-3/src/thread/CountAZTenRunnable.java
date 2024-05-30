package thread;

public class CountAZTenRunnable implements Runnable {
    String myAlfabetStr="noalfabet";

    public static void main(String[] args){
        CountAZTenRunnable[] cts = new CountAZTenRunnable[26];

        char c1 = 97;
        char c2 = (char)(c1 + 1);
        char c3 = (char)(c2 + 1);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        for(int i=0;i<cts.length;i++){
            cts[i]=new CountAZTenRunnable();
            String name_with_alfabet=(char)(97+i)+"_chan ";
            cts[i].setAlfabet(name_with_alfabet);
        }

        for(CountAZTenRunnable ct:cts){
            new Thread(ct).start();
        }

        try {
            for(int i = 0; i < 10; i++) {
                System.out.println("main:i=" + i);

                Thread.sleep(500);
            }
        }
        catch(InterruptedException e) {
            System.err.println(e);
        }
    }

    public void setAlfabet(String alfabetstr) {
        myAlfabetStr = alfabetstr;
    }

    public void run() {
        try {
            for(int i = 0; i < 10; i++) {
                System.out.println(myAlfabetStr+"thread:i=" + i);

                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e) {
            System.err.println(e);
        }
    }
}