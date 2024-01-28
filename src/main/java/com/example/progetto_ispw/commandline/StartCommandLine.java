package com.example.progetto_ispw.commandline;

import com.example.progetto_ispw.login.LoginBean;
import com.example.progetto_ispw.login.LoginController;
import com.example.progetto_ispw.login.exception.LoginFailedException;
import com.example.progetto_ispw.login.exception.UserNotFoundException;

import java.util.Scanner;

import static java.lang.System.*;
/*
public class StartCommandLine {
    private static boolean isLogged =false;
    public static void main (String[] args ){
        while(!isLogged){
            //finché non trova un valore negativo, continua ad eseguire il metodo per il login

        }
        CLController cmController = CLController.getInstance();
     //   cmController.loadHomeScreen();
    }
    static void logUser(){
        out.println("Insert your email to loing, write \"signup\" to register, or \"exit\" to exit program.");
        Scanner scanner = new Scanner(in);
        String email = scanner.nextLine();

        if("exit".equals(email)){
            System.exit(0); // Esco dal programma su richiesta dell'utente
        }if ("signup".equals(email)){
            CLController c= CLController.getInstance();
            c.showSignUp();
            isLogged= true;
            return;
        }
        out.println("Now insert your password");
        String password = scanner.nextLine();
        LoginBean bean= new LoginBean();
        try{
            bean.setEmail(email);
        }catch(LoginFailedException e){
            err.println(e.getMessage());
            isLogged=false;
            return;
        }
        bean.setPassword(password);
        LoginController ctrl = new LoginController();
        try{
            ctrl.loginUser(bean);
            isLogged=true;
        }catch(UserNotFoundException e){
            err.println("User not found, typo \"signup\" to register!");
            isLogged=false;
        }catch (LoginFailedException e ){
            err.println(e.getMessage());
            isLogged=false;
        }
    }
}
*/