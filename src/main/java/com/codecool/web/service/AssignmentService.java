package com.codecool.web.service;

import com.codecool.web.model.Account;
import com.codecool.web.model.Assignment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class AssignmentService {

    public List<Assignment> assignments;
    private static AssignmentService ourInstance = new AssignmentService();

    public static AssignmentService getInstance() {
        return ourInstance;
    }

    private AssignmentService() {
        assignments = new ArrayList<>();
    }

    public List<Assignment> getAssignments(){ return assignments; }

    public void addAssignment(Assignment a){assignments.add(a);}

    public void save() {
        try {
            FileOutputStream fout = new FileOutputStream("assignments.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(assignments);
            oos.close();
            fout.close();
        } catch (Exception e) {
        }
    }

    public void load() {
        try {
            FileInputStream fin = new FileInputStream("assignments.ser");
            ObjectInputStream ois = new ObjectInputStream(fin);
            assignments = (ArrayList<Assignment>) ois.readObject();
            ois.close();
            fin.close();
        } catch (Exception e) {
        }
    }

    public void delete(Assignment a){
        Assignment deletable = new Assignment("","","About","","Origin","","Spread","");
        for (Assignment iterated:assignments) {
            if(iterated.getName().equalsIgnoreCase(a.getName())){
                deletable.setImgsrc(a.getImgsrc());
                deletable.setName(a.getName());
                deletable.setAbout_data(a.getAbout_data());
                deletable.setOrigin_data(a.getOrigin_data());
                deletable.setSpread_data(a.getSpread_data());
            }
        }if (!deletable.getName().isEmpty()){
            assignments.remove(deletable);
        }
    }
}
