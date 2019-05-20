package com.codecool.web.service;

import com.codecool.web.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class CurrentService {
    private List<Account> accounts;
    private static CurrentService ourInstance = new CurrentService();

    public static CurrentService getInstance() {
        return ourInstance;
    }

    private CurrentService() {
        accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account acc) {
        accounts.add(acc);
    }
}
