package com.wifilocation.demo.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Barcode {
    private int id;
    private float pos_x;
    private float pos_y;
    private String barcode_serial;
    private String building;
    private Date date;

    public Barcode() {
    }

    public Barcode(int id, float pos_x, float pos_y, String barcode_serial, String building, Date date) {
        this.id = id;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.barcode_serial = barcode_serial;
        this.building = building;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPos_x() {
        return pos_x;
    }

    public void setPos_x(float pos_x) {
        this.pos_x = pos_x;
    }

    public float getPos_y() {
        return pos_y;
    }

    public void setPos_y(float pos_y) {
        this.pos_y = pos_y;
    }

    public String getBarcode_serial() {
        return barcode_serial;
    }

    public void setBarcode_serial(String barcode_serial) {
        this.barcode_serial = barcode_serial;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
