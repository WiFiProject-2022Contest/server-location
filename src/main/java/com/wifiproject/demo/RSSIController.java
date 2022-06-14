package com.wifilocation.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class RSSIController {

    @Autowired
    private RSSIMapper rssiMapper;

    @GetMapping("/example") // get all Wifi Info
    public RSSID getrssi(@RequestParam(value = "pos_x", defaultValue = "0") int pos_x, @RequestParam(value = "pos_y", defaultValue = "0") int pos_y) {
        return new RSSID(1, pos_x, pos_y, "Test", "ff:ff:ff:ff:ff:ff", 2400, -50, new Date());
    }

    @GetMapping("/get")
    public List<RSSID> getAll(){
        return rssiMapper.findAll();
    }

    @PostMapping("/test")
    public RSSID postMethod(@RequestBody RSSID rssid){
        RSSID post = new RSSID(rssid.getPos_x(), rssid.getPos_y(), rssid.getSSID(), rssid.getBSSID(), rssid.getFrequency(), rssid.getLevel());
        rssiMapper.insert(post);
        return rssid;
    }
}
