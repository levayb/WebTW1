package com.codecool.web.dao.database;

import com.codecool.web.dao.AccountDao;
import com.codecool.web.model.Account;
import com.codecool.web.service.exception.ServiceException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class DatabaseAccountDao extends AbstractDao implements AccountDao {

    public DatabaseAccountDao(Connection connection){super(connection);}

    public List<Account> findAll() throws SQLException{
        String sql = "SELECT id, username, email, password, mentor FROM accounts";
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            List<Account> accounts = new ArrayList<>();
            while (resultSet.next()){
                accounts.add(fetchAccount(resultSet));
            }
            return accounts;
        }
    }

    public boolean accountAlreadyExists(String username, String email) throws SQLException{
        List<Account> accounts = findAll();
        boolean valid = false;
        for (Account acc:accounts) {
            if(acc.getUsername().equalsIgnoreCase(username) || acc.getEmail().equalsIgnoreCase(email)){
                valid = true;
            }
        }return valid;
    }


    @Override
    public Account findByUsername(String username) throws SQLException{
        if (username == null || "".equals(username)){
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        String sql = "Select id, username, email, password, mentor FROM accounts WHERE username = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, username);
            try(ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()){
                    return fetchAccount(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public Account add(String username, String password, String email, boolean mentor) throws SQLException{
        if (username == null || "".equals(username) || password == null || "".equals(password) ||
            email == null || "".equals(email)) {
            throw new IllegalArgumentException("Something is missing");
        }
        if(!accountAlreadyExists(username,email)){
            boolean autoCommit = connection.getAutoCommit();
            connection.setAutoCommit(false);
            String sql = "INSERT INTO accounts (username, password, email, mentor) VALUES (?, ?, ?, ?)";
            try(PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, username);
                statement.setString(2, password);
                statement.setString(3,email);
                statement.setBoolean(4, mentor);
                executeInsert(statement);
                int id = fetchGeneratedId(statement);
                return new Account(id,username,password,email,mentor);
            }catch (SQLException ex){
                connection.rollback();
                throw ex;
            } finally {
                connection.setAutoCommit(autoCommit);
            }
        }else{
            throw new IllegalArgumentException("Account already exists");
        }
    }

    @Override
    public void delete(String username) throws SQLException{
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        String sql ="DELETE FROM accounts WHERE username = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, username);
            executeInsert(statement);
        }catch (SQLException ex){
            connection.rollback();
            throw ex;
        }finally {
            connection.setAutoCommit(autoCommit);
        }
    }

    private Account fetchAccount(ResultSet resultSet)throws SQLException{
        int id = resultSet.getInt("id");
        String username = resultSet.getString("username");
        String email = resultSet.getString("email");
        String password = resultSet.getString("password");
        boolean mentor = resultSet.getBoolean("mentor");
        return new Account(id,username,password,email,mentor);
    }
}
