package com.example.progetto_ispw.userProfile;

import com.example.progetto_ispw.user.UserEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserProfileView {
    @FXML
    public AnchorPane anchorPaneProfile;
    @FXML
    public Button profile;
    @FXML
    public ImageView home;
    @FXML
    public ImageView favorites;
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
    public Label nameLabelUserProfile;
    @FXML
    public Label surnameLabelUserProfile;
    @FXML
    public Label emailLabelUserProfile;

    public void profileMethod(ActionEvent actionEvent) {//da implementare
    }

    public void homeMethod(ActionEvent actionEvent) {
        try{
            //crea pagina nuova
            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("interfacciaHome.fxml"));
            Parent root=fxmlLoader.load();

            //crea uno stage per la nuova pagina
            Stage stage= new Stage();
            stage.setScene((new Scene(root)));

            //mostra la pagina caricata nellos stage
            stage.show();

            //chiudi la vista di com.example.progetto_ispw.login
            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();


        } catch(IOException e){
            e.printStackTrace();
        }

    }

    public void favoritesMethod(MouseEvent mouseEvent) {//da implementare
    }

    public void bookedServicesMethod(ActionEvent actionEvent) {//da implementare
    }

    public void myDetailsMethod(ActionEvent actionEvent) {
        try{
            //crea pagina nuova
            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("interfacciaprofileMyDetails.fxml"));
            Parent root=fxmlLoader.load();

            //crea uno stage per la nuova pagina
            Stage stage= new Stage();
            stage.setScene((new Scene(root)));

            //mostra la pagina caricata nellos stage
            stage.show();

            //chiudi la vista di com.example.progetto_ispw.login
            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();


        } catch(IOException e){
            e.printStackTrace();
        }

    }

    public void changePasswordMethod(ActionEvent actionEvent) {//da implementare
    }

    public void addressesMethod(ActionEvent actionEvent) {//da implementare
    }

    public void needHelpMethod(ActionEvent actionEvent) {//da implementare
    }

    public void exitMethod(ActionEvent actionEvent) {//da implementare
    }


    public void preCompileUser( String namesearch, String surnamesearch, String emailsearch) {
        this.nameLabelUserProfile.setText(namesearch);
        this.surnameLabelUserProfile.setText(surnamesearch);
        this.emailLabelUserProfile.setText(emailsearch);

    }
    // prova come dice pamela per scrivere da qui


}
