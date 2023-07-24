package com.example.demo.controller;

import java.text.DateFormat;
import java.util.Date;

import com.example.demo.Model.LogUtil;

public class test {

    public static void main(String[] args) {
        int i = 0;
        i = (int) (Math.random() * 100000) + 1000;
        System.out.println(i);

        Date date = new Date();

        DateFormat fullDateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);
        System.out.println("詳細資訊" + fullDateFormat.format(date));

        System.out.println(date.toString());

        LogUtil.e("系統錯誤", "this is no args()");

        String indentyid = "12,31,23";
        String[] answer = indentyid.split(",");
        for (int k = 0; k < answer.length; k++) {
            System.out.println(answer[k]);
        }
    }
}
