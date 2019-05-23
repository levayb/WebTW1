package com.codecool.web.dao;

import com.codecool.web.model.Account;
import java.sql.SQLException;
import java.util.List;

public interface AccountDao {

    Account findByUsername (String username) throws SQLException;

    Account add(String username, String email, String password, boolean mentor) throws SQLException;

    List<Account> findAll() throws SQLException;

    void delete(String username) throws SQLException;
}
