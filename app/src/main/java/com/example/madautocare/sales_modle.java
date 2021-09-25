package com.example.madautocare;

public class sales_modle {

    private int id;
    private String CustomerName;
    private String CustomerEmail;
    private String CustomerBillType;
    private String CustomerPhoneNumber;
    private String CustomerBillAmount;

    public sales_modle(int id, String customerName, String customerEmail, String customerBillType, String customerPhoneNumber, String customerBillAmount) {
        this.id = id;
        CustomerName = customerName;
        CustomerEmail = customerEmail;
        CustomerBillType = customerBillType;
        CustomerPhoneNumber = customerPhoneNumber;
        CustomerBillAmount = customerBillAmount;
    }

    public sales_modle(String customerName, String customerEmail, String customerBillType, String customerPhoneNumber, String customerBillAmount) {
        CustomerName = customerName;
        CustomerEmail = customerEmail;
        CustomerBillType = customerBillType;
        CustomerPhoneNumber = customerPhoneNumber;
        CustomerBillAmount = customerBillAmount;
    }

    public sales_modle(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        CustomerEmail = customerEmail;
    }

    public String getCustomerBillType() {
        return CustomerBillType;
    }

    public void setCustomerBillType(String customerBillType) {
        CustomerBillType = customerBillType;
    }

    public String getCustomerPhoneNumber() {
        return CustomerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        CustomerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerBillAmount() {
        return CustomerBillAmount;
    }

    public void setCustomerBillAmount(String customerBillAmount) {
        CustomerBillAmount = customerBillAmount;
    }
}
