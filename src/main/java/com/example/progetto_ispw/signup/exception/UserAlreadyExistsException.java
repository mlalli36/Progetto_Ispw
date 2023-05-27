package com.example.progetto_ispw.signup.exception;

public class UserAlreadyExistsException extends Exception{
    public UserAlreadyExistsException(){super("*** User already registered ***");}
}
