import java.util.TreeSet;
import java.util.HashMap;

public class test6HashMapLottery extends test4TreeSetLottery {
    public static HashMap<Integer, String> playLottoMap(TreeSet<String> lottoNumbers) {
        HashMap<Integer, String> lottoMap = new HashMap<Integer, String>();

        // 將樂透號碼放入 HashMap 中
        int i = 1;
        for (String num : lottoNumbers) {
            lottoMap.put(i++, num);
        }

        return lottoMap;
    }

    public static void main(String[] args) {
        TreeSet<String> lottoNumbers = generateLottoNumbers();
        HashMap<Integer, String> lottoMap = playLottoMap(lottoNumbers);

        System.out.println("本期大樂透中獎號碼為：" + lottoNumbers);
        System.out.println("本期大樂透中獎號碼 (HashMap)：" + lottoMap);
    }
}
