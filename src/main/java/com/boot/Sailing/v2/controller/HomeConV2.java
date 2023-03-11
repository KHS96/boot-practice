package com.boot.Sailing.v2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v2")
public class HomeConV2 {


    @GetMapping("/home")
    public String doHome() {

        return "/v2/home/home";
    }
}
