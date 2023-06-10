package com.example.progetto_ispw.searchDinamica;


import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.home.ResultElement;
import com.example.progetto_ispw.home.ResultSetEntity; //vedere se è giusto
import com.example.progetto_ispw.utile.CustomTilePane;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;


public class SearchDinamicaView {
    @FXML
    public Button profile;
    @FXML
    public Button favorites;
    @FXML
    public Button home;

    @FXML
    public Button fillOutForm;
    @FXML
    public VBox myVBox;
    @FXML
    public Pane paneDinamico;
    @FXML
    public ScrollPane scrollPane;


    public void profileMethod(ActionEvent actionEvent) { //da fare
    }

    public void favoritesMethod(ActionEvent actionEvent) { //da fare
    }

    public void homeMethod(ActionEvent actionEvent) { //da fare
    }


    public void showResult(SearchDinamicaBean bean) {

        ResultSetEntity resultSet= bean.getResultSet();
        scrollPane.setVisible(true);

        CustomTilePane customTilePane = new CustomTilePane();
        customTilePane.createCustomTilePane();

        for(ResultElement r: resultSet.getElements()){
             Button newButton= new Button("Fill out form.");
             String workerName= r.getWorkerName();
             String workerSurname= r.getWorkerSurname();
             String workerAddress= r.getWorkerAddress();
             String workerDescription= r.getWorkerDescription();
             newButton.setOnAction(event -> {
                 try {
                     showFORM();
                 } catch (IOException e) {
                     throw new RuntimeException(e);
                 }
             });

        }









 }

    private void showFORM() throws IOException {
        UIController viewController = UIController.getUIControllerInstance();//è singletone

        viewController.showForm();
    }
}






