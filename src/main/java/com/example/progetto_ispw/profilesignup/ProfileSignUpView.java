package com.example.progetto_ispw.profilesignup;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.login.exception.LoginFailedException;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.signup.exception.UserAlreadyExistsException;
import com.example.progetto_ispw.user.UserEntity;
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
    public Button changeHours;
    @FXML
    public Label infoLabel;
    @FXML
    public TextField addressTextField;
    @FXML
    public TextField locationTextField;
    @FXML
    public Label errorLabel;
    @FXML
    public Button logoutButton;
    @FXML
    public Label nameLabel;
    @FXML
    public Label cognomeLabel;
    @FXML
    public Button profileButton;
    @FXML
    public Label emailLabel;
    @FXML
    public Button bookedServices1;
    @FXML
    public Label surnameLabel;
    @FXML
    public TextField CAPTextField;

    public void signUpMethodPrecompile(String email, String nome, String cognome)  {
        this.emailTextField.setText(email);
        this.nomeTextField.setText(nome);
        this.surnameTextField.setText(cognome);
        this.nameLabel.setText(nome);
        this.surnameLabel.setText(cognome);

    }
    public void profileMethod(ActionEvent actionEvent) throws IOException, UserNotFoundException {
        UserEntity user = UserEntity.getInstance();
        UIController viewController= UIController.getUIControllerInstance();
        String emailsearch= user.getEmail();
        ProfileSignUpBean bean= new ProfileSignUpBean();
        bean.setEmail(user.getEmail());
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();
        viewController.insertInfoWorker(namesearch,surnamesearch,emailsearch);
    }
    public void saveEditsMethod()throws IOException {
        ProfileSignUpBean bean = new ProfileSignUpBean();

        try {

            bean.setEmail(emailTextField.getText());
            bean.setName(nomeTextField.getText());
            bean.setSurname(surnameTextField.getText());
            bean.setDescription(descriptionTextField.getText());
            bean.setLocation(locationTextField.getText());
            bean.setAddress(addressTextField.getText());
            bean.setWork(professionTextField.getText());
            ProfileSignUpController controller  = new ProfileSignUpController();
            controller.signUpWorker(bean);
            UIController viewController = UIController.getUIControllerInstance();//è singletone

            viewController.showHome();

        } catch (IllegalArgumentException | LoginFailedException | UserAlreadyExistsException exception) {
            errorLabel.setText(exception.getMessage());
            errorLabel.setOpacity(1);
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
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

    public void changeHoursMethod(ActionEvent actionEvent) { //da implementare
    }


    public void logoutMethod() throws IOException {
        UIController viewController = UIController.getUIControllerInstance();//è singletone
        viewController.showLogin();
    }


    public void preCompile(String namesearch, String surnamesearch, String emailsearch) {
        this.nameLabel.setText(namesearch);
        this.surnameLabel.setText(surnamesearch);
        this.emailLabel.setText(emailsearch);
    }
}
