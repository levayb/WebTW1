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
import java.sql.*;

@WebServlet("/logincheck")
public class LoginServlet extends HttpServlet {
    public AccountService service = AccountService.getInstance();
    public CurrentService service2 = CurrentService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        service.load();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String redirectTo;
        boolean Mentor = false;
        boolean isValid = false;
        for (Account acc: service.getAccounts()) {
            if (acc.getUsername().equals(username) && acc.getPassword().equals(password)) {
                isValid = true;
                service2.addAccount(acc);
            }
        }
        if(isValid){
            if(service2.getAccounts().get(0).isMentor){
                redirectTo = "home";
            }else{
                redirectTo = "home";
            }
        }else{
            req.setAttribute("error","Bad login");
            redirectTo = "index.jsp";
        }
        resp.sendRedirect(redirectTo);
    }
}
