package com.wifilocation.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class RSSID {
    private int id;
    private int pos_x;
    private int pos_y;
    @JsonProperty("SSID")
    private String SSID;
    @JsonProperty("BSSID")
    private String BSSID;
    private int frequency;
    private int level;
    private Date date;

    public RSSID(int id, int pos_x, int pos_y, String SSID, String BSSID, int frequency, int level, Date date){
        this.id = id;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.SSID = SSID;
        this.BSSID = BSSID;
        this.frequency = frequency;
        this.level = level;
        this.date = date;
    }
    public RSSID(){}
    public RSSID(int pos_x, int pos_y, String SSID, String BSSID, int frequency, int level){
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.SSID = SSID;
        this.BSSID = BSSID;
        this.frequency = frequency;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getPos_x() {
        return pos_x;
    }

    public int getPos_y() {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public void setPos_y(int pos_y) {
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
}
