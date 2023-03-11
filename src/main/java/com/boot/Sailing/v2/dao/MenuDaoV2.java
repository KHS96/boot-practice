package com.boot.Sailing.v2.dao;

import com.boot.Sailing.v2.vo.Coffee_menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenuDaoV2 {
    List<Coffee_menu> doList();

    int doInsert(Coffee_menu coffee_menu);

    int doDelete(String strNo);

    // one row 조회
    Map<String, Object> doListOne(String strNo);

    // update
    int doUpdate(Coffee_menu coffee_menu);

    List<Coffee_menu> doSearch(String strStartDate, String strEndDate, String strCoffee, String strKind);

    //다중 체크박스 수정
    int doUpdatePrice(String strNo, String strPrice);

    int doInsertLog(String strNo, String strPrice);

    //update one
    int doUpdatePriceOne(List<String> chkList, String strPrice);

    //log one
    int doInsertLogOne(List<String> chkList, String strPrice);

    int doBootLog(String strClass);
}
