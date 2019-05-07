package com.codecool.web.service;

import com.codecool.web.model.Account;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class                     AccountService {

    private List<Account> accounts;
    private static AccountService ourInstance = new AccountService();

    public static AccountService getInstance() {
        return ourInstance;
    }

    private AccountService() {
        accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account acc) {
        accounts.add(acc);
    }

    public void save(){
        try{
            FileOutputStream fout = new FileOutputStream("accounts.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(accounts);
            oos.close();
            fout.close();
        }catch (Exception e){
        }
    }

    public void load(){
        try{
            FileInputStream fin = new FileInputStream("accounts.ser");
            ObjectInputStream ois = new ObjectInputStream(fin);
            accounts = (ArrayList<Account>)ois.readObject();
            ois.close();
            fin.close();
        }catch (Exception e){
        }
    }
}
