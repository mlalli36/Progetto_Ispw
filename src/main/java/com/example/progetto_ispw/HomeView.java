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
    public AnchorPane AnchorPaneHome;
    @FXML
    public Button Plumbers;
    @FXML
    public Button seeMore;
    @FXML
    public Button Hairdressers;
    @FXML
    public Button Electricians;
    @FXML
    public Button Painters;
    @FXML
    public Button Beauticians;

    public void PlumbersMethod(ActionEvent actionEvent) {
        try{
            //caricare la nuova pagina
            FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("interfacciaSearch.fxml")));
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

    public void SeeMoreMethod(ActionEvent actionEvent) {

    }

    public void HairdressersMethod(ActionEvent actionEvent) {
    }

    public void ElectriciansMethod(ActionEvent actionEvent) {
    }

    public void PaintersMethod(ActionEvent actionEvent) {
    }

    public void BeauticiansMethod(ActionEvent actionEvent) {
    }
}
