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

public class SearchView {
    @FXML
    public AnchorPane anchorPaneSearch;
    @FXML
    public Button profile;
    @FXML
    public Button favorites;
    @FXML
    public Button home;
    @FXML
    public Button fillOutForm;


    public void profileMethod(ActionEvent actionEvent) {
      /*  try{
            //crea pagina nuova
            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("interfacciaUserProfile.fxml"));
            Parent root=fxmlLoader.load();

            //crea uno stage per la nuova pagina
            Stage stage= new Stage();
            stage.setScene(new Scene(root));

            //mostra la pagina caricata nellos stage
            stage.show();

            //chiudi la vista di com.example.progetto_ispw.login
            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();


        } catch(IOException e){
            e.printStackTrace();
        }*/ // commentato sennò mi diceva che c'era un pezzo di codice duplicato, in HomeView modifica 03/06/23
    }

    public void favoritesMethod(ActionEvent actionEvent) {//da implementare
    }

    public void homeMethod(ActionEvent actionEvent) {//da implementare
    }

    public void fillOutFormMethod(ActionEvent actionEvent) {
       try {


            //crea pagina nuova
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interfacciaForm.fxml"));
            Parent root = fxmlLoader.load();

            //Crea uno stage per la nuova pagina
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            //mostra la pagina caricata nello stage
            stage.show();

            //Chiudi la vista di com.example.progetto_ispw.login
            ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
