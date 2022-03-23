package com.fc.service.impl;

import com.fc.dao.AccountDao;
import com.fc.service.AccountService;

public class StatementServiceImpl implements AccountService {
    AccountDao accountDao;
    @Override
    public void transfer(Integer from, Integer to, Long money) {
        //扣钱
        accountDao.decreaseMoney(from,money);
        int a = 1/0;
        //加钱
        accountDao.increaseMoney(to,money);
    }
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
