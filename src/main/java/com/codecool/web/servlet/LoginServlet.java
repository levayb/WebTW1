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

@WebServlet("/login")
public final class LoginServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try (Connection connection = getConnection(req.getServletContext())) {
            AccountDao accountDao = new DatabaseAccountDao(connection);
            AccountService accountService = new SimpleAccountService(accountDao);

            String username = req.getParameter("username");
            String password = req.getParameter("password");

            Account account = accountService.loginAccount(username, password);

            req.getSession().setAttribute("account", account);
            resp.sendRedirect("protected/home.jsp");
        }catch (ServiceException ex){
            req.setAttribute("error",ex.getMessage());
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }catch (SQLException ex){
            throw new ServletException(ex);
        }
    }
}
