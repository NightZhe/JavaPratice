package com.example.demo.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import com.example.demo.Model.LogUtil;

public class test {

    public static void main(String[] args) {
        // int i = 0;
        // i = (int) (Math.random() * 100000) + 1000;
        // System.out.println(i);

        // Date date = new Date();

        // DateFormat fullDateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL,
        // DateFormat.FULL);
        // System.out.println("詳細資訊" + fullDateFormat.format(date));

        // System.out.println(date.toString());

        // LogUtil.e("系統錯誤", "this is no args()");

        // String indentyid = "12,31,23";
        // String[] answer = indentyid.split(",");
        // for (int k = 0; k < answer.length; k++) {
        // System.out.println(answer[k]);
        // }

        Solution st = new Solution();
        int bct = st.bestClosingTime("YYYYN");
        System.out.println(bct);
    }

}

class Solution {

    public int bestClosingTime(String customers) {

        int count = 0;
        char cts;
        String sts = "";
        String answer = "";
        for (int i = 0; i < customers.length(); i++) {
            cts = customers.charAt(i);
            sts = String.valueOf(cts);
            if (sts.equals("Y")) {
                answer = "1";
                System.out.println(answer);
                count += 1;
            } else {
                answer = "0";
                System.out.println(answer);
            }

        }
        System.out.println("conut:" + count);
        return 0;
    }
}
