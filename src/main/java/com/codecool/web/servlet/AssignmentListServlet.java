package com.codecool.web.servlet;

import com.codecool.web.model.Account;
import com.codecool.web.model.Assignment;
import com.codecool.web.service.AccountService;
import com.codecool.web.service.AssignmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/assignmentinfo")
public class AssignmentListServlet extends HttpServlet {
    private final AssignmentService service = AssignmentService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service.load();
        List<Assignment> assignments = service.getAssignments();
        req.setAttribute("assignments", assignments);
        req.getRequestDispatcher("assignments.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        doGet(req,resp);
    }
}
