package com.example.progetto_ispw.secondinterfaceview;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.login.exception.LoginFailedException;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.signup.SignUpBean;
import com.example.progetto_ispw.signup.SignUpController;
import com.example.progetto_ispw.signup.exception.DifferentPasswordException;
import com.example.progetto_ispw.signup.exception.UserAlreadyExistsException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class SignUp2View {

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
    @FXML
    public AnchorPane anchorPaneSignUP;
    @FXML
    public CheckBox checkWorker;
    @FXML
    public Label statusLabel;

    public void signUpMethod()throws IOException {
        try{

            SignUpBean bean = new SignUpBean();
            bean.setName(nomeTextFieldSignUp.getText());
            bean.setSurname(cognomeTextFieldSignUp.getText());
            bean.setEmail(emailTextFieldSignUp.getText());
            bean.setPsw(passwordTextFieldSignUp.getText());
            bean.setConfirmPsw(confermaPassTextFieldSignUp.getText());
            bean.setWorker(checkWorker.isSelected()); //se isSelected è false, cioè il checkbox non è stato spuntato, allora alla bean viene passato false e quindi nella bean si entrerà nel ramo else e verrà impostato come client

            SignUpController controller = new SignUpController();
            controller.signUpUser(bean);
            UIController viewController= UIController.getUIControllerInstance();
            if(!bean.isWorker()){
                viewController.showHome();
            } else{
                viewController.showProfileSignUp();
                viewController.signUpMethod(emailTextFieldSignUp.getText(), nomeTextFieldSignUp.getText(), cognomeTextFieldSignUp.getText());

            }


        }


        catch (DifferentPasswordException e) {
            statusLabel.setText("Passwords are not the same, check them and try again");
        }
        catch (LoginFailedException e) {
            statusLabel.setText("The email is not valid");
        } catch (UserAlreadyExistsException e) {
            statusLabel.setText("User already registered. Go to Log In!");
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            statusLabel.setOpacity(1);
        }
    }


    public void preCompile(String email, String password) {
        this.emailTextFieldSignUp.setText(email);
        this.passwordTextFieldSignUp.setText(password);
    }


}
