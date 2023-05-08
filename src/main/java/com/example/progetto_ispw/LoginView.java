package com.example.progetto_ispw;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginView {
    @FXML
    public AnchorPane AnchorPaneLogin;
    @FXML
    public CheckBox RememberMe;
    @FXML
    public Button Login;

    public void RememberMeMethod(ActionEvent actionEvent) {
    }

    public void LoginMethod(ActionEvent actionEvent) {
        try{
        //Carica la nuova pagina
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interfacciaHome.fxml"));
            Parent root = fxmlLoader.load();

            // crea uno stage per la nuova pagina
            Stage stage = new Stage() ;
            stage.setScene((new Scene(root)));

            //mostra la pagina
            stage.show();

            //chiudi la pagina di login
            ((Node)(actionEvent.getSource())).getScene().getWindow().hide(); //serve per chiudere hide

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

