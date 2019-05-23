package com.codecool.web.servlet;

import com.codecool.web.dao.AccountDao;
import com.codecool.web.dao.AssignmentDao;
import com.codecool.web.dao.database.DatabaseAccountDao;
import com.codecool.web.dao.database.DatabaseAssignmentDao;
import com.codecool.web.model.Account;
import com.codecool.web.model.Assignment;
import com.codecool.web.service.AccountService;
import com.codecool.web.service.AssignmentService;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleAccountService;
import com.codecool.web.service.simple.SimpleAssignmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/protected/accountdelete")
public final class AccountDeleteServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            AccountDao accountDao = new DatabaseAccountDao(connection);
            AccountService accountService = new SimpleAccountService(accountDao);

            String username = req.getParameter("username");

            Account account = accountService.getAccount(username);
            accountService.delete(account.getUsername());
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (ServiceException ex) {
            req.setAttribute("error", ex.getMessage());
        }
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        doGet(req,resp);
        resp.sendRedirect("home.jsp");
    }
}
