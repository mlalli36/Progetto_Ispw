package com.example.progetto_ispw.notifications;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.login.exception.UserNotFoundException;

import com.example.progetto_ispw.user.UserEntity;

import com.example.progetto_ispw.worker.WorkerEmailEntity;
import com.example.progetto_ispw.worker.WorkerTilePane;
import com.example.progetto_ispw.workerprofile.AppointmentResultElement;
import com.example.progetto_ispw.workerprofile.AppointmentResultEntity;

import com.example.progetto_ispw.workerprofile.WorkerProfileBean;
import com.example.progetto_ispw.workerprofile.WorkerProfileController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class NotificationsView {
    @FXML
    public Button profileButton;
    @FXML
    public Button homeButton;
    @FXML
    public Label nameLabelWorkerProfile;
    @FXML
    public Button exitButton;
    @FXML
    public Button changeOfWorkingHoursButton;
    @FXML
    public Label surnameLabelWorkerProfile;
    @FXML
    public Label emailLabelWorkerProfile;
    @FXML
    public Button notificationButton;
    @FXML
    public ScrollPane scrollPane;
    @FXML
    public Text noAppointmentText;
    @FXML
    public Button bookedServicesButton;
    @FXML
    public Button acceptButton;
    @FXML
    public Button myDetails;

    private NotificationsController controller= new NotificationsController();
    private  NotificationsBean bean=new NotificationsBean();
    private UserEntity user = UserEntity.getInstance();

    public void profileMethod(ActionEvent actionEvent) throws IOException {

        UIController viewController= UIController.getUIControllerInstance();
        String emailsearch= user.getEmail();

        bean.setEmail(user.getEmail());
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();
        viewController.insertInfoWorker(namesearch,surnamesearch,emailsearch);
    }

    public void homeMethod(ActionEvent actionEvent) throws IOException {
        UIController ctrl= UIController.getUIControllerInstance();
        ctrl.showHome();
    }

    public void exitMethod(ActionEvent actionEvent) throws IOException {
        UIController ctrl= UIController.getUIControllerInstance();
        ctrl.showExit();
    }

    public void changeOfWorkingHoursMethod(ActionEvent actionEvent) throws UserNotFoundException, IOException {

        UIController viewController = UIController.getUIControllerInstance();//è singletone

        String emailsearch= user.getEmail();

        bean.setEmail(emailsearch);
        controller.searchInfo(bean);
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();

        viewController.insertInfo(namesearch,surnamesearch,emailsearch);
    }
    public void bookedServicesMethod(ActionEvent actionEvent) throws UserNotFoundException, IOException {

        UIController viewController = UIController.getUIControllerInstance();//è singletone

        String emailsearch= user.getEmail();

        bean.setEmail(emailsearch);
        controller.searchInfo(bean);
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();

        viewController.showBookedServicesWorker(namesearch,surnamesearch,emailsearch);

    }
    public void notificationMethod(ActionEvent actionEvent) throws IOException {
        notificationButton.setOnAction(event -> {

            UIController viewController = UIController.getUIControllerInstance();//è singletone

            String emailsearch= user.getEmail();

            bean.setEmail(emailsearch);

            try {
                controller.searchInfo(bean);
            } catch (UserNotFoundException e) {
                throw new RuntimeException(e);
            }

            String namesearch= user.getName();
            String surnamesearch= user.getSurname();
            try {
                viewController.showNotifications(namesearch,surnamesearch,emailsearch);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
        scrollPane.setOpacity(1);
        WorkerEmailEntity wkE= WorkerEmailEntity.getInstance();
        String email= wkE.getEmailWEE();

        bean.setEmail(email);
        if(controller.verifica(bean)) {
            AppointmentResultEntity appointmentResultEntity = bean.getAppointmentResultSet();
            WorkerTilePane workerTilePane = new WorkerTilePane();
            workerTilePane.createWorkerTilePane();
            scrollPane.setVisible(true);
            for (AppointmentResultElement a : appointmentResultEntity.getElements()) {
                Button accepttButton = new Button("Accept");
                Button rejectButton = new Button("Reject");


                String emailclient = a.getCEmail();
                String name_client = a.getCName();
                String surname_client = a.getCSurname();
                String phone_client = a.getCNumber();
                String description_work = a.getdescriptionWork();
                String time = a.getTime();
                String date = a.getDAppo();

                workerTilePane.addElements(accepttButton, rejectButton, name_client, surname_client, emailclient, description_work, phone_client, date, time);

                rejectButton.setOnAction(event -> {

                    try {
                        controller.deleteAppo(date, time, email);
                    } catch (UserNotFoundException e) {
                        throw new RuntimeException(e);
                    }

                    UIController controller= UIController.getUIControllerInstance();
                    String emailsearch= user.getEmail();
                    String namesearch= user.getName();
                    String surnamesearch= user.getSurname();
                    try {
                        controller.showNotifications(emailsearch,namesearch,surnamesearch);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                });
                accepttButton.setOnAction(event -> {

                    try {
                        controller.acceptMethod(date, time, email);
                    } catch (UserNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    //se l'utente accetta allora nella tabella la colonna accetta viene impostato a 1 e quindi non vine piu mostrato nella lista
                    UserEntity user = UserEntity.getInstance();
                    UIController controller= UIController.getUIControllerInstance();
                    String emailsearch= user.getEmail();
                    String namesearch= user.getName();
                    String surnamesearch= user.getSurname();
                    try {
                        controller.showNotifications(emailsearch,namesearch,surnamesearch);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                });

            }
            this.scrollPane.setContent(workerTilePane.getWorkerTP());
        }else {
            noAppointmentText.setOpacity(1);

        }
    }

    public void preCompileWorker(String namesearch, String surnamesearch, String emailsearch) {
        this.nameLabelWorkerProfile.setText(namesearch);
        this.surnameLabelWorkerProfile.setText(surnamesearch);
        this.emailLabelWorkerProfile.setText(emailsearch);
    }


    public void acceptMethod(ActionEvent actionEvent) throws UserNotFoundException, IOException {
        UIController viewController= UIController.getUIControllerInstance();

        String emailsearch= user.getEmail();
        bean.setEmail(user.getEmail());

        controller.searchInfo(bean);
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();

        viewController.showAccept(namesearch,surnamesearch,emailsearch);
    }

    public void myDetailsMethod(ActionEvent actionEvent) throws IOException, UserNotFoundException {
        UIController viewController = UIController.getUIControllerInstance();//è singletone

        String emailsearch= user.getEmail();

        bean.setEmail(emailsearch);
        controller.searchInfo(bean);
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();

        viewController.showMyDetailsWorker(namesearch,surnamesearch,emailsearch);

    }
}
