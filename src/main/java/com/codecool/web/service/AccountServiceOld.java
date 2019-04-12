package com.codecool.web.service;

import com.codecool.web.model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceOld {

    private List<Account> accountList = new ArrayList<>();

    public void addAccount(Account acc){accountList.add(acc);}

    public List<Account> getAccountList() {
        return accountList;
    }
}
