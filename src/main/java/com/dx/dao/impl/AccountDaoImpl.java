package com.dx.dao.impl;

import com.dx.dao.IAccountDao;
import com.dx.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

    public List<Account> findAccountAll() {
        List<Account> accounts = super.getJdbcTemplate().query("select * from user", new BeanPropertyRowMapper<Account>(Account.class));
        for (Account account : accounts){
            System.out.println(account);
        }
        return accounts;
    }

    public Account findAccountById(Integer accountId) {
        List<Account> accounts =  super.getJdbcTemplate().query("select * from user where id=?",new BeanPropertyRowMapper<Account>(Account.class),accountId);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update user set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }

    public void saveAccount(Account account) {
        super.getJdbcTemplate().update("insert into user(name,money) value(?,?)",account.getName(),account.getMoney());
    }

    public void deleteAccount(Integer accountId) {
        super.getJdbcTemplate().update("delete from user where id=?",accountId);
    }

    public Account findAccountByName(String accountName) {
        List<Account> accounts =  super.getJdbcTemplate().query("select * from user where name=?",new BeanPropertyRowMapper<Account>(Account.class),accountName);
        if (accounts == null || accounts.size() ==0){
            return null;
        }
        if (accounts.size()>1){
            throw new RuntimeException("出现异常");
        }
        return accounts.get(0);
    }
}
