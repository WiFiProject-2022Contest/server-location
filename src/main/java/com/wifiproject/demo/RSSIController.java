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

    @GetMapping("/rssi")
    public List<RSSID> getAll(){
        return rssiMapper.findAll();
    }

    @PostMapping("/rssi")
    public String postMethod(@RequestParam(name = "pos_x") float pos_x, @RequestParam(name = "pos_y") float pos_y, @RequestBody List<RSSID> rssids){
        for(int i=0; i<rssids.size(); i++){
            rssids.get(i).setPos_x(pos_x);
            rssids.get(i).setPos_y(pos_y);
            rssiMapper.insert(rssids.get(i));
        }

        return "{\"success\":\"true\"}";
    }
}
