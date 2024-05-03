import java.util.Arrays;
import java.util.Random;

public class HeikinCKadai {
	public static final int N=100;
	Kamoku[] kamoku = new Kamoku[N];
	static String kamokuname="数学";

	public static void main(String[] args) {
		HeikinCKadai heikinb= new HeikinCKadai(kamokuname);
		heikinb.initalizeScores();
		heikinb.printAverage();
		heikinb.gokakusha();

	}
	
	HeikinCKadai(String s){
		this.kamokuname=s;
		
	}
	void initalizeScores(){
		Random r = new Random();

		for(int i=0;i<N;i++){
			int score = r.nextInt(N+1);
			kamoku[i]= new Kamoku(score);

		}
	
	}
	
	void printAverage(){
		int sum=0;
		for(int i=0;i<N;i++){
			sum+=kamoku[i].getScore();

		}
		System.out.println("*平均点は"+sum/N+"*");

	}

	void gokakusha(){
        int h=0;
        int[] hairetsu = new int[kamoku.length];
        for(Kamoku k :kamoku){
            hairetsu[h]=k.getScore();
            h++;
	}//student idと点数をソートしてだせ。＞＝８０以上
Arrays.sort(hairetsu);
System.out.println("*以下合格者の点数です。*");
    for (int score : hairetsu) {
        if (score >= 80) {
            System.out.println("");
            System.out.println("*" + score+"*");
        }
    }
}
}