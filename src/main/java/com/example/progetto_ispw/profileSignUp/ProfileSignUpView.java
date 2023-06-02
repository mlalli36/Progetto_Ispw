package com.example.progetto_ispw.profileSignUp;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.login.LoginBean;
import com.example.progetto_ispw.login.LoginController;
import com.example.progetto_ispw.login.exception.LoginFailedException;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.signup.exception.UserAlreadyExistsException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ProfileSignUpView {
    @FXML
    public AnchorPane anchorPaneProfile;
    @FXML
    public TextField nomeTextField;
    @FXML
    public TextField surnameTextField;
    @FXML
    public TextField emailTextField;
    @FXML
    public Button saveEdits;
    @FXML
    public TextField descriptionTextField;
    @FXML
    public TextField professionTextField;
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
    @FXML
    public TextField addressTextField;
    @FXML
    public TextField locationTextField;
    @FXML
    public Label errorLabel;

    public void signUpMethodPrecompile(String email, String nome, String cognome)  {
        this.emailTextField.setText(email);
        this.nomeTextField.setText(nome);
        this.surnameTextField.setText(cognome);


    }

    public void saveEditsMethod()throws IOException {
        ProfileSignUpViewBean bean = new ProfileSignUpViewBean();

        try {

            bean.setEmail(emailTextField.getText());
            bean.setName(nomeTextField.getText());
            bean.setSurname(surnameTextField.getText());
            bean.setDescription(descriptionTextField.getText());
            bean.setLocation(locationTextField.getText());
            bean.setAddress(addressTextField.getText());
            bean.setWork(professionTextField.getText());
            ProfileSignUpViewController controller  = new ProfileSignUpViewController();
            controller.signUpWorker(bean);
            UIController viewController = UIController.getUIControllerInstance();//è singletone

            viewController.showHome();

        } catch (IllegalArgumentException | LoginFailedException | UserAlreadyExistsException exception) {
            errorLabel.setText(exception.getMessage());
            errorLabel.setOpacity(1);
        }
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
