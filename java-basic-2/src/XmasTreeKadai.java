public class XmasTreeKadai {

    public static void main(String[] args) {
        /*
        while(i<10) {
            Scanner scan = new Scanner(System.in);

            String str = scan.next();
            System.out.println("最初のトークンは: " + str);
            System.out.println("文字を分割すると・・・");
            String[] word = str.split(",");//splitメソッドの引数に、どこの文字で分割するか指定します。この場合は空白文字。
            for(String w:word) {
                System.out.println(w);
            }
            System.out.println("word[0]"+word[0]);
            System.out.println("word[1]"+word[1]);
            System.out.println("word[2]"+word[2]);
            System.out.println("word[3]"+word[3]);
            //19,3,7,c
            //first = Integer.parseInt(str);
            System.out.println("----次の数字の入力をお願いします ");
        }
        */
        int N=19;
        int M=7;
        for (int j = 0; j < N; j++) {

            for (int i = 0; i <= N-j; i++) {
                if((i+j)%2==0)
                System.out.print("+");
                else
                System.out.print(" ");
            }

            for (int i = 0; i <= j*2; i++) {
                System.out.print("*");
            }

            for (int i = 0; i <= N-j; i++) {
                if(i%2==0)
                System.out.print("+");
                else
                System.out.print(" ");
            }

            System.out.print("\n");
        }
        for (int j=0; j<M; j++) {
        for (int i=0; i<N; i++) {
            System.out.print(" ");
        }
        System.out.println("***");
    }
    }
}

//  課題    キーボードから2つの数字を打ち込む
//     その足し算結果を、出力する。