package com.codecool.web.servlet;

import com.codecool.web.model.Assignment;
import com.codecool.web.service.AssignmentService;
import com.codecool.web.service.CurrentAssignmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.sql.*;

@WebServlet("/loadassignment")
public class LoadAssignmentServlet extends HttpServlet {
    public AssignmentService service = AssignmentService.getInstance();
    public CurrentAssignmentService service2 = CurrentAssignmentService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        service.load();
        List<Assignment> assignments = service.getAssignments();
        req.setAttribute("assignments", assignments);
        req.getRequestDispatcher("assignments.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isValid = false;
        String name = req.getParameter("selectionn");
        Assignment readable = new Assignment("","","","","","","","");
        for (Assignment a : service.getAssignments()) {
            if (a.getName().equalsIgnoreCase(name)) {
                if(!service2.getAssignments().isEmpty()){
                    service2.getAssignments().remove(0);
                }
                isValid = true;
                readable = a;
            }
        }
        if (isValid) {
            service2.addAssignment(readable);
            service.save();
        }
        service.save();
        resp.sendRedirect("readassignment");
    }
}
