package com.boot.Sailing.v2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestHomeV2 {

    @GetMapping("v2/rest")
    public String doRest(){

        String strHtml = "<html><body> Hi rest <hr> he </body></html>";

        return strHtml;
    }
}
