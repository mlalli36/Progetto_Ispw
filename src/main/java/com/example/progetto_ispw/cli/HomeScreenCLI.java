package com.example.progetto_ispw.cli;

import com.example.progetto_ispw.home.HomeBean;
import com.example.progetto_ispw.home.HomeController;
import com.example.progetto_ispw.home.ResultElement;
import com.example.progetto_ispw.home.ResultSetEntity;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.worker.WorkerEmailEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class HomeScreenCLI {
    public void showHome() throws UserNotFoundException, IOException {
        while (this.homeMenu() > 0) {
            //interagisci con l'utente fino a ottenere un input corretto o fino a tornare alla home
        }
        CLIController controller = CLIController.getIstance();
        controller.loadHomeScreen(); //ritorna alla home screen
    }
    private static HomeScreenCLI instance = null;

    private HomeScreenCLI(){}

    public static HomeScreenCLI getInstance(){
        if (HomeScreenCLI.instance == null)
            instance = new HomeScreenCLI();
        return instance;
    }
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final CLIController controller = CLIController.getIstance();
    private static final UserEntity user = UserEntity.getInstance();

   private int homeMenu() {
        System.out.println("Welcome to the Home Menu!");
        System.out.println("1. Profile");
        System.out.println("2. Home");
        System.out.println("3. Search Worker");
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
                    searchMethod();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    return -1;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
       return 0;
    }

    private static void profileMethod() {
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
                controller.insertInfoUser(namesearch, surnamesearch, emailsearch);
            } else {
                WorkerEmailEntity wkE = WorkerEmailEntity.getInstance();
                wkE.setEmailWEE(emailsearch);
                controller.insertInfoWorker(namesearch, surnamesearch, emailsearch);
            }
        } catch (UserNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



   private static void homeMethod() throws UserNotFoundException, IOException {
        System.out.println("Returning to Home...");
        controller.loadHomeScreen();
    }

    public static void searchMethod() {
        try {
            System.out.println("Enter job title, or press 'q' to quit:");
            String job = reader.readLine().toLowerCase();

            if (job.equals("q")) {
                System.out.println("Exiting search...");
                return; // Esci dalla funzione di ricerca
            }

            System.out.println("Enter location, or press 'q' to quit:");
            String location = reader.readLine().toLowerCase();
            if (location.equals("q")) {
                System.out.println("Exiting search...");
                return; // Esci dalla funzione di ricerca
            }

            HomeBean bean = new HomeBean();
            bean.setJobWork(job);
            bean.setLocationWork(location);

            HomeController homeController = new HomeController();
            homeController.workInfo(bean);

            ResultSetEntity resultSet = bean.getResultSet();
            List<ResultElement> elements = resultSet.getElements();
            if (elements.isEmpty()) {
                System.out.println("No results found.");
            } else {
                // Mostra l'elenco numerato degli elementi
                int index = 1;
                for (ResultElement r : elements) {
                    System.out.println(index);
                    System.out.println("Name: " + r.getWorkerName());
                    System.out.println("Job: " + r.getJobWorker());
                    System.out.println("Location: " + r.getLocationWorker());
                    System.out.println("Description: " + r.getWorkerDescription());
                    System.out.println("Email: " + r.getWorkerEmail());
                    System.out.println();
                    index++;
                }
                // Richiedi all'utente di selezionare un numero
                System.out.println("Enter the number associated with the worker you want to contact, or press 'q' to quit:");
                String input = reader.readLine();

                if (input.equals("q")) {
                    System.out.println("Exiting search...");
                    return; // Esci dalla funzione di ricerca
                }

                int selectedNumber;
                try {
                    selectedNumber = Integer.parseInt(input);

                    // Verifica se il numero selezionato è valido
                    if (selectedNumber >= 1 && selectedNumber <= elements.size()) {
                        // Ottieni l'elemento selezionato
                        ResultElement selectedElement = elements.get(selectedNumber - 1);

                        // Visualizza i dettagli del lavoratore selezionato
                        showIntForm(selectedElement.getWorkerEmail());
                    } else {
                        System.out.println("Invalid number. Please enter a number between 1 and " + elements.size());
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number or 'q' to quit.");
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        }
    }

    public static void showIntForm(String workerEmail) {
        try {


            HomeBean bean = new HomeBean();
            bean.setEmail(user.getEmail()); // Assuming current user's email

            HomeController ctrl = new HomeController();
            ctrl.searchInfo(bean);

            System.out.println("User's name: " + user.getName());
            System.out.println("User's surname: " + user.getSurname());
            System.out.println("User's email: " + user.getEmail());
            System.out.println("Worker's email in form: " + workerEmail);

            CLIController viewController = CLIController.getIstance();
            viewController.showForm(workerEmail, user.getEmail(), user.getName(), user.getSurname());
        } catch (UserNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
