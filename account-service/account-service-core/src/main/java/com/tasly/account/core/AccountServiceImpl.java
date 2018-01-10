package com.tasly.account.core;

import com.tasly.account.api.AccountService;
import com.tasly.account.db.domain.Account;
import com.tasly.account.db.domain.AccountReposity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by dulei on 18/1/10.
 */
@RestController
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountReposity accountReposity;

    @Override
    public BigDecimal remainTotalMoney(@PathVariable("uid") Long uid) {
        Account account = new Account();
        account.setTotalMoney(new BigDecimal("12.9"));
        account.setUid(uid);
        return accountReposity.save(account).getTotalMoney();
    }
}
