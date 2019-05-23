package com.codecool.web.service;

import com.codecool.web.model.Account;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface AccountService {

    Account loginAccount(String username, String password) throws SQLException, ServiceException;

    Account add(String username, String password, String email, boolean mentor) throws SQLException, ServiceException;

    List<Account> getAccounts() throws SQLException, ServiceException;

    Account getAccount(String username) throws SQLException, ServiceException;

    void delete(String username) throws SQLException, ServiceException;
}
