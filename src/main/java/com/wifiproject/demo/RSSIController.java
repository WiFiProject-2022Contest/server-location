package com.wifilocation.demo;

import com.wifilocation.demo.Model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
public class RSSIController {

    @Autowired
    private RSSIMapper rssiMapper;

    @GetMapping("/rssi/all")
    public List<RSSID> getAll(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tSuccessfully GET All Data");
        return rssiMapper.findAll();
    }

    @GetMapping("/rssi")
    public List<RSSID> getPos(@RequestParam(name = "pos_x") float pos_x, @RequestParam(name = "pos_y") float pos_y){
        LocalDateTime now = LocalDateTime.now();

        if(pos_x == -1 && pos_y == -1){
            System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tSuccessfully GET All Data");
            return rssiMapper.findAll();
        }
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tSuccessfully GET data for (" + pos_x + ", " + pos_y + ")");
        return rssiMapper.findPos((int)pos_x, (int)pos_y);
    }

    @PostMapping("/rssi")
    public Result postMethod(@RequestParam(name = "pos_x") float pos_x, @RequestParam(name = "pos_y") float pos_y, @RequestBody List<RSSID> rssids){
        for(int i=0; i<rssids.size(); i++){
            rssids.get(i).setPos_x(pos_x);
            rssids.get(i).setPos_y(pos_y);
            rssiMapper.insert(rssids.get(i));
        }
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tSuccessfully POST " + rssids.size() + " data");

        Result result = new Result(true);
        return result;
    }
}
