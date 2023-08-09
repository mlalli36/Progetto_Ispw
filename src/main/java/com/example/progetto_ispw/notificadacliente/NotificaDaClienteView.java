package com.example.progetto_ispw.notificadacliente;

import com.example.progetto_ispw.UIController;
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

    public void homeMethod(ActionEvent actionEvent) throws IOException {UIController controller=UIController.getUIControllerInstance(); controller.showHome();  }

   

    public void bookedServicesMethod(ActionEvent actionEvent) {//da implementare
    }

    public void myDetailsMethod(ActionEvent actionEvent) {//da implementare
    }

    public void changePasswordMethod(ActionEvent actionEvent) {//da implementare
    }

    public void addressesMethod(ActionEvent actionEvent) {//da implementare
    }

   

    public void exitMethod(ActionEvent actionEvent) throws IOException {
        UIController controller= UIController.getUIControllerInstance();
        controller.showExit();
    }

    public void notificationMethod(ActionEvent actionEvent) {//da implementare
    }

    public void changeWorkHoursMethod(ActionEvent actionEvent) {
    }
}
