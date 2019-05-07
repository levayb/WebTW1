package com.codecool.web.servlet;

import com.codecool.web.model.Account;
import com.codecool.web.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/account")
public class AccountServlet extends HttpServlet {

    public AccountService service = AccountService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html");
        req.getRequestDispatcher("register.jsp");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean isMentor = Boolean.valueOf(req.getParameter("selection"));
        String email = req.getParameter("email");
        service.addAccount(new Account(username, password, isMentor, email));
        service.save();
        resp.sendRedirect("index.jsp");
    }

}
