package com.wifilocation.demo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Estimate {
    private int id;
    private float pos_x;
    private float pos_y;
    private Date date;
    private String uuid;

    public Estimate() {
    }

    public Estimate(int id, float pos_x, float pos_y, Date date, String uuid) {
        this.id = id;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.date = date;
        this.uuid = uuid;
    }

    public Estimate(float pos_x, float pos_y, String uuid) {
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.uuid = uuid;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
