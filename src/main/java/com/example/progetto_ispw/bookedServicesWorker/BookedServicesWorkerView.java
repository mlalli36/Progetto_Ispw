package com.example.progetto_ispw.bookedServicesWorker;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.bookedServicesUser.BookedServicesUserBean;
import com.example.progetto_ispw.bookedServicesUser.BookedServicesUserController;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.userprofile.UserProfileController;
import com.example.progetto_ispw.userprofile.UserTilePane;
import com.example.progetto_ispw.worker.WorkerEntity;
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

public class BookedServicesWorkerView {
    @FXML
    public Button profileButton;
    @FXML
    public Button homeButton;
    @FXML
    public Label nameLabelWorkerProfile;
    @FXML
    public Button bookedServicesButton;
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

    public void profileMethod(ActionEvent actionEvent) throws UserNotFoundException, IOException {
        UIController controller = UIController.getUIControllerInstance();
        controller.showProfile();
    }

    public void homeMethod(ActionEvent actionEvent) throws IOException {
        UIController viewController = UIController.getUIControllerInstance();//è singletone
        viewController.showHome();
    }

    public void bookedServicesMethod(ActionEvent actionEvent) {
        scrollPane.setOpacity(1);
        WorkerEntity entity = new WorkerEntity();  //MI DA NULLA L'EMAIL PERCHè FACCIO LA NEW, CAMBIAREEE
        //String email = entity.getEmail();

        BookedServicesWorkerBean bean = new BookedServicesWorkerBean();
        bean.setEmail(String.valueOf(emailLabelWorkerProfile));
        System.out.println("email in book worker"+ emailLabelWorkerProfile);
        BookedServicesWorkerController ctrl = new BookedServicesWorkerController();
        if (ctrl.verifica(bean)) {
            AppointmentResultEntity appointmentResultEntity = bean.getAppointmentResultSet();
            UserTilePane workerTilePane = new UserTilePane();
            workerTilePane.createUserTilePane();
            scrollPane.setVisible(true);

            for (AppointmentResultElement a : appointmentResultEntity.getElements()) {

                Button deleteButton = new Button("Delete");


                String email_client = a.getCEmail();
                String name_client = a.getCName();
                String surname_client = a.getCSurname();
                String phone_client = a.getCNumber();
                String description_work = a.getdescriptionWork();
                String time = a.getTime();
                String date = a.getDAppo();
                String email_worker = a.getWEmail();

                workerTilePane.addElements(deleteButton, name_client, surname_client, email_client, description_work, phone_client, date, time, email_worker);
                deleteButton.setOnAction(event -> {

                    WorkerProfileController controller = new WorkerProfileController();
                    controller.deleteAppoW(email_worker, date, time);
                });




            }
            this.scrollPane.setContent(workerTilePane.getUserTP());

        } else {
            noAppointmentText.setText("You have no appointments in your schedule..");
        }
    }

    public void exitMethod(ActionEvent actionEvent) throws IOException {
        UIController controller= UIController.getUIControllerInstance();
        controller.showExit();
    }

    public void changeOfWorkingHoursMethod(ActionEvent actionEvent) throws UserNotFoundException, IOException {
        UserEntity user = UserEntity.getInstance();
        UIController viewController = UIController.getUIControllerInstance();//è singletone

        String emailsearch= user.getEmail();
        BookedServicesWorkerBean bean=new BookedServicesWorkerBean();
        bean.setEmail(emailsearch);
        BookedServicesWorkerController controller=new BookedServicesWorkerController();
        controller.searchInfo(bean);
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();
        viewController.insertInfo(namesearch,surnamesearch,emailsearch);
    }

    public void notificationMethod(ActionEvent actionEvent) throws UserNotFoundException, IOException {
        UserEntity user=UserEntity.getInstance();
        UIController viewController= UIController.getUIControllerInstance();

        String emailsearch= user.getEmail();
        BookedServicesWorkerBean bean = new BookedServicesWorkerBean();
        bean.setEmail(user.getEmail());
        BookedServicesWorkerController controller =new BookedServicesWorkerController();
        controller.searchInfo(bean);
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();

        viewController.showNotifications(namesearch,surnamesearch,emailsearch);
    }

    public void preCompileWorker(String namesearch, String surnamesearch, String emailsearch) {
        this.nameLabelWorkerProfile.setText(namesearch);
        this.surnameLabelWorkerProfile.setText(surnamesearch);
        this.emailLabelWorkerProfile.setText(emailsearch);
    }
}
