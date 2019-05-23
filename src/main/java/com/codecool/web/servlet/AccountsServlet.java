package com.codecool.web.servlet;

import com.codecool.web.dao.AccountDao;
import com.codecool.web.dao.database.DatabaseAccountDao;
import com.codecool.web.model.Account;
import com.codecool.web.service.AccountService;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleAccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/protected/accounts")
public final class AccountsServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try(Connection connection = getConnection(req.getServletContext())){
            AccountDao accountDao = new DatabaseAccountDao(connection);
            AccountService accountService = new SimpleAccountService(accountDao);
            List<Account> accounts = accountService.getAccounts();
            req.setAttribute("accounts",accounts);
            req.getRequestDispatcher("accounts.jsp").forward(req,resp);
        }catch (SQLException ex){
            throw new ServletException(ex);
        }catch (ServiceException ex){
            req.setAttribute("error",ex.getMessage());
        }
    }
}
