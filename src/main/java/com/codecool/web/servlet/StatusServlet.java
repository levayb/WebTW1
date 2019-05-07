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

@WebServlet("/changestatus")
public class StatusServlet extends HttpServlet {
    public CurrentService service = CurrentService.getInstance();
    public AccountService service2 = AccountService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Account> curr = service.getAccounts();
        curr.get(0).setMentor();
        req.setAttribute("curr", curr);
        service2.save();
        req.getRequestDispatcher("profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        doGet(req,resp);
    }
}
