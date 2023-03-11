package com.boot.Sailing.v1.controller;

import com.boot.Sailing.v1.service.MenuSvc;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@RequestMapping("/v1")
@Log4j2
public class MenuCon {

    @Autowired
    MenuSvc menuSvc;

    @RequestMapping("/menu")
    public String doMenu(Model model) {

        // Data 만들기, List , Map
        List<Map<String, Object>> list = menuSvc.doList();

        // Data 송부
        model.addAttribute("list", list);
        //model.addAttribute("hello", " ============= MenuController ==========");


        return "/v1/menu/menu";
    }

    @GetMapping("/menu_ins")
    public String doInsert() {
        return "/v1/menu/menu_ins";
    }

    @PostMapping("/menu_ins")
    public String doInsertPost(@RequestParam("coffee") String strCoffee,
                               @RequestParam("kind") String strKind,
                               @RequestParam("price") String strPrice
    ) {
        int i = menuSvc.doInsert(strCoffee, strKind, strPrice);

        return "redirect:/v1/menu";
    }

    @GetMapping("/menu_del")
    public String doDelete(@RequestParam("no") String strNo) {

        log.info("strno = " + strNo);
        int i = menuSvc.doDelete(strNo);

        return "redirect:/v1/menu";
    }

    @GetMapping("/menu_up")
    public String doUpdate(Model model, @RequestParam("no") String strNo) {

        Map<String, Object> map = menuSvc.doListOne(strNo);

        model.addAttribute("map", map);
        return "/v1/menu/menu_up";
    }

    @PostMapping("/menu_up")
    public String doUpdatePost(@RequestParam("no") String strNo,
                               @RequestParam("coffee") String strCoffee,
                               @RequestParam("kind") String strKind,
                               @RequestParam("price") String strPrice
    ) {
        int i = menuSvc.doUpdate(strNo, strCoffee, strKind, strPrice);

        return "redirect:/v1/menu";
    }

    @PostMapping("/menu_search")
    public String doSearch(@RequestParam("start_date") String strStartDate,
                           @RequestParam("end_date") String strEndDate,
                           @RequestParam(value = "coffee", defaultValue = "ALL") String strCoffee,
                           @RequestParam("kind") String strKind,
                           Model model
    ) {
        log.info("strStartDate : " + strStartDate);
        log.info(strEndDate + " " + strKind);

        List<Map<String, Object>> list = menuSvc.doSearch(strStartDate, strEndDate, strCoffee, strKind);

        model.addAttribute("list", list);

        return "/v1/menu/menu";
    }

    @PostMapping("/menu_updatePrice")
    public String doUpdatePrice(@RequestParam("chkCoffeeNo") List<String> chkList,
                                @RequestParam("hidden_price") String strPrice
    ) {
        if (chkList != null) {
//            for (String strNo : chkList) {
//                int int1 = menuSvc.doUpdatePrice(strNo, strPrice);
//                int int2 = menuSvc.doInsertLog(strNo, strPrice);
//            }
            int int1 = menuSvc.doUpdatePriceOne(chkList, strPrice);
            int int2 = menuSvc.doInsertLogOne(chkList, strPrice);
        }

        return "redirect:/v1/menu";
    }


}
