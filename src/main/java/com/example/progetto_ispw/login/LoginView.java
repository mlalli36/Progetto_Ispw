package com.example.progetto_ispw.login;

import com.example.progetto_ispw.login.Exception.LoginFailedException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginView {
    @FXML
    public AnchorPane anchorPaneLogin;
    @FXML
    public CheckBox rememberMe;
    @FXML
    public Button login;
    @FXML
    public Label errorLabel;
    @FXML
    public TextField passwordTextField;
    @FXML
    public TextField emailTextField;


    public void rememberMeMethod(ActionEvent actionEvent) {//da implementare
    }

    public void handleLogin() throws IOException{
            this.errorLabel.setOpacity(0.0);
            this.errorLabel.setTextFill((Color.RED));
            LoginBean bean = new LoginBean();

            try {
                bean.setEmail(this.emailTextField.getText());
                bean.setPassword(this.passwordTextField.getText());
                LoginController controller  = new LoginController();
                controller.loginUser(bean);
                UIController viewController = UIController.getUIControllerInstance();//è singletone
                viewController.showHome();

            }catch(IllegalArgumentException | LoginFailedException exception) {
                errorLabel.setText(exception.getMessage());
                errorLabel.setOpacity(1);
            }catch{userNotFoundException e ){
            this.popUpPane();
            this.popUpPane();
        }

    }



    public void loginMethod(ActionEvent actionEvent) {
        try{
        //Carica la nuova pagina
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interfacciaHome.fxml"));
            Parent root = fxmlLoader.load();

            // crea uno stage per la nuova pagina
            Stage stage = new Stage() ;
            stage.setScene((new Scene(root)));

            //mostra la pagina
            stage.show();

            //chiudi la pagina di com.example.progetto_ispw.login
            ((Node)(actionEvent.getSource())).getScene().getWindow().hide(); //serve per chiudere hide

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}


