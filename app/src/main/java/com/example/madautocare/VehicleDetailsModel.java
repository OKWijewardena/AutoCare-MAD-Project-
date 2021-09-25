package com.example.madautocare;

public class VehicleDetailsModel {
    private int id,km;
    private String vehicleType,username,email,date;

    public VehicleDetailsModel(int id, int km, String vehicleType, String username, String email, String date) {
        this.id = id;
        this.km = km;
        this.vehicleType = vehicleType;

        this.username = username;
        this.email = email;
        this.date = date;
    }

    public VehicleDetailsModel(int km, String vehicleType, String username, String email, String date) {
        this.km = km;
        this.vehicleType = vehicleType;

        this.username = username;
        this.email = email;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }





    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
