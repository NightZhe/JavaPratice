package com.example.demo.Model;

import org.springframework.stereotype.Component;

@Component

public class Product {
    private int pid;
    private String pno;
    private String pname;
    private int pprice;
    private int status;
    private String statusNC;

    public Product() {
        super();
    }

    public Product(int pid, String pno, String pname, int pprice, int status, String statusNC) {
        this.pid = pid;
        this.pno = pno;
        this.pname = pname;
        this.pprice = pprice;
        this.status = status;
        this.statusNC = statusNC;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPprice() {
        return pprice;
    }

    public void setPprice(int pprice) {
        this.pprice = pprice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusNC() {
        return statusNC;
    }

    public void setStatusNC(String statusNC) {
        this.statusNC = statusNC;
    }

}
