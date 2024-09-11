package com.example.server;


import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private boolean isAdminLogged;
    private final String password = "admin123";

    public boolean LoginAsAdmin(String password){
        if(isAdminLogged){
            return false;
        }
        if(isAdminLogged.equals(password)){
            isAdminLogged = true;
            return true;
        }
        return false;
    }

}
