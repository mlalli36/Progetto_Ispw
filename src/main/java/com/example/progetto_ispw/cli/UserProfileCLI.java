package com.example.progetto_ispw.cli;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.userprofile.UserProfileBean;
import com.example.progetto_ispw.userprofile.UserProfileController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserProfileCLI {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public void userProfile(){
        System.out.println("Welcome to the user Profile!");
        System.out.println("1. Booked service");
        System.out.println("2. Home");
        System.out.println("3. Profile");
        System.out.println("4. Exit");

        try {
            int choice = Integer.parseInt(reader.readLine());
            switch (choice) {
                case 1:
                    bookedServicesMethod();
                    break;
                case 2:
                    homeMethod();
                    break;
                case 3:
                    profileMethod();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void profileMethod() throws UserNotFoundException, IOException {
        CLIController CLIcontroller= CLIController.getIstance();
        CLIcontroller.showProfile();
    }

    private void homeMethod() {
        CLIController CLIcontroller= CLIController.getIstance();
        CLIcontroller.loadHomeScreen();
    }

    private void bookedServicesMethod() throws UserNotFoundException {
        UserEntity user=UserEntity.getInstance();
        CLIController viewController= CLIController.getIstance();

        String emailsearch= user.getEmail();
        UserProfileBean bean = new UserProfileBean();
        bean.setEmail(user.getEmail());
        UserProfileController controller =new UserProfileController();
        controller.searchInfo(bean);
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();
        viewController.showBookedServicesUser(namesearch,surnamesearch,emailsearch);
    }
}
