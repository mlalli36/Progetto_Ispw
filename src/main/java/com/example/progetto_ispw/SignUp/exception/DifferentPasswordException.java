package com.example.progetto_ispw.SignUp.exception;

public class DifferentPasswordException extends Exception{
    public DifferentPasswordException(){super("*** Passwords are different, try again ***");}
}
