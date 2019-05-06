package com.codecool.web.service;

import com.codecool.web.model.Account;

import java.util.ArrayList;
import java.util.List;

public class                     AccountService {

    private List<Account> accounts;
    private static AccountService ourInstance = new AccountService();

    public static AccountService getInstance() {
        return ourInstance;
    }

    private AccountService() {
        accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account acc) {
        accounts.add(acc);
    }
}
