package com.example.madautocare;

public class AddDbPass {
    private String code,names,price,quantity,image;

    public AddDbPass(){

    }

    public AddDbPass(String code, String names, String price, String quantity, String image) {
        this.code = code;
        this.names = names;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }

    public AddDbPass(String names, String price, String quantity, String image) {
        this.names = names;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
