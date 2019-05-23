package com.codecool.web.service.simple;

import com.codecool.web.dao.AssignmentDao;
import com.codecool.web.model.Assignment;
import com.codecool.web.service.AssignmentService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class SimpleAssignmentService implements AssignmentService {

    private final AssignmentDao assignmentDao;

    public SimpleAssignmentService(AssignmentDao assignmentDao){this.assignmentDao = assignmentDao;}

    @Override
    public List<Assignment> getAssignments() throws SQLException {
        return assignmentDao.findAll();
    }

    @Override
    public Assignment getAssignment(String name) throws SQLException, ServiceException{
        try{
            Assignment assignment = assignmentDao.findByName(name);
            if(assignment == null){
                throw new ServiceException("Unknown Assignment");
            }return assignment;
        }catch(IllegalArgumentException ex){
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public Assignment add(String name, String imgsrc, String about, String origin, String spread) throws SQLException, ServiceException{
        try{
            return assignmentDao.add(name, imgsrc, about, origin, spread);
        }catch (IllegalArgumentException ex){
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public void delete(String name) throws SQLException, ServiceException{
        try{
            assignmentDao.delete(name);
        }catch(IllegalArgumentException ex){
            throw new ServiceException(ex.getMessage());
        }
    }
}
