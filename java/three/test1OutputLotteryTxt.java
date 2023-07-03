import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class test1OutputLotteryTxt {
    public static String a;

    public static void main(String[] args) {
        // 將結果輸出至Lotto.txt檔
        List<List<String>> lottoNumbers = lotteryprodece();
        try (FileWriter writer = new FileWriter("Lotto.txt")) {
            for (List<String> numbers : lottoNumbers) {
                String line = String.join(" ", numbers.toString().replaceAll("\\[|\\]|,", "")) + "\n";
                writer.write(line);
            }
        System.out.print("輸出成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<List<String>> lotteryprodece(){
        List<List<String>> lottoNumbers = new ArrayList<>();
        Random random = new Random();

        // 產生100筆大樂透號碼
        for (int i = 0; i < 100; i++) {
            List<String> numbers = new ArrayList<>();
            while (numbers.size() < 6) {
                int num = random.nextInt(49) + 1;
                String nums = String.format("%02d", num);

                if (!numbers.contains(nums)) {
                    a = String.format("%02d", num);
                    numbers.add(a);
                }
            }
            Collections.sort(numbers);
            lottoNumbers.add(numbers);
        }
        return lottoNumbers;
    }
}