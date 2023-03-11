package com.boot.Sailing.v2.controller;

import com.boot.Sailing.v2.service.MenuSvcV2;
import com.boot.Sailing.v2.vo.Coffee_menu;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/v2")
@Log4j2
public class MenuConV2 {

    @Autowired
    MenuSvcV2 menuSvc;

    @RequestMapping("/menu")
    public String doMenu(Model model) {

        // Data 만들기, List , Map
        List<Coffee_menu> list = menuSvc.doList();

        // Data 송부
        model.addAttribute("list", list);
        model.addAttribute("hello", " ============= MenuController V2==========");


        return "/v2/menu/menu";
    }

    @GetMapping("/menu_ins")
    public String doInsert() {
        return "/v2/menu/menu_ins";
    }

    @PostMapping("/menu_ins")
    public String doInsertPost(@ModelAttribute Coffee_menu coffee_menu) {
        int i = menuSvc.doInsert(coffee_menu);

        return "redirect:/v2/menu";
    }

    @GetMapping("/menu_del")
    public String doDelete(@RequestParam("no") String strNo) {

        log.info("strno = " + strNo);
        int i = menuSvc.doDelete(strNo);

        return "redirect:/v2/menu";
    }

    @GetMapping("/menu_up")
    public String doUpdate(Model model, @RequestParam("no") String strNo) {

        Map<String, Object> map = menuSvc.doListOne(strNo);

        model.addAttribute("map", map);
        return "/v2/menu/menu_up";
    }

    @PostMapping("/menu_up")
    public String doUpdatePost(Coffee_menu coffee_menu) {
        int i = menuSvc.doUpdate(coffee_menu);

        return "redirect:/v2/menu";
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

        List<Coffee_menu> list = menuSvc.doSearch(strStartDate, strEndDate, strCoffee, strKind);

        model.addAttribute("list", list);

        return "/v2/menu/menu";
    }

    @PostMapping("/menu_updatePrice")
    public String doUpdatePrice(@RequestParam("chkCoffeeNo") List<String> chkList,
                                @RequestParam("hidden_price") String strPrice,
                                Model model
    ) {
        String strReturn = "redirect:/v2/menu";
        try {
            if (chkList != null) {
//            for (String strNo : chkList) {
//                int int1 = menuSvc.doUpdatePrice(strNo, strPrice);
//                int int2 = menuSvc.doInsertLog(strNo, strPrice);
//            }
                int int1 = menuSvc.doUpdateInsert(chkList, strPrice);
//            int int1 = menuSvc.doUpdatePriceOne(chkList, strPrice);
//            int int2 = menuSvc.doInsertLogOne(chkList, strPrice);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.addAttribute("em", e.getMessage());
            strReturn = "/v2/comm/ErrorPage";
        }

        return strReturn;
    }


}
