package com.codecool.web.model;

public class Account {

    private final String username;
    private final String password;
    private final boolean isMentor;
    private final String email;

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
}
