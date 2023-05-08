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
    public AnchorPane AnchorsPaneNotificaDaCliente;
    @FXML
    public Button Profile;
    @FXML
    public Button Favorites;
    @FXML
    public Button Home;
    @FXML
    public Button ReadForm;
    @FXML
    public Button Delete;
    @FXML
    public Button BookedServices;
    @FXML
    public Button MyDetails;
    @FXML
    public Button ChangePassword;
    @FXML
    public Button Addresses;
    @FXML
    public Button NeedHelp;
    @FXML
    public Button Exit;
    @FXML
    public Button Notification;

    @FXML
    public void ProfileMethod(ActionEvent actionEvent) {
    }

    public void FavoritesMethod(ActionEvent actionEvent) {
    }

    public void HomeMethod(ActionEvent actionEvent) {
    }

    public void ReadFormMethod(ActionEvent actionEvent) {
    }

    public void DeleteMethod(ActionEvent actionEvent) {
    }

    public void BookedServicesMethod(ActionEvent actionEvent) {
    }

    public void MyDetailsMethod(ActionEvent actionEvent) {
    }

    public void ChangePasswordMethod(ActionEvent actionEvent) {
    }

    public void AddressesMethod(ActionEvent actionEvent) {
    }

    public void NeedHelpMethod(ActionEvent actionEvent) {
    }

    public void ExitMethod(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("interfacciaHome.fxml")));
            Parent root= fxmlLoader.load();

            //crea uno stage per la nuova pagina
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            //chiudi pagina del login
            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
        }catch (IOException e ){
            e.printStackTrace();
        }
    }

    public void NotificationMethod(ActionEvent actionEvent) {
    }
}
