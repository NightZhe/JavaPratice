package com.example.demo.Model;

import org.springframework.data.relational.core.mapping.Embedded.Nullable;

import org.springframework.stereotype.Component;

@Component
public class Student {
    @Nullable
    private int id;
    private String sno;
    private String sname;
    private int sage;
    private String password;
    private String email;
    private int payid;
    private String payName;
    private String status;
    private int pageNum;
    private int pageSize = 100000;

    public Student() {

    }

    public Student(String sname) {
        this.sname = sname;
    }

    public Student(String sname, String password, String email) {

        this.sname = sname;
        this.password = password;
        this.email = email;
    }

    public Student(int id, String sname, String password, String email) {
        this.id = id;
        this.sname = sname;
        this.password = password;
        this.email = email;
    }

    public Student(String sname, String password) {
        this.sname = sname;
        this.password = password;
    }

    public Student(String sno, String sname, int sage, String passwrod, String email) {
        this.sno = sno;
        this.sname = sname;
        this.sage = sage;
        this.password = passwrod;
        this.email = email;
    }

    public Student(int id, String sno, String sname, int sage, String password, String email) {
        this.id = id;
        this.sno = sno;
        this.sname = sname;
        this.sage = sage;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // getter and setter methods
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPayid() {
        return payid;
    }

    public void setPayid(int payid) {
        this.payid = payid;
    }

    @Override
    public String toString() {
        return "Student{" + "sno='" + sno + '\'' + ", sname='" + sname + '\'' + ", sage=" + sage + '}' + "\n";
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
