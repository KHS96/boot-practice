package com.boot.Sailing.v2.service;

import com.boot.Sailing.v2.dao.OrderDaoV2;
import com.boot.Sailing.v2.vo.Coffee_menu;
import com.boot.Sailing.v2.vo.Order_list;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderSvcV2 {

    @Autowired
    OrderDaoV2 orderDaoV2;


    public List<Order_list> doList() {
        List<Order_list> list = orderDaoV2.doList();

        return list;
    }

    //    조회하기
    public List<Order_list> doSearch(String strStartDate, String strEndDate, String strCoffee, String strName) {
        List<Order_list> list = orderDaoV2.doSearch(strStartDate, strEndDate, strCoffee, strName);

        return list;
    }
}
