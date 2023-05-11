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

public class HomeView  {
    @FXML
    public AnchorPane anchorPaneHome;
    @FXML
    public Button plumbers;
    @FXML
    public Button seeMore;
    @FXML
    public Button hairdressers;
    @FXML
    public Button electricians;
    @FXML
    public Button painters;
    @FXML
    public Button beauticians;
    @FXML
    public Button profile;
    @FXML
    public Button favorites;
    @FXML
    public Button home;

    public void plumbersMethod(ActionEvent actionEvent) {
        try{
            //caricare la nuova pagina
            FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("interfacciaSearch Dinamica.fxml")));
            Parent root = fxmlLoader.load();

            //Crea uno stage per la nuova pagina
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            // mostra la pagina caricata nello stage
            stage.show();

            //Chiudi la pagina del login
            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void seeMoreMethod(ActionEvent actionEvent) {
        //da implementare

    }

    public void hairdressersMethod(ActionEvent actionEvent) {
        //da implementare
    }

    public void electriciansMethod(ActionEvent actionEvent) {
        //da implementare
    }

    public void paintersMethod(ActionEvent actionEvent) {
        //da implementare
    }

    public void beauticiansMethod(ActionEvent actionEvent) {
        //da implementare
    }

    public void profileMethod(ActionEvent actionEvent) {
        try{//crea pagina nuova
            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("ProfileView.fxml"));
            Parent root = fxmlLoader.load();

            //crea uno stage per la nuova pagina
            Stage stage=new Stage();
            stage.setScene(new Scene(root));

            //chiudi la pagina precedente
            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void favoritesMethod(ActionEvent actionEvent) {//da implementare
    }

    public void homeMethod(ActionEvent actionEvent) {  try{
        //crea pagina nuova
        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("interfacciaprofile.fxml"));
        Parent root=fxmlLoader.load();

        //crea uno stage per la nuova pagina
        Stage stage= new Stage();
        stage.setScene((new Scene(root)));

        //mostra la pagina caricata nellos stage
        stage.show();

        //chiudi la vista di login
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();


    } catch(IOException e){
        e.printStackTrace();
    }
    }
}
