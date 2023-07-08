package com.example.progetto_ispw.login;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.login.exception.LoginFailedException;
import com.example.progetto_ispw.login.exception.UserNotFoundException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


import java.io.IOException;

public class LoginView {
    @FXML
    public AnchorPane anchorPaneLogin;

    @FXML
    public Button login;
    @FXML
    public Label errorLabel;
    @FXML
    public TextField passwordTextField;
    @FXML
    public TextField emailTextField;

    @FXML
    public Button signUp;
    @FXML
    public TextField confermaPassTextField;
    @FXML
    public TextField nomeTextField;
    @FXML
    public TextField cognomeTextField;
    @FXML
    public Text scritta;
    @FXML
    public Text getHelp;
    @FXML
    public Text signUpText;
    @FXML
    public TextField cognomeTextFieldSignUp;
    @FXML
    public TextField emailTextFieldSignUp;
    @FXML
    public TextField confermaPassTextFieldSignUp;
    @FXML
    public Button buttonSignUp;
    @FXML
    public TextField passwordTextFieldSignUp;
    @FXML
    public Button createAccountButton;
    @FXML
    public Pane popUpPane;
    @FXML
    public Button goToSignUp;
    @FXML
    public Button back;


    public void loginMethod() throws IOException{
            errorLabel.setOpacity(0.0);
            errorLabel.setTextFill((Color.RED));
            LoginBean bean = new LoginBean();

            try {

                bean.setEmail(emailTextField.getText());
                bean.setPassword(passwordTextField.getText());
                LoginController controller  = new LoginController();
                controller.loginUser(bean);
                UIController viewController = UIController.getUIControllerInstance();//è singletone

                viewController.showHome();

            } catch (IllegalArgumentException | LoginFailedException exception) {
                errorLabel.setText(exception.getMessage());
                errorLabel.setOpacity(1);
            } catch (UserNotFoundException e){
                this.popUpPane.setOpacity(1);
                this.popUpPane.setMouseTransparent(false);
            }

    }
    public void showSignUp() throws IOException {
      UIController controller = UIController.getUIControllerInstance();
      controller.showSignUp();
    }

    public void precompiledSignUp() throws IOException {
        UIController viewController = UIController.getUIControllerInstance();
        viewController.precompileSignUp(emailTextField.getText(), passwordTextField.getText());
    }


    public void backMethod() throws IOException {
        UIController controller = UIController.getUIControllerInstance();
        controller.showLogin();
    }


}

