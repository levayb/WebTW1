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


@WebServlet("/currentuser")
public class CurrentServlet extends HttpServlet {
    public CurrentService service = CurrentService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Account> curr = service.getAccounts();
        req.setAttribute("curr", curr);
        req.getRequestDispatcher("profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        doGet(req,resp);
    }
}
