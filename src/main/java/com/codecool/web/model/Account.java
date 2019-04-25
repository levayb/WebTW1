package com.codecool.web.model;

public class Account {

    public final String username;
    public final String password;
    public final boolean isMentor;
    public final String email;

    public Account(String username, String password, boolean isMentor, String email){
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

    @Override
    public String toString(){
        return getUsername() + getEmail() + getMentor(isMentor);
    }
}
