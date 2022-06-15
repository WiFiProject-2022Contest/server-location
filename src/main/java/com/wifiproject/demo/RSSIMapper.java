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

    @Insert("INSERT wifiinfo (pos_x, pos_y, SSID, BSSID, frequency, level, uuid) VALUES (#{pos_x}, #{pos_y}, #{SSID}, #{BSSID}, #{frequency}, #{level}, #{uuid})")
    void insert(RSSID rssid);
}
