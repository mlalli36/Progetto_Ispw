package com.example.progetto_ispw.cli;

import com.example.progetto_ispw.bookedServicesUser.BookedServicesUserBean;
import com.example.progetto_ispw.bookedServicesUser.BookedServicesUserController;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.workerprofile.AppointmentResultElement;
import com.example.progetto_ispw.workerprofile.AppointmentResultEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class BookedServicesUserCLI {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public void bookedServicesMethod() {

        try {
            UserEntity uE = UserEntity.getInstance();
            String email = uE.getEmail();

            BookedServicesUserBean bean = new BookedServicesUserBean();
            bean.setEmail(email);

            BookedServicesUserController ctrl = new BookedServicesUserController();
            ctrl.verifica(bean);

            AppointmentResultEntity appointmentResultEntity = bean.getAppointmentResultSet();
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

                // Ask user to select an appointment or exit
                System.out.println("Enter the number associated with the appointment you want to delete, or press 'q' to quit:");
                String input = reader.readLine();

                if (input.equalsIgnoreCase("q")) {
                    CLIController cliController= CLIController.getIstance();
                    cliController.showProfile();
                    return; // Exit the method
                }

                int selectedNumber;
                try {
                    selectedNumber = Integer.parseInt(input);

                    // Check if selected number is valid
                    if (selectedNumber >= 1 && selectedNumber <= elements.size()) {
                        // Get the selected appointment
                        AppointmentResultElement selectedAppointment = elements.get(selectedNumber - 1);

                        // Simulate deleting appointment
                        ctrl.deleteAppoU(selectedAppointment.getCEmail(), selectedAppointment.getDAppo(), selectedAppointment.getTime());

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

    private static void refreshBookedServicesView(String userEmail) {
        CLIController viewController = CLIController.getIstance();
        UserEntity uE = UserEntity.getInstance();
        String namesearch= uE.getName();
        String surnamesearch= uE.getSurname();
        viewController.showBookedServicesUser(namesearch, surnamesearch, userEmail);
    }
}
