package com.example.progetto_ispw;


import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


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

    //da riga 27 a riga 42 serve per mostrare o non mostrare il box del "fillOutForm"
    private final BooleanProperty showBox = new SimpleBooleanProperty(false);


    public BooleanProperty showBoxProperty() {
        return showBox;
    }
    public boolean isShowBox() {
        return showBox.get();
    }
    public void setShowBox(boolean value) {
        showBox.set(value);
    }
    public void initialize() {
        myVBox.visibleProperty().bind(showBox);
        setShowBox(true); //se è true mostra il box, se è false non lo mostra
    }

    public void profileMethod(ActionEvent actionEvent) { //da fare
    }

    public void favoritesMethod(ActionEvent actionEvent) { //da fare
    }

    public void homeMethod(ActionEvent actionEvent) { //da fare
    }


}






