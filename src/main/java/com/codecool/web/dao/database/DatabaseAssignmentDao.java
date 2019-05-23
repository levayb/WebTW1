package com.codecool.web.dao.database;

import com.codecool.web.dao.AssignmentDao;
import com.codecool.web.model.Account;
import com.codecool.web.model.Assignment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAssignmentDao extends AbstractDao implements AssignmentDao {

    public DatabaseAssignmentDao(Connection connection){super(connection);}

    public List<Assignment> findAll() throws SQLException {
        String sql = "SELECT id, name, imgsrc, about, origin, spread FROM assignments";
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            List<Assignment> assignments = new ArrayList<>();
            while (resultSet.next()){
                assignments.add(fetchAssignment(resultSet));
            }
            return assignments;
        }
    }

    public boolean assignmentAlreadyExists(String name) throws SQLException{
        List<Assignment> assignments = findAll();
        boolean valid = false;
        for (Assignment ass:assignments) {
            if(ass.getName().equalsIgnoreCase(name)){
                valid = true;
            }
        }return valid;
    }

    @Override
    public Assignment findByName(String name) throws SQLException{
        if (name == null || "".equals(name)){
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        String sql = "Select id, name, imgsrc, about, origin, spread FROM assignments WHERE name = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, name);
            try(ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()){
                    return fetchAssignment(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public Assignment add(String name, String imgsrc, String about, String origin, String spread) throws SQLException{
        if (name == null || "".equals(name) || imgsrc == null || "".equals(imgsrc) ||
            about == null || "".equals(about) || origin == null || "".equals(origin) ||
            spread == null || "".equals(spread)) {
            throw new IllegalArgumentException("Something is missing");
        }
        if(!assignmentAlreadyExists(name)){
            boolean autoCommit = connection.getAutoCommit();
            connection.setAutoCommit(false);
            String sql = "INSERT INTO assignments (name, imgsrc, about, origin, spread) VALUES (?, ?, ?, ?, ?)";
            try(PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, name);
                statement.setString(2, imgsrc);
                statement.setString(3, about);
                statement.setString(4, origin);
                statement.setString(5, spread);
                executeInsert(statement);
                int id = fetchGeneratedId(statement);
                return new Assignment(id, name, imgsrc, about, origin, spread);
            }catch (SQLException ex){
                connection.rollback();
                throw ex;
            } finally {
                connection.setAutoCommit(autoCommit);
            }
        }else{
            throw new IllegalArgumentException("Assignment already exists");
        }
    }

    @Override
    public void delete(String name) throws SQLException{
        boolean autoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        String sql ="DELETE FROM assignments WHERE name = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, name);
            executeInsert(statement);
        }catch (SQLException ex){
            connection.rollback();
            throw ex;
        }finally {
            connection.setAutoCommit(autoCommit);
        }
    }

    private Assignment fetchAssignment(ResultSet resultSet)throws SQLException{
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String imgsrc = resultSet.getString("imgsrc");
        String about = resultSet.getString("about");
        String origin = resultSet.getString("origin");
        String spread = resultSet.getString("spread");
        return new Assignment(id, name, imgsrc, about, origin, spread);
    }
}
