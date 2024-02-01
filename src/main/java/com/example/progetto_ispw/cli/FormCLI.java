package com.example.progetto_ispw.cli;

import com.example.progetto_ispw.fillform.FillFormBean;
import com.example.progetto_ispw.fillform.FillFormController;
import com.example.progetto_ispw.fillform.exception.*;
import com.example.progetto_ispw.home.HomeBean;
import com.example.progetto_ispw.home.HomeController;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.savehoursslots.SlotHoursEntity;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.worker.WorkerEmailEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FormCLI {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final UserEntity user = UserEntity.getInstance();
    private static final CLIController controllerCLI = CLIController.getIstance();
    public void fillForm(String emailWorker, String emailC, String nameC, String surnameC) {
        System.out.println("Welcome to the fill Form!");
        System.out.println("1. Profile");
        System.out.println("2. Home");
        System.out.println("3. Send Form");
        System.out.println("4. Exit");

        try {
            int choice = Integer.parseInt(reader.readLine());
            switch (choice) {
                case 1:
                    profileMethod();
                    break;
                case 2:
                    homeMethod();
                    break;
                case 3:
                    sendForm(emailWorker,emailC,nameC,surnameC);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }



    private void homeMethod() {
        System.out.println("Returning to Home...");
        controllerCLI.loadHomeScreen();
    }



    private void profileMethod() {
        try {
            String type = user.getTipoaccesso();
            System.out.println(type);
            String emailsearch = user.getEmail();
            HomeBean homeBean = new HomeBean();
            homeBean.setEmail(emailsearch);
            HomeController homeController = new HomeController();
            homeController.searchInfo(homeBean);
            String namesearch = user.getName();
            String surnamesearch = user.getSurname();
            System.out.println("home view nome utente: " + user.getName());
            System.out.println("home view cognnome utente: " + user.getSurname());

            if (!"Worker".equals(type)) {
                controllerCLI.insertInfoUser(namesearch, surnamesearch, emailsearch);
            } else {
                WorkerEmailEntity wkE = WorkerEmailEntity.getInstance();
                wkE.setEmailWEE(emailsearch);
                controllerCLI.insertInfoWorker(namesearch, surnamesearch, emailsearch);
            }
        } catch (UserNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    private void sendForm(String emailWorker, String emailC, String nameC, String surnameC) {
        try {
            String userEmail = emailC;
            String userName = nameC;
            String userSurname = surnameC;

            // Stampare i valori per mostrare all'utente
            System.out.println("Email: " + userEmail);
            System.out.println("Name: " + userName);
            System.out.println("Surname: " + userSurname);

            System.out.println("Enter your description:");
            String userDescription = reader.readLine();

            System.out.println("Enter your phone number:");
            String userPhone = reader.readLine();

            // Leggi la data inserita dall'utente
            System.out.println("Enter the date (YYYY-MM-DD):");
            String dateString = reader.readLine();

            // Gestisci il caso in cui la data sia vuota
            if (dateString.isEmpty()) {
                throw new EmptyDateFieldException("");
            }
            // Simula la chiamata al controller per ottenere gli slot
            FillFormController controller = new FillFormController();
            FillFormBean bean = new FillFormBean();

            bean.setEmailWorker(emailWorker);
            bean.setEmailUser(userEmail);
            bean.setName(userName);
            bean.setSurname(userSurname);
            bean.setDescription(userDescription);
            bean.setPhone(userPhone);
            bean.setDate(dateString);

            controller.takeSlot(bean);

            SlotHoursEntity sl = SlotHoursEntity.getInstance();
            String slot1 = sl.getSlot1();
            String slot2 = sl.getSlot2();
            String slot3 = sl.getSlot3();
            String slot4 = sl.getSlot4();
            String slot5 = sl.getSlot5();

            // Simula la stampa degli slot
            System.out.println("Available time slots:");
            System.out.println("1. " + slot1);
            System.out.println("2. " + slot2);
            System.out.println("3. " + slot3);
            System.out.println("4. " + slot4);
            System.out.println("5. " + slot5);

            // Simula la selezione degli slot dall'utente
            int selectedSlotIndex;
            do {
                System.out.println("Select the available time slot (1-5):");
                selectedSlotIndex = Integer.parseInt(reader.readLine()) - 1;
            } while (selectedSlotIndex < 0 || selectedSlotIndex > 4);

            // Ottieni lo slot selezionato
            String selectedSlot = null;
            switch (selectedSlotIndex) {
                case 0:
                    selectedSlot = slot1;
                    break;
                case 1:
                    selectedSlot = slot2;
                    break;
                case 2:
                    selectedSlot = slot3;
                    break;
                case 3:
                    selectedSlot = slot4;
                    break;
                case 4:
                    selectedSlot = slot5;
                    break;
            }

            sl.setAppointment(selectedSlot);
            String appuntamento = sl.getAppointment();
            bean.setTime(appuntamento);
            // Simula la creazione del bean e l'invio al controller




            controller.fill(bean);

            // Simula la visualizzazione della schermata principale dopo l'invio del modulo
            System.out.println("Form submitted successfully. Returning to home screen.");

            controllerCLI.loadHomeScreen();

        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Invalid slot selection. Please enter a number between 1 and 5.");
        } catch (EmptyDateFieldException e) {
            System.err.println("Date field cannot be empty.");
        }catch (TimeAlreadySelectedException e) {
            System.err.println("The selected time is no longer valid.");
        }catch (EmptyNameFieldException e) {
            System.err.println("WARNING: NAME FIELD IS EMPTY!");
        }catch (EmptySurameFieldException e) {
            System.err.println("WARNING: SURNAME FIELD IS EMPTY!");
        }catch (EmptyDescriptionFieldException e) {
            System.err.println("WARNING: DESCRIPTION FIELD IS EMPTY!");
        }catch (NotValidNumberPhoneException e) {
            System.err.println("WARNING: PHONE FIELD ISN'T VALID!");
        }catch (InvalidEmailFormatException e) {
            System.err.println("WARNING: INVALID EMAIL FORMAT!");
        }

    }

}
