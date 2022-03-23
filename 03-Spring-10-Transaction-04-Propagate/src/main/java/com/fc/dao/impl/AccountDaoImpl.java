package com.fc.dao.impl;

import com.fc.dao.AccountDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    @Override
    public void add(String name) {
        getJdbcTemplate().update("insert into bank(name) values(?)",name);
    }
//    @Override
//    public void add(String name) {
//        getJdbcTemplate().update("insert into bank(name) values (?)",name);
//    }
//    @Override
//    public void add(String name) {
////        getJdbcTemplate().update("insert into bank(name) values (?)", name);
//        getJdbcTemplate().update("insert into bank(name) values(?)",name);
//    }
}

