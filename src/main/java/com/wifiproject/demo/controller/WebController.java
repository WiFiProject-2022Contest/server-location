package com.wifilocation.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/delete")
    public String deleteWeb(){
        return "deleteForm";
    }
}
