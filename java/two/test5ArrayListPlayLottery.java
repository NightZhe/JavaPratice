import java.util.ArrayList;

public class test5ArrayListPlayLottery extends test1LotteryReturnStr {

    public class LottoGenerator {
        public static ArrayList<String> playLottoList(String[] lottoNumbers) {
            ArrayList<String> lottoList = new ArrayList<String>();

            // 將 String 陣列中的每個元素加入 ArrayList 中
            for (String num : lottoNumbers) {
                lottoList.add(num);
            }

            return lottoList;
        }
    }

    public static void main(String[] args) {
        String[] a = test1LotteryReturnStr.playLotto();
        ArrayList<String> lottoList = LottoGenerator.playLottoList(a);
        System.out.println("本期大樂透中獎號碼為：" + lottoList);
    }

}
