package com.boot.Sailing.v2.controller;

import com.boot.Sailing.v2.service.MenuSvcV2;
import com.boot.Sailing.v2.service.OrderSvcV2;
import com.boot.Sailing.v2.vo.Coffee_menu;
import com.boot.Sailing.v2.vo.Order_list;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Log4j2
@RequestMapping("/v2")
public class OrderConV2 {

    @Autowired
    OrderSvcV2 orderSvcV2;

    @RequestMapping("/order")
    public String doOrder(Model model) {

        // Data 만들기, List , Map
        List<Order_list> list = orderSvcV2.doList();

        log.info("--------------------------");
        log.info(list);
        // Data 송부
        model.addAttribute("list", list);
        model.addAttribute("hello", " ============= OrderConV2==========");


        return "/v2/order/order";
    }

    @PostMapping("/order_search")
    public String doSearch(@RequestParam("start_date") String strStartDate,
                           @RequestParam("end_date") String strEndDate,
                           @RequestParam(value = "coffee", defaultValue = "ALL") String strCoffee,
                           @RequestParam("name") String strName,
                           Model model
    ) {
        log.info("strStartDate : " + strStartDate);


        List<Order_list> list = orderSvcV2.doSearch(strStartDate, strEndDate, strCoffee, strName);

        model.addAttribute("list", list);

        return "/v2/order/order";
    }

}
