package com.codecool.web.model;

import java.io.Serializable;
import java.sql.*;
import java.util.Objects;

public class Account extends AbstractModel {

    public final String username;
    public final String password;
    public final String email;
    public boolean isMentor;

    public Account(int id, String username, String password, String email, boolean isMentor){
        super(id);
        this.username = username;
        this.password = password;
        this.isMentor = isMentor;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isMentor() {
        return isMentor;
    }

    public String getEmail() {
        return email;
    }

    public String getMentor(boolean isMentor){
        if(isMentor){
            return "Mentor";
        }else{
            return "Student";
        }
    }

    public void setMentor(){
        if(isMentor){
            this.isMentor = false;
        }else{
            this.isMentor = true;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Account acc = (Account) o;
        return Objects.equals(username, acc.username) &&
                Objects.equals(email, acc.email) &&
                Objects.equals(password, acc.password) &&
                Objects.equals(isMentor,acc.isMentor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), username, email, password, isMentor);
    }

    @Override
    public String toString(){
        return getUsername() + getEmail() + getMentor(isMentor);
    }
}
