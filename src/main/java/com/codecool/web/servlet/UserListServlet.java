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
import java.util.List;


@WebServlet("/userlist")
public class UserListServlet extends HttpServlet {
    private final AccountService service = AccountService.getInstance();
    private List<Account> accounts = service.getAccounts();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setAttribute("accounts", accounts);
        req.getRequestDispatcher("users.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        PrintWriter out = resp.getWriter();
        for (Account acc:accounts) {
            out.println(acc.getUsername());
            out.println(acc.getEmail());
            out.println(acc.getMentor(acc.isMentor));
        }
        doGet(req,resp);
    }
}
