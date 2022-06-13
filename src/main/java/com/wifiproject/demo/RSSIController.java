package com.wifilocation.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RSSIController {
    @GetMapping("/get")
    public RSSI rssi(@RequestParam(value = "pos_x", defaultValue = "0") int pos_x, @RequestParam(value = "pos_y", defaultValue = "0") int pos_y) {
        return new RSSI(pos_x, pos_y, "Test", "ff:ff:ff:ff:ff:ff", 2400, -50);
    }

//    @PostMapping("/post")

}
