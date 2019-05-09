package com.codecool.web.servlet;

import com.codecool.web.model.Account;
import com.codecool.web.model.Assignment;
import com.codecool.web.service.AssignmentService;
import com.codecool.web.service.CurrentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteassignment")
public class DeleteAssignmentServlet extends HttpServlet {

    public AssignmentService service = AssignmentService.getInstance();
    public CurrentService service2 = CurrentService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        service.load();
        List<Assignment> assignments = service.getAssignments();
        List<Account> curr = service2.getAccounts();
        req.setAttribute("curr",curr);
        req.setAttribute("assignments", assignments);
        req.getRequestDispatcher("assignments.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
        boolean isValid = false;
        Assignment deletable = new Assignment("","","","","","","","");
        for (Assignment a : service.getAssignments()) {
            if (a.getName().equals(req.getParameter("selection"))) {
                isValid = true;
                deletable = a;
            }
        }
        if (isValid) {
            service.getAssignments().remove(deletable);
            service.save();
        }
        service.save();
        resp.sendRedirect("assignments.jsp");
    }
}
