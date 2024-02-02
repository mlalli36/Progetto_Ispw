package com.example.progetto_ispw.cli;

import com.example.progetto_ispw.login.exception.LoginFailedException;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.profilesignup.ProfileSignUpBean;
import com.example.progetto_ispw.profilesignup.ProfileSignUpController;
import com.example.progetto_ispw.signup.exception.UserAlreadyExistsException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyDetailsCLI {
    public void myDetailsMethod(String namesearch, String surnamesearch, String emailsearch) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ProfileSignUpBean bean = new ProfileSignUpBean();

        try {
            System.out.println("Email: "+emailsearch);
            System.out.println("Name: "+namesearch);
            System.out.println("Surname: "+surnamesearch);

            System.out.print("Enter description (or type 'q' to quit): ");
            String description = reader.readLine();

            // Check if user wants to quit
            if (description.equalsIgnoreCase("q")) {
                System.out.println("Operation canceled by user.");
                return; // Exit the method
            }

            System.out.print("Enter location (or type 'q' to quit): ");
            String location = reader.readLine();

            // Check if user wants to quit
            if (location.equalsIgnoreCase("q")) {
                System.out.println("Operation canceled by user.");
                return; // Exit the method
            }

            System.out.print("Enter address (or type 'q' to quit): ");
            String address = reader.readLine();

            // Check if user wants to quit
            if (address.equalsIgnoreCase("q")) {
                System.out.println("Operation canceled by user.");
                return; // Exit the method
            }

            System.out.print("Enter profession (or type 'q' to quit): ");
            String profession = reader.readLine();

            // Check if user wants to quit
            if (profession.equalsIgnoreCase("q")) {
                System.out.println("Operation canceled by user.");
                return; // Exit the method
            }

            bean.setEmail(emailsearch);
            bean.setName(namesearch);
            bean.setSurname(surnamesearch);
            bean.setDescription(description);
            bean.setLocation(location);
            bean.setAddress(address);
            bean.setWork(profession);

            ProfileSignUpController controller = new ProfileSignUpController();
            controller.signUpWorker(bean);

            System.out.println("Profile edits saved successfully.");
            // Aggiunta di ulteriori azioni se necessario dopo il salvataggio delle modifiche al profilo

        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
            throw e;
        } catch (IllegalArgumentException | LoginFailedException | UserAlreadyExistsException exception) {
            System.err.println("Error saving profile edits: " + exception.getMessage());
            // Aggiunta di gestione degli errori specifica se necessario
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
