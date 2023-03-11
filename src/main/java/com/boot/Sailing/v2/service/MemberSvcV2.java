package com.boot.Sailing.v2.service;

import com.boot.Sailing.v2.dao.MemberDaoV2;
import com.boot.Sailing.v2.vo.Cust_info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberSvcV2 {

    @Autowired
    MemberDaoV2 memberDaoV2;

    public List<Cust_info> doList() {
        List<Cust_info> list = memberDaoV2.doList();

        return list;
    }

    public List<Cust_info> doSearch(String strStartDate, String strEndDate, String strName) {
        List<Cust_info> list = memberDaoV2.doSearch(strStartDate, strEndDate, strName);

        return list;
    }
}
