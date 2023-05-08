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
    public AnchorPane AnchorPaneSearch;
    @FXML
    public Button Profile;
    @FXML
    public Button Favorites;
    @FXML
    public Button Home;
    @FXML
    public Button FillOutForm1;
    @FXML
    public Button FillOutForm2;

    public void ProfileMethod(ActionEvent actionEvent) {
        // TODO document why this method is empty
    }

    public void FavoritesMethod(ActionEvent actionEvent) {
        // TODO document why this method is empty
    }

    public void HomeMethod(ActionEvent actionEvent) {
        // TODO document why this method is empty
    }

    public void FillOutFormMethod(ActionEvent actionEvent) {
       try {


            //crea pagina nuova
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interfacciaForm.fxml"));
            Parent root = fxmlLoader.load();

            //Crea uno stage per la nuova pagina
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            //Chiudi la vista di login
            ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
