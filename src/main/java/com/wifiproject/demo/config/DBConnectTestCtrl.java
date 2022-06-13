package com.wifilocation.demo.config;

import com.wifilocation.demo.TestDAO;
import com.wifilocation.demo.RSSID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DBConnectTestCtrl {
    @Autowired
    private TestDAO testDAO;

    @GetMapping("/hello")
    public List<RSSID> HelloWorld(){
        return testDAO.getTestData();
    }
}
