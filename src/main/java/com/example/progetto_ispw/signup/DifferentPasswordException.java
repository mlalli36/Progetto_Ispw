package com.example.progetto_ispw.signup;

public class DifferentPasswordException extends Exception{
    public DifferentPasswordException(){super("*** Passwords are different, try again ***");}
}
