package com.example.progetto_ispw.SignUp;

import com.example.progetto_ispw.SignUp.exception.DifferentPasswordException;
import com.example.progetto_ispw.SignUp.exception.UserAlreadyExistsException;
import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.login.exception.LoginFailedException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class SignUpView {
    @FXML
    public AnchorPane anchorPaneSignUP;
    @FXML
    public Text signUpText;
    @FXML
    public TextField emailTextFieldSignUp;
    @FXML
    public TextField cognomeTextFieldSignUp;
    @FXML
    public TextField nomeTextFieldSignUp;
    @FXML
    public TextField confirmPasswordTextFieldSignUp;
    @FXML
    public Button buttonSignUp;
    @FXML
    public TextField passwordTextFieldSignUp;
    @FXML
    public CheckBox checkClient;
    @FXML
    public CheckBox checkWorker;


    public void goToLogIn() throws IOException {
        UIController controller = UIController.getUIControllerInstance();
        controller.showLogin();
    }

    public void signUpMethod() throws IOException {

        try{

            SignUpBean bean = new SignUpBean();
            bean.setEmail(emailTextFieldSignUp.getText());
            bean.setPsw(passwordTextFieldSignUp.getText());
            bean.setConfirmPsw(confirmPasswordTextFieldSignUp.getText());
            bean.setOwner(isOwnerCheckBox.isSelected());
            SignUpController controller = new SignUpController();
            controller.signUpUser(bean);
            UIController.getUIControllerInstance().showSettings();


        } catch (DifferentPasswordException e) {
            statusLabel.setText("Passwords are not the same, check them and try again");
        } catch (LoginFailedException e) {
            statusLabel.setText("The email is not valid");
        } catch (UserAlreadyExistsException e) {
            statusLabel.setText("User already registered. Go to Log In!");
        } finally {
            statusLabel.setOpacity(1);
        }


    }

    public void preCompile(String email, String password) {
        this.emailTextFieldSignUp.setText(email);
        this.passwordTextFieldSignUp.setText(password);
    }
}

















}
