package com.codecool.web.servlet;

import com.codecool.web.model.Account;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/account")
public final class AccountChangeServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account account = (Account) req.getSession().getAttribute("account");
        if(account.isMentor){
            account.isMentor = false;
        }else{
            account.isMentor = true;
        }
        req.setAttribute("account", account);
        req.getRequestDispatcher("account.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException{
        doGet(req,resp);
    }
}


