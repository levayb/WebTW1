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
import java.sql.*;

@WebServlet("/assignment")
public class AssignmentServlet extends HttpServlet {
    public AssignmentService service = AssignmentService.getInstance();
    public CurrentAssignmentService service2 = CurrentAssignmentService.getInstance();
    public String redirectTo;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getRequestDispatcher("add_assignment.jsp");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        service.load();
        String name = req.getParameter("name");
        String imgsrc = req.getParameter("imgsrc");
        String about_data = req.getParameter("about_data");
        String origin_data = req.getParameter("origin_data");
        String spread_data = req.getParameter("spread_data");
        boolean isValid = true;
        for (Assignment ass:service.getAssignments()) {
            if(ass.getName().equalsIgnoreCase(name)){
                isValid = false;
            }
        }
        if(isValid){
            service.addAssignment(new Assignment(imgsrc,name,"About",about_data,"Origin",origin_data,"Spread",spread_data));
            redirectTo = "assignmentinfo";
        }else{
            redirectTo = "add_assignment.jsp";
        }

        service.save();
        resp.sendRedirect(redirectTo);
    }
}
