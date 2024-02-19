package com.example.demo.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import com.example.demo.Model.LogUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;

public class test {

    public static void main(String[] args) {
        // 创建一个示例的 Map
        Map<String, Integer> map = new HashMap<>();
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);

        // 获取 Map 中所有键的集合
        for (String key : map.keySet()) {
            System.out.println("Key: " + key);
        }
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

        // Solution st = new Solution();
        // int bct = st.bestClosingTime("YYYYN");
        // System.out.println(bct);

        // Solution st = new Solution();
        // int [] resutl = st.ToSum(new int [] {1,2,3,7,11}, 9);

        String originalString = "{00:11,01:12}";

        // 去掉大括号
        String withoutBraces = originalString.substring(1, originalString.length() - 1);

        // 分割键值对
        String[] keyValuePairs = withoutBraces.split(",");

        // 构建新的字符串
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");

        for (String pair : keyValuePairs) {
            String[] keyValue = pair.split(":");
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();

            stringBuilder.append("\"").append(key).append("\":\"").append(value).append("\",");
        }

        // 去掉最后一个逗号
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        stringBuilder.append("}");

        String finalString = stringBuilder.toString();
        System.out.println(finalString);

        try

        {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(finalString);

            // 使用迭代器遍历键值对
            Iterator<String> fieldNames = jsonNode.fieldNames();
            while (fieldNames.hasNext()) {
                String key = fieldNames.next();
                String value = jsonNode.get(key).asText();

                System.out.println("Key: " + key + ", Value: " + value);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class Solution {

    // public int bestClosingTime(String customers) {

    // int count = 0;
    // char cts;
    // String sts = "";
    // String answer = "";
    // for (int i = 0; i < customers.length(); i++) {
    // cts = customers.charAt(i);
    // sts = String.valueOf(cts);
    // if (sts.equals("Y")) {
    // answer = "1";
    // System.out.println("answer:" + answer);
    // count += 1;
    // } else {
    // answer = "0";
    // System.out.println("answer:" + answer);
    // }

    // }
    // System.out.println("conut:" + count);
    // return count;
    // }

    public int[] ToSum(int[] nums, int target) {

        int numLength = nums.length;
        System.out.println(numLength);

        return new int[] {};
    }

    public static void main(String[] args) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String source = "2023/12/11";
        try {
            Date date = dateFormat.parse(source);
            Calendar cal = Calendar.getInstance();
            String dateString = dateFormat.format(cal.getTime());
            Date date2 = dateFormat.parse(dateString);

            System.out.println("date2: " + date2);
            System.out.println("date2: " + date2.getClass().getTypeName());
            // System.out.println("date: " + date.getClass().getTypeName());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Calendar cal = Calendar.getInstance();
        // cal.add(Calendar.DATE, -10);
        // String dateString = dateFormat.format(cal.getTime());
        // System.out.println("cal: " + cal);
    }
}

class fubon {
    public static void main(String[] args) {
        List<ArrayList<String>> tempArrayLists = new ArrayList<ArrayList<String>>();
        tempArrayLists.add(new ArrayList<String>());
        tempArrayLists.add(new ArrayList<String>());
        tempArrayLists.add(new ArrayList<String>());
        tempArrayLists.add(new ArrayList<String>());

        tempArrayLists.get(0).add("apple");
        tempArrayLists.get(0).add("iphone");
        tempArrayLists.get(1).add("banana");
        String ff001 = "134124";
        boolean isNumber = ff001.matches("^[0-9]+$");
        System.out.println("boolean isNumber: " + isNumber);
        System.out.println(tempArrayLists);
        System.out.println(tempArrayLists.get(0).get(0));
    }
}
