package com.example.progetto_ispw.workerprofile;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.user.UserEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class WorkerProfileView {
    @FXML
    public AnchorPane anchorPaneProfile;
    @FXML
    public Button myDetails;
    @FXML
    public Button bookedServices;
    @FXML
    public Button changePassword;
    @FXML
    public Button addresses;

    @FXML
    public Button exit;
    @FXML
    public Button saveEdits;
    @FXML
    public ImageView profile;
    @FXML
    public ImageView home;
    @FXML
    public Button favorites;
    @FXML
    public TextField emailTextFild;
    @FXML
    public Button changeOfWorkingHoursButton;

    @FXML
    public Label nameLabelWorkerProfile;
    @FXML
    public Label surnameLabelWorkerProfile;
    @FXML
    public Label emailLabelWorkerProfile;
    @FXML
    public Button notifichemetodo;
    @FXML
    public Button profileButton;
    @FXML
    public Button homeButton;
    @FXML
    public Button exitButton;


    public void homeMethod(ActionEvent actionEvent) throws IOException {
        UIController controller= UIController.getUIControllerInstance();
        controller.showHome();}

    public void favoritesMethod(ActionEvent actionEvent) {//da implementare
    }

    public void saveEditsMethod(ActionEvent actionEvent) {//da implementare
    }

    public void bookedServicesMethod(ActionEvent actionEvent) {//da implementare
    }

    public void myDetailsMethod(ActionEvent actionEvent) {//da implementare
    }

    public void changePasswordMethod(ActionEvent actionEvent) {//da implementare
    }

    public void addressesMethod(ActionEvent actionEvent) {//da implementare
    }

    public void exitMethod(ActionEvent actionEvent) throws IOException {
        UIController controller= UIController.getUIControllerInstance();
        controller.showExit();
    }

    public void profileMethod(ActionEvent actionEvent) {//da implementare
    }

    public void changeOfWorkingHoursMethod(ActionEvent actionEvent) throws IOException, UserNotFoundException {
        UserEntity user = UserEntity.getInstance();
        UIController viewController = UIController.getUIControllerInstance();//è singletone

        String emailsearch= user.getEmail();
        WorkerProfileBean wPB=new WorkerProfileBean();
        wPB.setEmail(emailsearch);
        WorkerProfileController wPC=new WorkerProfileController();
        wPC.searchInfo(wPB);
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();




        viewController.insertInfo(namesearch,surnamesearch,emailsearch);
    }

    public void preCompileWorker(String namesearch, String surnamesearch, String emailsearch) {
        this.nameLabelWorkerProfile.setText(namesearch);
        this.surnameLabelWorkerProfile.setText(surnamesearch);
        this.emailLabelWorkerProfile.setText(emailsearch);

    }


    public void notifichemetodo(ActionEvent actionEvent) throws IOException {
        UIController controller =  UIController.getUIControllerInstance();
        controller.showNotificheDaCliente();
    }
}
