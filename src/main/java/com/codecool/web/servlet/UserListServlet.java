package com.codecool.web.servlet;

import com.codecool.web.model.Account;
import com.codecool.web.service.AccountService;
import com.codecool.web.service.CurrentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.sql.*;


@WebServlet("/userlist")
public class UserListServlet extends HttpServlet {
    private final AccountService service = AccountService.getInstance();
    private final CurrentService service2 = CurrentService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Account> accounts = service.getAccounts();
        List<Account> curr = service2.getAccounts();
        req.setAttribute("curr",curr);
        req.setAttribute("accounts", accounts);
        req.getRequestDispatcher("users.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        doGet(req,resp);
    }
}
