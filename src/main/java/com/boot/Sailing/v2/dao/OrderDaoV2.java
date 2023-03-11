package com.boot.Sailing.v2.dao;

import com.boot.Sailing.v2.vo.Cust_info;
import com.boot.Sailing.v2.vo.Order_list;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderDaoV2 {


    List<Order_list> doList();

    List<Order_list> doSearch(String strStartDate, String strEndDate, String strCoffee, String strName);
}
