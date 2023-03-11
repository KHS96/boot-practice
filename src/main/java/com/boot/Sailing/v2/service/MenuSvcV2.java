package com.boot.Sailing.v2.service;

import com.boot.Sailing.comm.Bootlog;
import com.boot.Sailing.comm.MyExceptionRuntime;
import com.boot.Sailing.v2.dao.MenuDaoV2;
import com.boot.Sailing.v2.vo.Coffee_menu;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Log4j2
public class MenuSvcV2 {

    @Autowired
    MenuDaoV2 menuDao;
    Bootlog bootlog;
    PlatformTransactionManager transactionManager;
    TransactionDefinition definition;
    TransactionTemplate transactionTemplate;

    public MenuSvcV2() {
        log.info("=================== MenuSvc 생성자 ==============");
    }

    public List<Coffee_menu> doList() {
        List<Coffee_menu> list = menuDao.doList();

        log.info(list);
        return list;
    }

    public List<Map<String, Object>> doListOld() {

        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        map.put("No", "1");
        map.put("name", "아이스아메리카노");
        map.put("kind", "커피");
        map.put("price", "5,000");
        map.put("reg_day", "2020.10.29");
        map.put("mod_day", "2021.10.29");
        list.add(map);

        Map<String, Object> map2 = new HashMap<>();

        map2.put("No", "2");
        map2.put("name", "ㅋㅍㅊㄴ");
        map2.put("kind", "커피");
        map2.put("price", "6,000");
        map2.put("reg_day", "2020.10.29");
        map2.put("mod_day", "2021.10.29");
        list.add(map2);

        Map<String, Object> map3 = new HashMap<>();

        map3.put("No", "3");
        map3.put("name", "ㅋㅍㄾ");
        map3.put("kind", "커피");
        map3.put("price", "6,500");
        map3.put("reg_day", "2020.10.29");
        map3.put("mod_day", "2021.10.29");
        list.add(map3);

        log.info(list);
        return list;
    }

    public int doInsert(Coffee_menu coffee_menu) {
        int i = menuDao.doInsert(coffee_menu);
        return i;
    }

    public int doDelete(String strNo) {
        int i = menuDao.doDelete(strNo);
        return i;
    }

    // One row 조회
    public Map<String, Object> doListOne(String strNo) {
        Map<String, Object> map = menuDao.doListOne(strNo);

        return map;
    }

    public int doUpdate(Coffee_menu coffee_menu) {
        int i = menuDao.doUpdate(coffee_menu);

        return i;
    }

    public List<Coffee_menu> doSearch(String strStartDate, String strEndDate, String strCoffee, String strKind) {
        List<Coffee_menu> list = menuDao.doSearch(strStartDate, strEndDate, strCoffee, strKind);

        return list;
    }

    //가격 수정
    public int doUpdatePrice(String strNo, String strPrice) {
        int int1 = menuDao.doUpdatePrice(strNo, strPrice);
        return int1;
    }

    //    가격 로그 입력
    public int doInsertLog(String strNo, String strPrice) {
        int int2 = menuDao.doInsertLog(strNo, strPrice);
        return int2;
    }

    // update one
    public int doUpdatePriceOne(List<String> chkList, String strPrice) {
        int int1 = menuDao.doUpdatePriceOne(chkList, strPrice);
        return int1;
    }

    // log one
    public int doInsertLogOne(List<String> chkList, String strPrice) {
        int int2 = menuDao.doInsertLogOne(chkList, strPrice);
        return int2;
    }

    public int doUpdateInsert(List<String> chkList, String strPrice) throws RuntimeException {
        int rI = 0;

        try {

            rI = transactionTemplate.execute(status -> {
                int int1 = menuDao.doUpdatePriceOne(chkList, strPrice);
                int int2 = menuDao.doInsertLogOne(chkList, strPrice);
                return int1;
            });


            int numerator = 1;
            int denominator = 0;
            int result = numerator / denominator;
        } catch (Exception e) {
            throw new MyExceptionRuntime(e.getMessage(), getClass().getName());
        } finally {
            bootlog.doBootLog(getClass().getName());
        }

        return rI;

    }


/*
    public int doUpdateInsert(List<String> chkList, String strPrice) throws RuntimeException {
        int int1 = 0;
        try {
            TransactionStatus status = transactionManager.getTransaction(definition);

            int1 = menuDao.doUpdatePriceOne(chkList, strPrice);
            int int2 = menuDao.doInsertLogOne(chkList, strPrice);
            transactionManager.commit(status);
            int numerator = 1;
            int denominator = 0;
            int result = numerator / denominator;
        } catch (Exception e) {
            throw new MyExceptionRuntime(e.getMessage(), getClass().getName());
        }finally {
            bootlog.doBootLog(getClass().getName());
        }

        return int1;

    }
*/

/*
    //@Transactional(rollbackFor =  Exception.class)
    @Transactional(propagation = Propagation.REQUIRED)
    public int doUpdateInsert(List<String> chkList, String strPrice) throws RuntimeException {
        int int1 = 0;
        try {
            int1 = menuDao.doUpdatePriceOne(chkList, strPrice);
            int int2 = menuDao.doInsertLogOne(chkList, strPrice);
            int numerator = 1;
            int denominator = 0;
            int result = numerator / denominator;
        } catch (Exception e) {
            throw new MyExceptionRuntime(e.getMessage(), getClass().getName());
        }finally {
            bootlog.doBootLog(getClass().getName());
        }

        return int1;
                    // Checked Exception
//        File file = new File("not_existing_file.txt");
//        FileInputStream stream =
//                new FileInputStream(file);


            //Unchecked Exception -> ArithmeticException
//            int numerator = 1;
//            int denominator = 0;
//            int result = numerator / denominator;
//
//
    }

 */
}