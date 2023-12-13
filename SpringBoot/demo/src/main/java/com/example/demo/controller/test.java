package com.example.demo.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.example.demo.Model.LogUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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

}
