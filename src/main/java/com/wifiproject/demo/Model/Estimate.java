package com.wifilocation.demo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Estimate {
    private int id;
    private float pos_x;
    private float pos_y;
    private float est_x;
    private float est_y;
    private String building;
    @JsonProperty
    private String SSID;
    private Date date;
    private String uuid;
    private int k;
    private int threshold;
    private int algorithmVersion;
    private String method;

    // NoArgs
    public Estimate() {
    }

    // AllArgs
    public Estimate(int id, float pos_x, float pos_y, float est_x, float est_y, String building, String SSID, Date date, String uuid, int k, int threshold, int algorithmVersion, String method) {
        this.id = id;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.est_x = est_x;
        this.est_y = est_y;
        this.building = building;
        this.SSID = SSID;
        this.date = date;
        this.uuid = uuid;
        this.k = k;
        this.threshold = threshold;
        this.algorithmVersion = algorithmVersion;
        this.method = method;
    }
    // partial
    public Estimate(float pos_x, float pos_y, float est_x, float est_y, String building, String SSID, String uuid, int k, int threshold, int algorithmVersion, String method) {
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.est_x = est_x;
        this.est_y = est_y;
        this.building = building;
        this.SSID = SSID;
        this.uuid = uuid;
        this.k = k;
        this.threshold = threshold;
        this.algorithmVersion = algorithmVersion;
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

    public float getEst_x() {
        return est_x;
    }

    public void setEst_x(float est_x) {
        this.est_x = est_x;
    }

    public float getEst_y() {
        return est_y;
    }

    public void setEst_y(float est_y) {
        this.est_y = est_y;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getSSID() {
        return SSID;
    }

    public void setSSID(String SSID) {
        this.SSID = SSID;
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

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public int getAlgorithmVersion() {
        return algorithmVersion;
    }

    public void setAlgorithmVersion(int algorithmVersion) {
        this.algorithmVersion = algorithmVersion;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
