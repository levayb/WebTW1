package com.codecool.web.servlet;

import com.codecool.web.model.Account;
import com.codecool.web.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/account")
public class AccountServlet extends HttpServlet {

    public AccountService service = AccountService.getInstance();
    String redirectTo;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html");
        req.getRequestDispatcher("register.jsp");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        service.load();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean isMentor = Boolean.valueOf(req.getParameter("selection"));
        String email = req.getParameter("email");
        final PrintWriter writer = resp.getWriter();
        boolean isValid = true;
        for (Account acc:service.getAccounts()) {
            if(acc.getUsername().equalsIgnoreCase(username) || acc.getEmail().equalsIgnoreCase(email)){
                isValid = false;
            }
        }
        if(isValid){
            service.addAccount(new Account(username, password, isMentor, email));
            redirectTo = "index.jsp";
        }else{
            writer.println("Account already exists.");
            redirectTo = "register.jsp";
        }

        service.save();
        resp.sendRedirect(redirectTo);
    }

}
