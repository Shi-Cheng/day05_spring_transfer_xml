package com.dx.service;

import com.dx.domain.Account;

import java.util.List;

public interface IAccountService {
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
     * @param account
     */
    void updateAccount(Account account);

    void saveAccount(Account account);
    /**
     * 删除操作
     * @param accountId
     */
    void deleteAccount(Integer accountId);

    /**
     * 转账操作
     * @param source
     * @param target
     * @param money
     */
    void transfer(String source, String target, float money);

}
