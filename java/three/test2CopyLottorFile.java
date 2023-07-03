import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class test2CopyLottorFile {
    public static void main(String[] args) {
        // 取得今天的日期
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String today = dateFormat.format(cal.getTime());

        File sourceFile = new File("/Users/ben/Documents/myjava/three/Lotto.txt"); // 要複製的原始檔案路徑
        File targetFile = new File("./Lotto_" + today + ".txt"); // 複製後的目標檔案路徑

        try {
            Files.copy(sourceFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("檔案已成功複製");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}