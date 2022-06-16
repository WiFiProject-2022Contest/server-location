package com.wifilocation.demo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface RSSIMapper {

    @Select("SELECT * FROM wifiinfo")
    List<RSSID> findAll();

    @Select("SELECT * FROM wifiinfo WHERE pos_x >= #{pos_x} AND pos_x < #{pos_x} + 1 AND pos_y >= #{pos_y} AND pos_y < #{pos_y} + 1")
    List<RSSID> findPos(int pos_x, int pos_y);

    @Insert("INSERT wifiinfo (pos_x, pos_y, SSID, BSSID, frequency, level, building, uuid) VALUES (#{pos_x}, #{pos_y}, #{SSID}, #{BSSID}, #{frequency}, #{level}, #{building}, #{uuid})")
    void insert(RSSID rssid);
}
