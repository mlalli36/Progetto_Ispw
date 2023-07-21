package com.example.progetto_ispw.fillForm;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class SlotTilePane {
    AnchorPane entryPane;
    TilePane slotTP;
    VBox resultsBox;


    public void addElements(String slot1, String slot2, String slot3, String slot4, String slot5) {
        AnchorPane entryPane = new AnchorPane();



            CheckBox checkBox = new CheckBox();
            checkBox.setPrefWidth(50);
            checkBox.setPrefHeight(50);

           Label textLabel1= new Label("Slot1: "+ slot1);
           AnchorPane.setLeftAnchor(textLabel1, 50.0);
           AnchorPane.setTopAnchor(textLabel1, 25.0);

        Label textLabel2= new Label("Slot2: "+ slot2);
        AnchorPane.setLeftAnchor(textLabel1, 100.0);
        AnchorPane.setTopAnchor(textLabel1, 25.0);

        Label textLabel3= new Label("Slot3: "+ slot3);
        AnchorPane.setLeftAnchor(textLabel1, 150.0);
        AnchorPane.setTopAnchor(textLabel1, 25.0);

        Label textLabel4= new Label("Slot4: "+ slot4);
        AnchorPane.setLeftAnchor(textLabel1, 200.0);
        AnchorPane.setTopAnchor(textLabel1, 25.0);

        Label textLabel5= new Label("Slot5: "+ slot5);
        AnchorPane.setLeftAnchor(textLabel1, 250.0);
        AnchorPane.setTopAnchor(textLabel1, 25.0);


        AnchorPane.setRightAnchor(checkBox, 50.0);
           AnchorPane.setTopAnchor(checkBox, 200.0); // Puoi regolare la posizione in base alle tue esigenze.

            entryPane.getChildren().addAll(checkBox, textLabel1,textLabel2,textLabel3,textLabel4,textLabel5);


            resultsBox = new VBox(); // Creazione del VBox per contenere i risultati
        resultsBox.setPrefWidth(1180); // Imposta la larghezza desiderata per il VBox dei risultati
        resultsBox.setPrefHeight(225); // Imposta l'altezza desiderata per il VBox dei risultati
        resultsBox.setSpacing(50); // Imposta lo spazio tra gli elementi all'interno del VBox dei risultati
        resultsBox.setStyle("-fx-border-color: #74c69d; -fx-border-radius: 10;");


        slotTP.getChildren().add(resultsBox); // Aggiunta del VBox dei risultati al TilePane
        resultsBox.getChildren().add(entryPane);


    }


    public void createSlotTilePane(){
        slotTP= new TilePane();
        slotTP.setPrefColumns(7);
        slotTP.setPrefWidth(1049); // Imposta la larghezza desiderata per il TilePane
        slotTP.setPrefHeight(121); // Imposta l'altezza desiderata per il TilePane
        slotTP.setVgap(10); // Imposta uno spazio di 10 pixel tra le righe
        slotTP.setPadding(new Insets(10)); // Imposta uno spazio di 10 pixel intorno al TilePane

    }
    public TilePane getSlotTP(){return slotTP;}

}
