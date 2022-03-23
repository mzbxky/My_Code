package com.fc.service.impl;

import com.fc.dao.AccountDao;
import com.fc.service.AccountService;
import com.fc.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private LocationService locationService;
    @Override
    public void add(String name, String location) {
        accountDao.add(name);
        locationService.add(location);
    }
//    @Autowired
//    private AccountDao accountDao;
//    @Autowired
//    private LocationService locationService;
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void add(String name, String location) {
//        accountDao.add(name);
//        System.out.println("名字添加成功");
////        int a = 1/0;
//        locationService.add(location);
//        System.out.println("地址添加成功");
//    }


//    @Autowired
//    private AccountDao accountDao;
//    @Autowired
//    private LocationService locationService;
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void add(String name, String location) {
//        accountDao.add(name);
//        locationService.add(location);
//    }
//    @Autowired
//    private AccountDao accountDao;
//    @Autowired
//    private LocationService locationService;
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void add(String name, String location) {
//        accountDao.add(name);
//
//        //try {
//        locationService.add(location);
//        //} catch (Exception e) {
//        //    e.printStackTrace();
//        //}
//    }
}

