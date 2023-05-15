package com.example.progetto_ispw;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class NotificaDaClienteView {
    @FXML
    public AnchorPane anchorsPaneNotificaDaCliente;
    @FXML
    public Button profile;
    @FXML
    public Button favorites;
    @FXML
    public Button home;
    @FXML
    public Button readForm;
    @FXML
    public Button delete;
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
    public Button exit;
    @FXML
    public Button notification;

    @FXML
    public void profileMethod(ActionEvent actionEvent) {//da implementare
    }

    public void favoritesMethod(ActionEvent actionEvent) {//da implementare
    }

    public void homeMethod(ActionEvent actionEvent) {//da implementare
    }

    public void readFormMethod(ActionEvent actionEvent) {//da implementare
    }

    public void deleteMethod(ActionEvent actionEvent) {//da implementare
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

    public void exitMethod(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("interfacciaHome.fxml")));
            Parent root= fxmlLoader.load();

            //crea uno stage per la nuova pagina
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            //chiudi pagina del com.example.progetto_ispw.login
            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
        }catch (IOException e ){
            e.printStackTrace();
        }
    }

    public void notificationMethod(ActionEvent actionEvent) {//da implementare
    }
}
