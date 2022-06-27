package com.wifilocation.demo;

import com.wifilocation.demo.Model.Estimate;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Mapper
public interface RSSIMapper {

    // wifiinfo
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
    // building과 SSID가 일치하는 Row

    @Results({
            @Result(property = "pos_x", column = "pos_x"),
            @Result(property = "pos_y", column = "pos_y")
    })
    @Select("SELECT * FROM wifiinfo WHERE pos_x BETWEEN #{pos_x} AND #{pos_x}+1 AND " +
            "pos_y BETWEEN #{pos_y} AND #{pos_y}+1 AND " +
            "date BETWEEN #{from} AND #{to}")
    List<RSSID> findByDateAndPos(int pos_x, int pos_y, Date from, Date to);
    // Date 범위와 좌표에 따른 검색

    List<RSSID> findDynamic(int pos_x, int pos_y, String building, String SSID, Date from, Date to);


    List<RSSID> findByDateAndBuild(String building, String SSID, Date from, Date to);

    // Date 범위와 building, SSID에 따른 검색

    @Insert("INSERT wifiinfo (pos_x, pos_y, SSID, BSSID, frequency, level, building, uuid) " +
            "VALUES (#{pos_x}, #{pos_y}, #{SSID}, #{BSSID}, #{frequency}, #{level}, #{building}, #{uuid})")
    void insert(RSSID rssid);
    void deleteDynamic(String building, String SSID, String uuid, Date from, Date to);

    // Fingerprint

    @Results({
            @Result(property = "pos_x", column = "pos_x"),
            @Result(property = "pos_y", column = "pos_y"),
            @Result(property = "est_x", column = "est_x"),
            @Result(property = "est_y", column = "est_y")
    })
    @Select("SELECT * FROM fingerprint WHERE date BETWEEN #{from} AND #{to}")
    List<Estimate> findEstimateByDate(Date from, Date to);

    @Insert("INSERT fingerprint (pos_x, pos_y, uuid, est_x, est_y, k, threshold, building, SSID, method, algorithmVersion) " +
            "VALUES (#{pos_x}, #{pos_y}, #{uuid}, #{est_x}, #{est_y}, #{k}, #{threshold}, #{building}, #{SSID}, #{method}, #{algorithmVersion})")
    void insertEstimate(Estimate est);
}
