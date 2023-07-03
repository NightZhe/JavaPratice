
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class test4MoreFile extends test1OutputLotteryTxt {
    public static void main(String[] args) {
        for(int i=0; i<=20; i++){
            List<List<String>> lottoNumbers = lotteryprodece();
            try (FileWriter writer = new FileWriter("./Lotto_" + (String.format("%02d", i)) + ".txt")) {
                for ( List<String> numbers : lottoNumbers) {
                    String line = String.join(" ", numbers.toString().replaceAll("\\[|\\]|,", "")) + "\n";
                    writer.write(line);
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.print("成功輸出");
    }
}
