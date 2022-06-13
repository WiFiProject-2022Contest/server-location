package com.wifilocation.demo;

public class RSSID {
    private int pos_x;
    private int pos_y;
    private String SSID;
    private String BSSID;
    private int frequency;
    private int level;

    public RSSID(int pos_x, int pos_y, String SSID, String BSSID, int frequency, int level){
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.SSID = SSID;
        this.BSSID = BSSID;
        this.frequency = frequency;
        this.level = level;
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
}
