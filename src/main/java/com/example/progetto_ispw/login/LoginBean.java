package com.example.progetto_ispw.login;

import java.util.regex.Pattern;

public class LoginBean {
    protected String email = null;
    protected String password = null;
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", 2);


    public LoginBean() {
        // implentare
    }

    public void setEmail(String email) {
        // implentare
    }

    public void setPassword(String password) { //da implementare

    }

}