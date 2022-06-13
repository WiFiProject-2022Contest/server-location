package com.wifilocation.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class RSSIController {
    @GetMapping("/example") // get all Wifi Info
    public RSSID getrssi(@RequestParam(value = "pos_x", defaultValue = "0") int pos_x, @RequestParam(value = "pos_y", defaultValue = "0") int pos_y) {
        return new RSSID(pos_x, pos_y, "Test", "ff:ff:ff:ff:ff:ff", 2400, -50);
    }

    @PostMapping("/post") // insert & update to DB
    public RSSID postRssi(@RequestBody RSSID rssi){
        return rssi;
    }

}
