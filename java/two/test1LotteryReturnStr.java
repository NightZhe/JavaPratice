
import java.util.Arrays;
import java.util.Random;

public class test1LotteryReturnStr {

    static String[] lottoNumbers = new String[6];
    public String[] a;

    public static void main(String[] args) {
        String[] a = playLotto();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }

    public static String[] playLotto() {
        Random random = new Random();

        // 產生樂透號碼
        for (int i = 0; i < 6; i++) {
            int randomNumber = random.nextInt(49) + 1;
            String lottoNumber = String.format("%02d", randomNumber);
            while (Arrays.asList(lottoNumbers).contains(lottoNumber)) {
                // 如果已經有這個數字，重新產生
                randomNumber = random.nextInt(49) + 1;
                lottoNumber = String.format("%02d", randomNumber);
            }
            lottoNumbers[i] = lottoNumber;
        }

        // 將樂透號碼排序
        Arrays.sort(lottoNumbers);

        return lottoNumbers;
    }
}