package com.codecool.web.dao;

import com.codecool.web.model.Assignment;

import java.sql.SQLException;
import java.util.List;

public interface AssignmentDao {

    List<Assignment> findAll() throws SQLException;

    void delete(String name) throws SQLException;

    Assignment findByName(String name) throws SQLException;

    Assignment add(String name, String imgsrc, String about, String origin, String spread) throws SQLException;

}
