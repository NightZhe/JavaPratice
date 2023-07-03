import java.util.Random;
import java.util.TreeSet;

public class test4TreeSetLottery {
    public static final String LottoGenerator = null;

    public static void main(String[] args) {
        TreeSet<String> lottoSet = generateLottoNumbers();
        System.out.println("本期大樂透中獎號碼為：" + lottoSet);
    }

    public static TreeSet<String> generateLottoNumbers() {
        TreeSet<String> lottoNumbers = new TreeSet<String>();
        Random random = new Random();

        // 產生樂透號碼
        while (lottoNumbers.size() < 6) {
            int randomNumber = random.nextInt(49) + 1;
            String lottoNumber = String.format("%02d", randomNumber);
            lottoNumbers.add(lottoNumber);
        }

        return lottoNumbers;
    }

}
