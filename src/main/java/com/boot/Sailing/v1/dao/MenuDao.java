package com.boot.Sailing.v1.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenuDao {
    List<Map<String, Object>> doList();

    int doInsert(String strCoffee, String strKind, String strPrice);

    int doDelete(String strNo);

    // one row 조회
    Map<String, Object> doListOne(String strNo);

    // update
    int doUpdate(String strNo, String strCoffee, String strKind, String strPrice);

    List<Map<String, Object>> doSearch(String strStartDate, String strEndDate, String strCoffee, String strKind);

    //다중 체크박스 수정
    int doUpdatePrice(String strNo, String strPrice);

    int doInsertLog(String strNo, String strPrice);

    //update one
    int doUpdatePriceOne(List<String> chkList, String strPrice);

    //log one
    int doInsertLogOne(List<String> chkList, String strPrice);
}
