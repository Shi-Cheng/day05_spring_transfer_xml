package com.dx.test;

import com.dx.domain.Account;
import com.dx.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class AccountServiceTest {

    @Autowired
    private IAccountService accountService;

    @Test
    public void findAccountAll() {
        List<Account> accounts = accountService.findAccountAll();
        for (Account account : accounts){
            System.out.println(account);
        }
    }

    @Test
    public void findAccountById() {
        Account account = accountService.findAccountById(4);
        System.out.println(account);
    }

    @Test
    public void updateAccount() {
        Account account = accountService.findAccountById(4);
        account.setName("d");
        account.setMoney(100f);
        accountService.updateAccount(account);
    }

    @Test
    public void saveAccount() {
        Account account = new Account();
        account.setMoney(50f);
        account.setName("d");
        accountService.saveAccount(account);
    }

    @Test
    public void deleteAccount() {
        accountService.deleteAccount(4);
    }

    @Test
    public void transfer() {
        accountService.transfer("a","b",100f);
    }
}