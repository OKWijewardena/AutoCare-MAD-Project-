package com.example.madautocare;

public class Order {
    private int oid;
    private String cusname;
    private String cusEmail;
    private String itemId;
    private String itemname;
    private String qun;
    private String date;

    public Order(){

    }

    public Order(int oid, String cusname, String cusEmail, String itemId, String itemname, String qun, String date) {
        this.oid = oid;
        this.cusname = cusname;
        this.cusEmail = cusEmail;
        this.itemId = itemId;
        this.itemname = itemname;
        this.qun = qun;
        this.date = date;
    }


    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getCusname() {
        return cusname;
    }

    public void setCusname(String cusname) {
        this.cusname = cusname;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getQun() {
        return qun;
    }

    public void setQun(String qun) {
        this.qun = qun;
    }

    public String getDates() {
        return date;
    }

    public void setDates(String date) {
        this.date = date;
    }
}
