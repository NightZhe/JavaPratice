package com.example.demo.controller;

public class test {

    public static void main(String[] args) {
        int i = 0;
        i = (int) (Math.random() * 100000) + 1000;
        System.out.println(i);

        StringBuffer sql = new StringBuffer();
        sql.append("select * from user ");
        sql.append(" where name = 'aaa' ");

        System.out.println(sql);

    }
}
