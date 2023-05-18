package com.example.progetto_ispw;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

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
    public TextField confermaPassTextFieldSignUp;
    @FXML
    public Button buttonSignUp;
    @FXML
    public TextField passwordTextFieldSignUp;

    public void signUpMethod(ActionEvent actionEvent) {//compilare
    }

    public void preCompile(String email, String password) {
        this.emailTextFieldSignUp.setText(email);
        this.passwordTextFieldSignUp.setText(password);
    }
}
