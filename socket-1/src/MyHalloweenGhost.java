import java.io.Serializable;

public class MyHalloweenGhost implements Serializable {
    private String name;
    private int scareLevel;

    public MyHalloweenGhost(String name, int scareLevel) {
        this.name = name;
        this.scareLevel = scareLevel;
    }

    public String getName() {
        return name;
    }

    public int getScareLevel() {
        return scareLevel;
    }

    @Override
    public String toString() {
        String scare=null;
        if(scareLevel==1)scare="怖くないもん";
        if(scareLevel==2)scare="ちょっと怖い...";
        if(scareLevel==3)scare="まあまあ怖い！！";
        if(scareLevel==4)scare="怖すぎ...";
        return  "お化けの名前 '" + name + '\'' +", 怖さ '" + scare +"'";
    }
}