package com.example.progetto_ispw.cli;

import com.example.progetto_ispw.bookedServicesWorker.BookedServicesWorkerBean;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.notifications.NotificationsBean;
import com.example.progetto_ispw.notifications.NotificationsController;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.workerprofile.AppointmentResultElement;
import com.example.progetto_ispw.workerprofile.AppointmentResultEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class NotificationCLI {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void notificationMethod() {
        try {

            UserEntity uE = UserEntity.getInstance();
            String email = uE.getEmail();

            NotificationsBean bean = new NotificationsBean();
            bean.setEmail(email);

            NotificationsController ctrl = new NotificationsController();
            ctrl.verifica(bean);

            AppointmentResultEntity appointmentResultEntity = bean.getAppointmentResultSet();
            if (appointmentResultEntity == null) {
                System.out.println("No appointment results found.");
                return; // Uscire dal metodo se l'entità è null
            }

            List<AppointmentResultElement> elements = appointmentResultEntity.getElements();

            if (elements.isEmpty()) {
                System.out.println("No appointments found.");
            } else {
                int index = 1;
                for (AppointmentResultElement a : elements) {
                    System.out.println(index);
                    System.out.println("Client: " + a.getCName() + " " + a.getCSurname());
                    System.out.println("Email: " + a.getCEmail());
                    System.out.println("Description of work: " + a.getdescriptionWork());
                    System.out.println("Time: " + a.getTime());
                    System.out.println("Date: " + a.getDAppo());
                    System.out.println("Worker email: " + a.getWEmail());
                    System.out.println();
                    index++;
                }

                // Ask user to select an appointment
                System.out.println("Enter the number associated with the appointment you want to manage, or press 'q' to quit:");
                String input = reader.readLine();

                if (input.equals("q")) {
                    // User chose to quit
                    return; // Exit the method
                }

                int selectedNumber;
                try {
                    selectedNumber = Integer.parseInt(input);

                    // Check if selected number is valid
                    if (selectedNumber >= 1 && selectedNumber <= elements.size()) {
                        // Get the selected appointment
                        AppointmentResultElement selectedAppointment = elements.get(selectedNumber - 1);

                        // Ask user for action
                        System.out.println("Do you want to accept or reject this appointment? (a/r), or press 'q' to quit");
                        String action = reader.readLine().toLowerCase();

                        // Perform action based on user input
                        if (action.equals("a")) {
                            // Simulate accepting appointment
                            ctrl.acceptMethod(selectedAppointment.getDAppo(), selectedAppointment.getTime(), email);
                        } else if (action.equals("r")) {
                            // Simulate rejecting appointment
                            ctrl.deleteAppo(selectedAppointment.getDAppo(), selectedAppointment.getTime(), email);
                        } else if (action.equals("q")) {
                            // User chose to quit
                            return; // Exit the method
                        } else {
                            System.out.println("Invalid action. Please enter 'a' to accept, 'r' to reject, or 'q' to quit.");
                        }

                        // Refresh booked services view
                        refreshBookedServicesView(uE.getEmail());
                    } else {
                        System.out.println("Invalid number. Please enter a number between 1 and " + elements.size());
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number or 'q' to quit.");
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void refreshBookedServicesView(String email) {
        CLIController viewController = CLIController.getIstance();
        UserEntity uE = UserEntity.getInstance();
        String namesearch = uE.getName();
        String surnamesearch = uE.getSurname();
        viewController.showNotifications(namesearch, surnamesearch, email);
    }

}
