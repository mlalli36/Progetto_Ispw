package com.example.progetto_ispw.cli;

import com.example.progetto_ispw.login.exception.LoginFailedException;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.signup.SignUpBean;
import com.example.progetto_ispw.signup.SignUpController;
import com.example.progetto_ispw.signup.exception.DifferentPasswordException;
import com.example.progetto_ispw.signup.exception.UserAlreadyExistsException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SignUpCLI {
    public void signUserUp() {
        while (this.setUpSignUpBean() > 0) {
            //continua ad eseguire la funzione finchè l'utente non riesce a registrarsi correttamente
        }
    }

    private int setUpSignUpBean() {
        CLIController cliController=  CLIController.getIstance();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SignUpBean bean = new SignUpBean();

        try {
            System.out.println("Enter your first name:");
            String firstName = reader.readLine();
            bean.setName(firstName);

            System.out.println("Enter your last name:");
            String lastName = reader.readLine();
            bean.setSurname(lastName);

            System.out.println("Enter your email:");
            String email = reader.readLine();
            bean.setEmail(email);

            System.out.println("Enter your password:");
            String password = reader.readLine();
            bean.setPsw(password);

            System.out.println("Confirm your password:");
            String confirmPassword = reader.readLine();
            bean.setConfirmPsw(confirmPassword);

            System.out.println("Are you a worker? (yes/no):");
            String isWorkerInput = reader.readLine();
            boolean isWorker = "yes".equalsIgnoreCase(isWorkerInput);
            bean.setWorker(isWorker);

            SignUpController controller = new SignUpController();
            controller.signUpUser(bean);

            System.out.println("Sign up successful!");
            if (isWorker) {
                System.out.println("You are registered as a worker.");
                cliController.showMyDetailsWorker(firstName,lastName,email);

            } else {
                System.out.println("You are registered as a client.");
                cliController.loadHomeScreen();
            }
            // Ritorna 0 per indicare che la registrazione è avvenuta con successo
            return 0;

        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        } catch (DifferentPasswordException e) {
            System.err.println("Passwords are not the same, check them and try again");
        } catch (LoginFailedException e) {
            System.err.println("The email is not valid");
        } catch (UserAlreadyExistsException e) {
            System.err.println("User already registered. Go to Log In!");
            /*try {
                System.out.println("Invalid choice. Please type 'yes' to go to login or 'no' to continue");
                String choice = reader.readLine();
                if ("yes".equalsIgnoreCase(choice)) {
                    // Chiamata alla funzione di accesso o al metodo per passare alla schermata di accesso
                    goToLogIn();
                } else {
                    // Continua il processo di registrazione
                    return 1;
                }

            } catch (IOException ex) {
                System.err.println("Error reading input: " + ex.getMessage());
            }*/
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
        // Ritorna un valore diverso da 0 per indicare che la registrazione non è avvenuta correttamente
        return 1;
    }
    /*private void goToLogIn() {
        // Implementa la logica per passare alla schermata di accesso o alla funzione di accesso qui
        CLIController cliController = CLIController.getIstance();
        cliController.loadHomeScreen();
    }*/

}
