package com.example.progetto_ispw.acceptAppointment;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.bookedServicesWorker.BookedServicesWorkerBean;
import com.example.progetto_ispw.bookedServicesWorker.BookedServicesWorkerController;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.notifications.NotificationsBean;
import com.example.progetto_ispw.notifications.NotificationsController;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.worker.WorkerEmailEntity;
import com.example.progetto_ispw.worker.WorkerTilePane;
import com.example.progetto_ispw.workerprofile.AppointmentResultElement;
import com.example.progetto_ispw.workerprofile.AppointmentResultEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class AcceptView {
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
    public Button acceptButton;
    @FXML
    public Button myDetails;
    private AcceptController controller= new AcceptController();
    private AcceptBean bean=new AcceptBean();
    private UserEntity user = UserEntity.getInstance();

    public void profileMethod(ActionEvent actionEvent) throws UserNotFoundException, IOException {
        UIController controller = UIController.getUIControllerInstance();
        controller.showProfile();
    }

    public void homeMethod(ActionEvent actionEvent) throws IOException {
        UIController viewController = UIController.getUIControllerInstance();//è singletone
        viewController.showHome();
    }

    public void exitMethod(ActionEvent actionEvent) throws IOException {
        UIController controller= UIController.getUIControllerInstance();
        controller.showExit();
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

    public void notificationMethod(ActionEvent actionEvent) throws UserNotFoundException, IOException {

        UIController viewController= UIController.getUIControllerInstance();

        String emailsearch= user.getEmail();

        bean.setEmail(user.getEmail());

        controller.searchInfo(bean);
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();

        viewController.showNotifications(namesearch,surnamesearch,emailsearch);
    }

    public void acceptMethod(ActionEvent actionEvent) {
        acceptButton.setOnAction(event -> {

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
                viewController.showAccept(namesearch,surnamesearch,emailsearch);
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

            AcceptTilePane acceptTilePane = new AcceptTilePane();
            acceptTilePane.createAcceptTilePane();
            scrollPane.setVisible(true);
            for (AppointmentResultElement a : appointmentResultEntity.getElements()) {

                String email_client = a.getCEmail();
                String name_client = a.getCName();
                String surname_client = a.getCSurname();
                String phone_client = a.getCNumber();
                String description_work = a.getdescriptionWork();
                String time = a.getTime();
                String date = a.getDAppo();

                acceptTilePane.addElements(name_client, surname_client, email_client, description_work, phone_client, date, time);



            }
            this.scrollPane.setContent(acceptTilePane.getAcceptTP());
        }else {
            noAppointmentText.setOpacity(1);

        }
    }

    public void preCompileWorker(String namesearch, String surnamesearch, String emailsearch) {
        this.nameLabelWorkerProfile.setText(namesearch);
        this.surnameLabelWorkerProfile.setText(surnamesearch);
        this.emailLabelWorkerProfile.setText(emailsearch);
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

    public void myDetailsMethod(ActionEvent actionEvent) throws UserNotFoundException, IOException {
        UIController viewController = UIController.getUIControllerInstance();//è singletone

        String emailsearch= user.getEmail();

        bean.setEmail(emailsearch);
        controller.searchInfo(bean);
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();

        viewController.showMyDetailsWorker(namesearch,surnamesearch,emailsearch);
    }
}
