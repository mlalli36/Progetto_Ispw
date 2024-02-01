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
    public void myDetailsMethod() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ProfileSignUpBean bean = new ProfileSignUpBean();

        try {
            System.out.print("Enter email: ");
            String email = reader.readLine();

            System.out.print("Enter name: ");
            String name = reader.readLine();

            System.out.print("Enter surname: ");
            String surname = reader.readLine();

            System.out.print("Enter description: ");
            String description = reader.readLine();

            System.out.print("Enter location: ");
            String location = reader.readLine();

            System.out.print("Enter address: ");
            String address = reader.readLine();

            System.out.print("Enter profession: ");
            String profession = reader.readLine();

            bean.setEmail(email);
            bean.setName(name);
            bean.setSurname(surname);
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
