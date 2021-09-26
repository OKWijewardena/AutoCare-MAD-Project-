package com.example.madautocare;

public class AddDbPass {
    private String code,names,price,quantity;

    public AddDbPass(){

    }

    public AddDbPass(String code, String names, String price, String quantity) {
        this.code = code;
        this.names = names;
        this.price = price;
        this.quantity = quantity;
    }

    public AddDbPass(String names, String price, String quantity) {
        this.names = names;
        this.price = price;
        this.quantity = quantity;
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

    public String Sales(){
        int price = Integer.parseInt(getPrice());
        int quantity = Integer.parseInt(getQuantity());
        int total = price*quantity;
        String total_String = String.valueOf(total);

        return total_String;
    }
}
