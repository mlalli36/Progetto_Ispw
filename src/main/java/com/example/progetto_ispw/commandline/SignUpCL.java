package com.example.progetto_ispw.commandline;

import com.example.progetto_ispw.login.exception.LoginFailedException;
import com.example.progetto_ispw.signup.SignUpBean;
import com.example.progetto_ispw.signup.SignUpController;
import com.example.progetto_ispw.signup.exception.DifferentPasswordException;
import com.example.progetto_ispw.signup.exception.UserAlreadyExistsException;

import java.util.Scanner;

import static java.lang.System.*;
/*
public class SignUpCL {
    public void signUserUp(){
        while(this.setUpSignUpBean() >0){
            //continua a eseguire, fin quando l'utente non riesce a registrarsi nel modo corretto
        }

    }

    private int setUpSignUpBean() {
        out.println("Insert your email:");
        Scanner scanner= new Scanner(in);
        String email = scanner.nextLine();

        out.println("Insert your password:");
        String password = scanner.nextLine();

        out.println("Insert your password again:");
        String password2 = scanner.nextLine();

        out.println("Insert your name:");
        String name = scanner.nextLine();

        out.println("Insert your surname:");
        String surname = scanner.nextLine();

        out.println("Are you a worker? (y/n)");
        String worker=scanner.nextLine();
        boolean isWorker;
        isWorker= "y".equals(worker);
        SignUpBean bean= new SignUpBean();

        try{
            bean.setEmail(email);
            bean.setPsw(password);
            bean.setConfirmPsw(password2);
            bean.setName(name);
            bean.setSurname(surname);
            bean.setWorker(isWorker);
        }catch(LoginFailedException e){
            err.println(e.getMessage());
            return  1;
        }

        SignUpController ctrl= new SignUpController();
        try{
            ctrl.signUpUser(bean);
            return 0;
        }catch (UserAlreadyExistsException e){
            err.println("User already exists, restart the program and login!");
            System.exit(10);
        }catch(DifferentPasswordException e){
            err.println(e.getMessage());
            return 1;
        }
        return 0;
    }
}
*/