package com.boot.Sailing.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
public class HomeCon {


    @GetMapping("/home")
    public String doHome() {

        return "/v1/home/home";
    }
}
