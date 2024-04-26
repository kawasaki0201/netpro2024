public class HeikinCKadai {
public static void main(String[] args) {
    int h=0;
    int[] hairetsu = new int[kamokus.length];
    for(Kamoku k :kamokus){
        hairetsu[h]=k.getScore();
        h++;
    }
}
}
