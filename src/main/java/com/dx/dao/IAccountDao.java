package com.dx.dao;

import com.dx.domain.Account;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAccountAll();

    /**
     * 根据id查询
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 更新操作
     * @param
     */
    void updateAccount(Account account);

    /**
     * 保存操作
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 删除操作
     * @param accountId
     */
    void deleteAccount(Integer accountId);
    /**
     * 根据用户名查询
     * @param accountName
     */
    Account findAccountByName(String accountName);
}
