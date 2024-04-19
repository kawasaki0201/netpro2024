import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class HowOldAreYou {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                System.out.println("何歳ですか？");
                String line = reader.readLine();
                
                if (line.equalsIgnoreCase("q") || line.equalsIgnoreCase("e")) {
                    System.out.println("終了します。");
                    break;
                }
                
                int age = Integer.parseInt(line);
                
                if (age >= 120) {
                    System.out.println("再入力してください。");
                    continue;
                }

                int currentYear = LocalDate.now().getYear();
                int birthYear = currentYear - age;
                String era = getEra(birthYear);
                int n = getn(birthYear);
                System.out.println("あなたは2030年、" + (age + 6) + "歳ですね。");
                if (n == 1) {
                    System.out.println("あなたが生まれた年は" + era + "元年ですね。");
                } else {
                    System.out.println("あなたが生まれた年は" + era + n + "年ですね。");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println(e);
        } catch (NumberFormatException e) {
            System.out.println("数字を入力してください。");
        }
    }

    public static String getEra(int year) {
        String era;
        if (year >= 1868 && year < 1912) {
            era = "明治";
        } else if (year >= 1912 && year < 1926) {
            era = "大正";
        } else if (year >= 1926 && year < 1989) {
            era = "昭和";
        } else if (year >= 1989 && year < 2019) {
            era = "平成";
        } else {
            era = "令和";
        }
        return era;
    }

    public static int getn(int year) {
        int n;
        if (year >= 1868 && year < 1912) {
            n = year - 1868 + 1;
        } else if (year >= 1912 && year < 1926) {
            n = year - 1912 + 1;
        } else if (year >= 1926 && year < 1989) {
            n = year - 1926 + 1;
        } else if (year >= 1989 && year < 2019) {
            n = year - 1989 + 1;
        } else {
            n = year - 2019 + 1;
        }
        return n;
    }
}