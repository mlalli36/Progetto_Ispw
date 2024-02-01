package com.example.progetto_ispw.cli;

import com.example.progetto_ispw.login.LoginBean;
import com.example.progetto_ispw.login.LoginController;
import com.example.progetto_ispw.login.exception.LoginFailedException;
import com.example.progetto_ispw.login.exception.UserNotFoundException;

import java.util.Scanner;

public class StartCLI {
    private static boolean isLogged = false;

    public static void main(String[] args) {
        while (!isLogged) {
            logUser();
        }
        CLIController cliController = CLIController.getIstance();
        cliController.loadHomeScreen();
    }

    private static void logUser() {
        System.out.println("Insert your email to login, write \"signup\" to register, or \"exit\" to exit the program.");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();

        if ("exit".equals(email))
            System.exit(0);
        if ("signup".equals(email)) {
            CLIController c = CLIController.getIstance();
            c.showSignUp();
            isLogged = true;
            return;
        }

        System.out.println("Now insert your password");
        String password = scanner.nextLine();

        LoginBean bean = new LoginBean();

        try {
            bean.setEmail(email);
            bean.setPassword(password);
        } catch (LoginFailedException | UserNotFoundException e) {
            System.err.println(e.getMessage());
            isLogged = false;
            return;
        }

        LoginController controller = new LoginController();

        try {
            controller.loginUser(bean);
            isLogged = true;
        } catch (UserNotFoundException e) {
            System.err.println("User not found, type \"signup\" to register!");
            isLogged = false;
        } catch (LoginFailedException e) {
            System.err.println(e.getMessage());
            isLogged = false;
        }
    }
}
