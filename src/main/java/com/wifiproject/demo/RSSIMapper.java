package com.wifilocation.demo;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RSSIMapper {

    @Results(id = "allResultMap", value = {
            @Result(property = "pos_x", column = "pos_x"),
            @Result(property = "pos_y", column = "pos_y")
    })
    @Select("SELECT * FROM wifiinfo")
    List<RSSID> findAll();

    @Results(id = "specificResultMap", value = {
            @Result(property = "pos_x", column = "pos_x"),
            @Result(property = "pos_y", column = "pos_y")
    })
    @Select("SELECT * FROM wifiinfo WHERE pos_x >= #{pos_x} AND pos_x < #{pos_x} + 1 AND pos_y >= #{pos_y} AND pos_y < #{pos_y} + 1")
    List<RSSID> findPos(int pos_x, int pos_y);

    @Insert("INSERT wifiinfo (pos_x, pos_y, SSID, BSSID, frequency, level, building, uuid) VALUES (#{pos_x}, #{pos_y}, #{SSID}, #{BSSID}, #{frequency}, #{level}, #{building}, #{uuid})")
    void insert(RSSID rssid);
}
