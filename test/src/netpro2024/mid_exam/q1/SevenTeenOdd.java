package netpro2024.mid_exam.q1;

public class SevenTeenOdd {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= 800; i++) {
        /* ↓下記を埋める。*/  
        if (i % 17 == 0 && i % 2 != 0) {
            if (result.length() > 0) {
                result.append(",");
            }
            result.append(i);
        }
         /* ↑上記を埋める。*/   
        }
        System.out.println(result.toString());
    }
}

