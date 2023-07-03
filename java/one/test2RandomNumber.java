import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class test2RandomNumber {
    public static void main(String[] args) {
        Random rd = new Random(); // 產生Random物件
        List<Integer> al = new ArrayList<>();
        while (al.size() <= 20) { // 總共10個數字
            int n = rd.nextInt(100); // 產生0~100數字
            if (al.contains(n))
                continue; // 重複的不加入
            else
                al.add(n);
            System.out.println(n);
        }

        System.out.println(al);
        Iterator it = al.iterator();
        while (it.hasNext()) {
            int x;
            x = (int) it.next();
            if (x >= 90) {
                System.out.println(x + ">>>A");
            } else if (x >= 80 && x <= 90) {
                System.out.println(x + ">>>B");
            } else if (x <= 70 && x >= 60) {
                System.out.println(x + ">>>C");
            } else {
                System.out.println(x + ">>>D");
            }

        }
    }
}
