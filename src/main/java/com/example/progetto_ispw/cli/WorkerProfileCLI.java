package com.example.progetto_ispw.cli;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.notifications.NotificationsBean;
import com.example.progetto_ispw.notifications.NotificationsController;
import com.example.progetto_ispw.savehoursslots.SaveHoursBean;
import com.example.progetto_ispw.savehoursslots.SaveHoursController;
import com.example.progetto_ispw.savehoursslots.SlotHours;
import com.example.progetto_ispw.savehoursslots.SlotHoursEntity;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.userprofile.UserProfileBean;
import com.example.progetto_ispw.userprofile.UserProfileController;
import com.example.progetto_ispw.workerprofile.WorkerProfileBean;
import com.example.progetto_ispw.workerprofile.WorkerProfileController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WorkerProfileCLI {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public void workerProfile() {
            System.out.println("Welcome to worker Profile!");
            System.out.println("1. Booked service");
            System.out.println("2. change Of Working Hours");
            System.out.println("3. Notifications");
            System.out.println("4. my Details ");
            System.out.println("5. Home ");
            System.out.println("6. Profile ");
            System.out.println("7. Exit ");


            try {
                int choice = Integer.parseInt(reader.readLine());
                switch (choice) {
                    case 1:
                        bookedServicesMethod();
                        break;
                    case 2:
                        changeOfWorkingHoursMethod();
                        break;
                    case 3:
                        notificationMethod();
                        break;

                    case 4:
                        myDetailsMethod();
                        break;
                    case 5:
                        homeMethod();
                        break;
                    case 6:
                        profileMethod();
                        break;
                    case 7:
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
        CLIController viewController = CLIController.getIstance();
        viewController.loadHomeScreen();
    }

    private void myDetailsMethod() throws UserNotFoundException, IOException {
        NotificationsBean bean=new NotificationsBean();
        UserEntity user = UserEntity.getInstance();
        NotificationsController controller= new NotificationsController();
        CLIController viewController = CLIController.getIstance();//è singletone

        String emailsearch= user.getEmail();

        bean.setEmail(emailsearch);
        controller.searchInfo(bean);
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();

        viewController.showMyDetailsWorker(namesearch,surnamesearch,emailsearch);


    }

    private void notificationMethod() throws UserNotFoundException {
        UserEntity user=UserEntity.getInstance();
        CLIController viewController= CLIController.getIstance();

        String emailsearch= user.getEmail();
        SaveHoursBean bean = new SaveHoursBean();
        bean.setEmail(user.getEmail());
        SaveHoursController controller =new SaveHoursController();
        controller.searchInfo(bean);
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();

        viewController.showNotifications(namesearch,surnamesearch,emailsearch);


    }

    private void changeOfWorkingHoursMethod() throws UserNotFoundException {
        UserEntity user = UserEntity.getInstance();
        CLIController viewController = CLIController.getIstance();//è singletone
        //aggiungo da qui
        SlotHoursEntity slotHoursEntity= SlotHoursEntity.getInstance();
        SlotHours slotHours= new SlotHours();
        slotHoursEntity.setSlotHours(slotHours);
        //
        String emailsearch= user.getEmail();
        WorkerProfileBean wPB=new WorkerProfileBean();
        wPB.setEmail(emailsearch);
        WorkerProfileController wPC=new WorkerProfileController();
        wPC.searchInfo(wPB);
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();




        viewController.showSlotHours(namesearch,surnamesearch,emailsearch);


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
        viewController.showBookedServicesWorker(namesearch,surnamesearch,emailsearch);

    }

}
