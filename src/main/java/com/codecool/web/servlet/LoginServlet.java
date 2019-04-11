package com.codecool.web.servlet;

import com.codecool.web.model.Account;
import com.codecool.web.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logincheck")
public class LoginServlet extends HttpServlet {
    private final AccountService service = new AccountService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.sendRedirect("index.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        for (Account acc: service.getAccountList()) {
            if(acc.getUsername().equalsIgnoreCase(username)){
                if(acc.getPassword().equalsIgnoreCase(password)){
                    resp.sendRedirect("Home.jsp");
                }
            }else{
                resp.sendRedirect("index.html");
            }

        }
    }
}
