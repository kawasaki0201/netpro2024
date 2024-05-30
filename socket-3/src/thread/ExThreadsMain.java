package thread;

public class ExThreadsMain implements Runnable{
        String myAlfabetStr="noalfabet";
        public static void main(String[] args){
            ExThreadsMain[] cts = new ExThreadsMain[26];
    
            char c1 = 65;
            char c2 = (char)(c1 + 1);
            char c3 = (char)(c2 + 1);
    
            System.out.println(c1);
            System.out.println(c2);
            System.out.println(c3);
    
            for(int i=0;i<cts.length/2;i++){
                cts[i]=new ExThreadsMain();
                String name_with_alfabet=(char)(65+i)+"_kun と"+(char)(65+i+1)+"_sama ";
                cts[i].setAlfabet(name_with_alfabet);
            }
    
            for(ExThreadsMain ct:cts){
                new Thread(ct).start();
            }
    
            try {
                for (int i = 0; i < 11; i++) {
                    char c = (char) (97 + i);
                    System.out.println("main: " + c);

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
                for(int i = 0; i < 11; i++) {
                    System.out.println(myAlfabetStr+"thread:i=" + i);
    
                    Thread.sleep(1000);
                }
            }
            catch(InterruptedException e) {
                System.err.println(e);
            }
        }
    }
