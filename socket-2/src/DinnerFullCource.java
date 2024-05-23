public class DinnerFullCource {

        private Dish[] list = new Dish[5];// [0]-[4]の計5個
    
        public static void main(String[] args) {
    
            DinnerFullCource fullcourse = new DinnerFullCource();
            fullcourse.eatAll();
        }
    
        DinnerFullCource() {
    
            list[0] = new Dish();
            list[0].setName("ハンバーグ");
            list[0].setValune(50);
            list[1] = new Dish();
            list[1].setName("きゅうりの煮つけ");
            list[1].setValune(10);
            list[2] = new Dish();
            list[2].setName("味噌汁");
            list[2].setValune(30);
            list[3] = new Dish();
            list[3].setName("野菜の天ぷら");
            list[3].setValune(20);
            list[4] = new Dish();
            list[4].setName("揚げ出し豆腐");
            list[4].setValune(30);
        }
    
        void eatAll() {
            String str = "";
    
            for (Dish element : list) {
                str += element.getName() + "が" + element.getValune() + "円　";
            }
    
            System.out.println("今日の晩御飯コースは　" + str + "です。");
        }
    
    }
