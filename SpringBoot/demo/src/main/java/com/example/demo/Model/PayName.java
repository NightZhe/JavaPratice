package com.example.demo.Model;

public class PayName {
    private int id;
    private String payname;

    public PayName() {

    }

    public PayName(int id, String payname) {
        this.id = id;
        this.payname = payname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPayname() {
        return payname;
    }

    public void setPayname(String payname) {
        this.payname = payname;
    }

}
