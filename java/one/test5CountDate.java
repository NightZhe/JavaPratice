
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class test5CountDate {
    public static void main(String[] args) throws java.text.ParseException {

        Scanner scan = new Scanner(System.in);
        System.out.println("输入日期：");
        String date = scan.nextLine();
        System.out.println("输入天数：");
        int dateNum = scan.nextInt();
        
        ComputationDate(date,dateNum);
        
    }

    public static Date ComputationDate(String date, int dateNum){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date2 = sdf.parse(date);
            Calendar cl = Calendar.getInstance();
            cl.setTime(date2);
            cl.add(Calendar.DATE, dateNum);
            String temp = "";
            temp = sdf.format(cl.getTime());
            System.out.println(temp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
        
        
    }
    
}

