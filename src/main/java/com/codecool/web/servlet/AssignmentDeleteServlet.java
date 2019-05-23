package com.codecool.web.servlet;

import com.codecool.web.dao.AssignmentDao;
import com.codecool.web.dao.database.DatabaseAssignmentDao;
import com.codecool.web.model.Assignment;
import com.codecool.web.service.AssignmentService;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleAssignmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/protected/assignmentdelete")
public final class AssignmentDeleteServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            AssignmentDao assignmentDao = new DatabaseAssignmentDao(connection);
            AssignmentService assignmentService = new SimpleAssignmentService(assignmentDao);

            String name = req.getParameter("name");

            Assignment assignment = assignmentService.getAssignment(name);
            assignmentService.delete(assignment.getName());
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
