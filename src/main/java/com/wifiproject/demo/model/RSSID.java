package com.wifilocation.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class RSSID {
    private int id;
    private float pos_x;
    private float pos_y;
    @JsonProperty("SSID")
    private String SSID;
    @JsonProperty("BSSID")
    private String BSSID;
    private int frequency;
    private int level;
    private String building;
    private Date date;
    private String uuid;
    private String method;

    public RSSID() {
    }

    public RSSID(int id, float pos_x, float pos_y, String SSID, String BSSID, int frequency, int level, String building, Date date, String uuid, String method) {
        this.id = id;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.SSID = SSID;
        this.BSSID = BSSID;
        this.frequency = frequency;
        this.level = level;
        this.building = building;
        this.date = date;
        this.uuid = uuid;
        this.method = method;
    }

    public RSSID(float pos_x, float pos_y, String SSID, String BSSID, int frequency, int level, String building, String uuid, String method) {
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.SSID = SSID;
        this.BSSID = BSSID;
        this.frequency = frequency;
        this.level = level;
        this.building = building;
        this.uuid = uuid;
        this.method = method;
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

    public String getSSID() {
        return SSID;
    }

    public void setSSID(String SSID) {
        this.SSID = SSID;
    }

    public String getBSSID() {
        return BSSID;
    }

    public void setBSSID(String BSSID) {
        this.BSSID = BSSID;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
