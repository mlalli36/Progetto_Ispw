package com.example.progetto_ispw;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ProfileSignUpView {
    @FXML
    public AnchorPane anchorPaneProfile;
    @FXML
    public TextField nomeTextFild;
    @FXML
    public TextField surnameTextFild;
    @FXML
    public TextField emailTextFild;
    @FXML
    public Button saveEdits;
    @FXML
    public TextField descriptionTextFild;
    @FXML
    public TextField professionTextFild;
    @FXML
    public Button bookedServices;
    @FXML
    public Button myDetails;
    @FXML
    public Button changePassword;
    @FXML
    public Button addresses;
    @FXML
    public Button needHelp;
    @FXML
    public Label infoLabel;

    public void signUpMethodPrecompile(String email, String nome, String cognome) {
        this.emailTextFild.setText(email);
        this.nomeTextFild.setText(nome);
        this.surnameTextFild.setText(cognome);

    }

    public void saveEditsMethod(ActionEvent actionEvent) { //da implementare
    }

    public void bookedServicesMethod(ActionEvent actionEvent) {//da implementare
    }

    public void myDetailsMethod(ActionEvent actionEvent) {//da implementare
    }

    public void changePasswordMethod(ActionEvent actionEvent) {//da implementare
    }

    public void addressesMethod(ActionEvent actionEvent) {//da implementare
    }

    public void needHelpMethod(ActionEvent actionEvent) {//da implementare
    }


}
