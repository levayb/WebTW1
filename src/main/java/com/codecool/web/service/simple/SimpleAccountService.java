package com.codecool.web.service.simple;

import com.codecool.web.dao.AccountDao;
import com.codecool.web.model.Account;
import com.codecool.web.service.AccountService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class SimpleAccountService implements AccountService {

    private final AccountDao accountDao;

    public SimpleAccountService(AccountDao accountDao) {this.accountDao = accountDao;}

    @Override
    public Account loginAccount(String username, String password) throws SQLException, ServiceException{
        try{
            Account account = accountDao.findByUsername(username);
            if(account == null || !account.getPassword().equals(password)){
                throw new ServiceException("Wrong combination, or account doesn't exists.");
            }
            return account;
        }catch (IllegalArgumentException ex){
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public Account getAccount(String username) throws SQLException, ServiceException{
        try{
            Account account = accountDao.findByUsername(username);
            if(account == null){
                throw new ServiceException("Unknown account");
            }
            return account;
        }catch (IllegalArgumentException ex){
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public List<Account> getAccounts() throws SQLException, ServiceException {
        return accountDao.findAll();
    }

    @Override
    public Account add(String username, String password, String email, boolean mentor) throws SQLException, ServiceException{
        try{
            return accountDao.add(username, password, email, mentor);
        }catch (IllegalArgumentException ex){
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public void delete(String username) throws SQLException, ServiceException{
        try{
            accountDao.delete(username);
        }catch(IllegalArgumentException ex){
            throw new ServiceException(ex.getMessage());
        }
    }
}
