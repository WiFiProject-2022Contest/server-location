package com.wifilocation.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
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



    public RSSID(int id, float pos_x, float pos_y, String SSID, String BSSID, int frequency, int level, String building, Date date, String uuid){
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
    }
    public RSSID(){}
    public RSSID(float pos_x, float pos_y, String SSID, String BSSID, int frequency, int level, String building, String uuid){
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.SSID = SSID;
        this.BSSID = BSSID;
        this.frequency = frequency;
        this.level = level;
        this.building = building;
        this.uuid = uuid;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public float getPos_x() {
        return pos_x;
    }

    public float getPos_y() {
        return pos_y;
    }

    public String getSSID() {
        return SSID;
    }

    public String getBSSID() {
        return BSSID;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getLevel() {
        return level;
    }
    public String getBuilding() {
        return building;
    }

    public String getUuid() {
        return uuid;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setPos_x(float pos_x) {
        this.pos_x = pos_x;
    }

    public void setPos_y(float pos_y) {
        this.pos_y = pos_y;
    }

    public void setSSID(String SSID) {
        this.SSID = SSID;
    }

    public void setBSSID(String BSSID) {
        this.BSSID = BSSID;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public void setBuilding(String building) {
        this.building = building;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
