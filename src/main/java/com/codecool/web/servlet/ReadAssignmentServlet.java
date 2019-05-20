package com.codecool.web.servlet;

import com.codecool.web.model.Account;
import com.codecool.web.model.Assignment;
import com.codecool.web.service.CurrentAssignmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.sql.*;

@WebServlet("/readassignment")
public class ReadAssignmentServlet extends HttpServlet {

    public CurrentAssignmentService service = CurrentAssignmentService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        List<Assignment> curr = service.getAssignments();
        req.setAttribute("curr", curr);
        req.getRequestDispatcher("curriculum.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        doGet(req,resp);
    }
}
