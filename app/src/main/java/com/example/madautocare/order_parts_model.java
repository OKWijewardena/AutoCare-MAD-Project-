package com.example.madautocare;

public class order_parts_model {
    String Order_id,Customer_Names,Customer_Email,Item_id,Item_Names,Qun,Dates;

    public order_parts_model(String order_id, String customer_Name, String customer_Email, String item_id, String item_Name, String qun, String date) {
        Order_id = order_id;
        Customer_Names = customer_Name;
        Customer_Email = customer_Email;
        Item_id = item_id;
        Item_Names = item_Name;
        Qun = qun;
        Dates = date;
    }

    public order_parts_model(String customer_Names, String customer_Email, String qun, String dates) {
        Customer_Names = customer_Names;
        Customer_Email = customer_Email;
        Qun = qun;
        Dates = dates;
    }

    public order_parts_model(String customer_Names, String customer_Email, String item_id, String item_Names, String qun, String dates) {
        Customer_Names = customer_Names;
        Customer_Email = customer_Email;
        Item_id = item_id;
        Item_Names = item_Names;
        Qun = qun;
        Dates = dates;
    }

    public String getOrder_id() {
        return Order_id;
    }

    public void setOrder_id(String order_id) {
        Order_id = order_id;
    }

    public String getCustomer_Names() {
        return Customer_Names;
    }

    public void setCustomer_Names(String customer_Names) {
        Customer_Names = customer_Names;
    }

    public String getCustomer_Email() {
        return Customer_Email;
    }

    public void setCustomer_Email(String customer_Email) {
        Customer_Email = customer_Email;
    }

    public String getItem_id() {
        return Item_id;
    }

    public void setItem_id(String item_id) {
        Item_id = item_id;
    }

    public String getItem_Names() {
        return Item_Names;
    }

    public void setItem_Names(String item_Name) {
        Item_Names = item_Name;
    }

    public String getQun() {
        return Qun;
    }

    public void setQun(String qun) {
        Qun = qun;
    }

    public String getDates() {
        return Dates;
    }

    public void setDates(String date) {
        Dates = date;
    }
}
