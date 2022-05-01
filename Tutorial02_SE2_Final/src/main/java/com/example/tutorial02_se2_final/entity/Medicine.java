package com.example.tutorial02_se2_final.entity;

public class Medicine {
    private int medicine_id;
    private String medicine_brand;
    private String medicine_name;
    private int medicine_price;

    public Medicine(int medicine_id, String medicine_brand, String medicine_name, int medicine_price) {
        this.medicine_id = medicine_id;
        this.medicine_brand = medicine_brand;
        this.medicine_name = medicine_name;
        this.medicine_price = medicine_price;
    }

    public int getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_id(int medicine_id) {
        this.medicine_id = medicine_id;
    }

    public String getMedicine_brand() {
        return medicine_brand;
    }

    public void setMedicine_brand(String medicine_brand) {
        this.medicine_brand = medicine_brand;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public int getMedicine_price() {
        return medicine_price;
    }

    public void setMedicine_price(int medicine_price) {
        this.medicine_price = medicine_price;
    }
}

