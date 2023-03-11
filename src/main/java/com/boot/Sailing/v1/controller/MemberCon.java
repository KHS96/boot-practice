package com.boot.Sailing.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberCon {

    @RequestMapping("/v1/member")
    public String doMember() {

        return "/v1/member/member";
    }
}
