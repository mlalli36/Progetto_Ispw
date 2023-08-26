package com.example.progetto_ispw.bookedServicesUser;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.notifications.NotificationsBean;
import com.example.progetto_ispw.notifications.NotificationsController;
import com.example.progetto_ispw.user.UserDAO;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.userprofile.UserProfileBean;
import com.example.progetto_ispw.userprofile.UserProfileController;
import com.example.progetto_ispw.userprofile.UserTilePane;
import com.example.progetto_ispw.worker.InfoAppoinEntity;
import com.example.progetto_ispw.worker.InfoAppoinEntity2;
import com.example.progetto_ispw.workerprofile.AppointmentResultElement;
import com.example.progetto_ispw.workerprofile.AppointmentResultEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;

public class BookedServicesUserView {
    @FXML
    public Button profileButton;
    @FXML
    public Button homeButton;
    @FXML
    public Label nameLabelUserProfile;
    @FXML
    public Button exitButton;
    @FXML
    public Label surnameLabelUserProfile;
    @FXML
    public Label emailLabelUserProfile;
    @FXML
    public ScrollPane scrollPane;
    @FXML
    public Text noAppointmentText;
    @FXML
    public Button bookedServicesButton;

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

    public void bookedServicesMethod(ActionEvent actionEvent) {
        scrollPane.setOpacity(1);
        UserEntity uE = UserEntity.getInstance();
        String email = uE.getEmail();
        BookedServicesUserBean bean = new BookedServicesUserBean();
        bean.setEmail(email);
        BookedServicesUserController ctrl = new BookedServicesUserController();
        if (ctrl.verifica(bean)) {
            AppointmentResultEntity appointmentResultEntity = bean.getAppointmentResultSet();
            UserTilePane userTilePane = new UserTilePane();
            userTilePane.createUserTilePane();
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

                    userTilePane.addElements(deleteButton, name_client, surname_client, email_client, description_work, phone_client, date, time, email_worker);

                    deleteButton.setOnAction(event -> {

                        BookedServicesUserController controller = new BookedServicesUserController();
                        controller.deleteAppoU(email_client, date, time);
                        UserEntity user = UserEntity.getInstance();
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
                            viewController.showBookedServicesUser(namesearch,surnamesearch,emailsearch);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    });




                }
                this.scrollPane.setContent(userTilePane.getUserTP());

            } else {
                noAppointmentText.setText("You have no appointments in your schedule..");
            }

        }


    public void preCompileUser(String namesearch, String surnamesearch, String emailsearch) {
        this.nameLabelUserProfile.setText(namesearch);
        //this.surnameLabelUserProfile.setText(surnamesearch);
        this.emailLabelUserProfile.setText(emailsearch);
    }
}
