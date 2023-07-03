import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class test3ReadFileCatch {

    public static void main(String[] args) {
        String filePath = "/Users/ben/Documents/myjava/3/Lotto.txt"; // 要讀取的檔案路徑
        int lineNum = 5; // 要讀取的行數

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int currentLineNum = 1;
            while ((line = reader.readLine()) != null) {
                if (currentLineNum == lineNum) {
                    // 找到指定行數的資料
                    System.out.println(line);

                    break;
                }
                currentLineNum++;
            }
            FileWriter fw = new FileWriter("Lotto_new.txt");
            fw.write("第" + lineNum + "筆樂透\n");

            String[] arrSplit = line.split(" ");
            for (String i : arrSplit) {
                fw.write(i + '\n');
            }
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
