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

@WebServlet("/register")
public final class AccountRegisterServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getRequestDispatcher("register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection connection = getConnection(req.getServletContext())){
            AccountDao accountDao = new DatabaseAccountDao(connection);
            AccountService accountService = new SimpleAccountService(accountDao);
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            boolean mentor = Boolean.valueOf(req.getParameter("mentor"));


            if (((DatabaseAccountDao) accountDao).accountAlreadyExists(username, email)){
                resp.sendRedirect("register");
                String info = "There is already an account with this username, or e-mail";
                req.setAttribute("info", info);
            }else{
                Account account = accountService.add(username, password, email, mentor);
                resp.sendRedirect("login");
            }
        }catch (SQLException ex){
            throw new ServletException(ex);
        }catch (ServiceException ex){
            req.setAttribute("error",ex.getMessage());
        }
    }
}
