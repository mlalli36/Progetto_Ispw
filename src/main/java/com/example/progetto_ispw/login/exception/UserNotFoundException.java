package com.example.progetto_ispw.login.exception;

public class UserNotFoundException extends Exception {//compilare
    public UserNotFoundException() {
        super("The user cannot be find in the Database");
    }
}
