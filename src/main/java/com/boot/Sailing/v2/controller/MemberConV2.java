package com.boot.Sailing.v2.controller;

import com.boot.Sailing.v2.service.MemberSvcV2;
import com.boot.Sailing.v2.vo.Cust_info;
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
public class MemberConV2 {

    @Autowired
    MemberSvcV2 memberSvcV2;

    @RequestMapping("/member")
    public String doMember(Model model) {
        // Data 만들기, List , Map
        List<Cust_info> list = memberSvcV2.doList();

        log.info("--------------------------");
        log.info(list);
        // Data 송부
        model.addAttribute("list", list);
        model.addAttribute("hello", " ============= OrderConV2==========");


        return "/v2/member/member";
    }

    @PostMapping("/member_search")
    public String doSearch(@RequestParam("start_date") String strStartDate,
                           @RequestParam("end_date") String strEndDate,
                           @RequestParam("name") String strName,
                           Model model
    ) {
        log.info("strStartDate : " + strStartDate);


        List<Cust_info> list = memberSvcV2.doSearch(strStartDate, strEndDate, strName);

        model.addAttribute("list", list);

        return "/v2/member/member";
    }
}
