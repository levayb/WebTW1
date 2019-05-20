package com.codecool.web.service;

import com.codecool.web.model.Account;
import com.codecool.web.model.Assignment;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class CurrentAssignmentService {
    private List<Assignment> assignments;
    private static CurrentAssignmentService ourInstance = new CurrentAssignmentService();

    public static CurrentAssignmentService getInstance() {
        return ourInstance;
    }

    private CurrentAssignmentService() {
        assignments = new ArrayList<>();
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void addAssignment(Assignment ass) {
        assignments.add(ass);
    }
}
