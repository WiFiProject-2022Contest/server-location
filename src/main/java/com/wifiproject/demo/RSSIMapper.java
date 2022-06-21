package com.wifilocation.demo;

import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface RSSIMapper {

    @Results({
            @Result(property = "pos_x", column = "pos_x"),
            @Result(property = "pos_y", column = "pos_y")
    })
    @Select("SELECT * FROM wifiinfo")
    List<RSSID> findAll();

    @Results({
            @Result(property = "pos_x", column = "pos_x"),
            @Result(property = "pos_y", column = "pos_y")
    })
    @Select("SELECT * FROM wifiinfo WHERE date BETWEEN #{from} AND #{to}")
    List<RSSID> findAllByDate(Date from, Date to);

    @Results({
            @Result(property = "pos_x", column = "pos_x"),
            @Result(property = "pos_y", column = "pos_y")
    })
    @Select("SELECT * FROM wifiinfo where building = #{building}")
    List<RSSID> findByBuilding(String building);

    @Results({
            @Result(property = "pos_x", column = "pos_x"),
            @Result(property = "pos_y", column = "pos_y")
    })
    @Select("SELECT * FROM wifiinfo where SSID = #{SSID}")
    List<RSSID> findBySsid(String SSID);

    @Results({
            @Result(property = "pos_x", column = "pos_x"),
            @Result(property = "pos_y", column = "pos_y")
    })
    @Select("SELECT * FROM wifiinfo where SSID = #{SSID} and building = #{building}")
    List<RSSID> findByTwo(String building, String SSID);

    @Results({
            @Result(property = "pos_x", column = "pos_x"),
            @Result(property = "pos_y", column = "pos_y")
    })
    @Select("SELECT * FROM wifiinfo WHERE pos_x BETWEEN #{pos_x} AND #{pos_x}+1 AND " +
            "pos_y BETWEEN #{pos_y} AND #{pos_y}+1 AND " +
            "date BETWEEN #{from} AND #{to}")
    List<RSSID> findByDateAndPos(int pos_x, int pos_y, Date from, Date to);

    @Results({
            @Result(property = "pos_x", column = "pos_x"),
            @Result(property = "pos_y", column = "pos_y")
    })
    @Select("SELECT * FROM wifiinfo WHERE pos_x >= #{pos_x} AND pos_x < #{pos_x} + 1 AND pos_y >= #{pos_y} AND pos_y < #{pos_y} + 1")
    List<RSSID> findPos(int pos_x, int pos_y);

    @Insert("INSERT wifiinfo (pos_x, pos_y, SSID, BSSID, frequency, level, building, uuid) VALUES (#{pos_x}, #{pos_y}, #{SSID}, #{BSSID}, #{frequency}, #{level}, #{building}, #{uuid})")
    void insert(RSSID rssid);

    @Delete("DELETE FROM wifiinfo WHERE id > 0")
    void deleteAll();

    @Update("ALTER TABLE wifiinfo AUTO_INCREMENT=1")
    void initiate();

    @Insert("INSERT fingerprint (pos_x, pos_y, uuid) VALUES (#{pos_x}, #{pos_y}, #{uuid})")
    void insertEstimate(RSSID rssid);
}
