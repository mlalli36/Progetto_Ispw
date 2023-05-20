package com.example.progetto_ispw.login.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String user_not_found) {
        super("The user cannot be find in the Database");
    }

}
