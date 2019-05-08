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

@WebServlet("/delete")
public class DeleteAccountServlet extends HttpServlet {

    public AccountService service = AccountService.getInstance();
    public CurrentService service2 = CurrentService.getInstance();
    String redirectTo;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getRequestDispatcher("curriculum.jsp");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service.load();
        String username = req.getParameter("selection");
        boolean isValid = false;
        Account deletable = new Account("", "", false, "");
        for (Account a : service.getAccounts()) {
            if (a.getUsername().equalsIgnoreCase(username) && !a.getUsername().equalsIgnoreCase(service2.getAccounts().get(0).getUsername())) {
                isValid = true;
                deletable = a;
            }
        }
        if (isValid) {
            service.delete(deletable);
        }
        service.save();
        resp.sendRedirect("curriculum.jsp");
    }
}
