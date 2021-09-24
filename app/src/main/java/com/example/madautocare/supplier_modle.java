package com.example.madautocare;

public class supplier_modle {

    private int id;
    private String Suppliers_Name;
    private String Suppliers_Email;
    private String Suppliers_Password;
    private String Suppliers_Phone_Number;

    public supplier_modle(int id, String suppliers_Name, String suppliers_Email, String suppliers_Password, String suppliers_Phone_Number) {
        this.id = id;
        Suppliers_Name = suppliers_Name;
        Suppliers_Email = suppliers_Email;
        Suppliers_Password = suppliers_Password;
        Suppliers_Phone_Number = suppliers_Phone_Number;
    }

    public supplier_modle(String suppliers_Name, String suppliers_Email, String suppliers_Password, String suppliers_Phone_Number) {
        Suppliers_Name = suppliers_Name;
        Suppliers_Email = suppliers_Email;
        Suppliers_Password = suppliers_Password;
        Suppliers_Phone_Number = suppliers_Phone_Number;
    }

    public supplier_modle() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSuppliers_Name() {
        return Suppliers_Name;
    }

    public void setSuppliers_Name(String suppliers_Name) {
        Suppliers_Name = suppliers_Name;
    }

    public String getSuppliers_Email() {
        return Suppliers_Email;
    }

    public void setSuppliers_Email(String suppliers_Email) {
        Suppliers_Email = suppliers_Email;
    }

    public String getSuppliers_Password() {
        return Suppliers_Password;
    }

    public void setSuppliers_Password(String suppliers_Password) {
        Suppliers_Password = suppliers_Password;
    }

    public String getSuppliers_Phone_Number() {
        return Suppliers_Phone_Number;
    }

    public void setSuppliers_Phone_Number(String suppliers_Phone_Number) {
        Suppliers_Phone_Number = suppliers_Phone_Number;
    }
}

