package com.codecool.web.service;

import com.codecool.web.model.Assignment;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface AssignmentService {

    List<Assignment> getAssignments() throws SQLException;

    Assignment getAssignment(String name) throws SQLException, ServiceException;

    Assignment add(String name, String imgsrc, String about, String origin, String spread) throws SQLException, ServiceException;

    void delete(String name) throws SQLException, ServiceException;
}
