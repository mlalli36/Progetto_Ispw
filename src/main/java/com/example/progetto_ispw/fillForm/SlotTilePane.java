package com.example.progetto_ispw.fillForm;

import com.example.progetto_ispw.saveHoursSlots.SlotHoursEntity;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;


public class SlotTilePane {
    AnchorPane entryPane;
    TilePane slotTP;
    VBox resultsBox;


    public void addElements(CheckBox check1, String slot1, String slot2, String slot3, String slot4, String slot5) {
        AnchorPane entryPane = new AnchorPane();


        CheckBox checkBoxS1 = new CheckBox();
        CheckBox checkBoxS2 = new CheckBox();
        CheckBox checkBoxS3 = new CheckBox();
        CheckBox checkBoxS4 = new CheckBox();
        CheckBox checkBoxS5 = new CheckBox();


        Label textLabel1 = new Label("Slot1: " + slot1);
        AnchorPane.setLeftAnchor(textLabel1, 50.0);
        AnchorPane.setTopAnchor(textLabel1, 25.0);

        Label textLabel2 = new Label("Slot2: " + slot2);
        AnchorPane.setLeftAnchor(textLabel2, 200.0);
        AnchorPane.setTopAnchor(textLabel2, 25.0);

        Label textLabel3 = new Label("Slot3: " + slot3);
        AnchorPane.setLeftAnchor(textLabel3, 350.0);
        AnchorPane.setTopAnchor(textLabel3, 25.0);

        Label textLabel4 = new Label("Slot4: " + slot4);
        AnchorPane.setLeftAnchor(textLabel4, 500.0);
        AnchorPane.setTopAnchor(textLabel4, 25.0);

        Label textLabel5 = new Label("Slot5: " + slot5);
        AnchorPane.setLeftAnchor(textLabel5, 650.0);
        AnchorPane.setTopAnchor(textLabel5, 25.0);

        check1.setOpacity(1);
        //checkbox per lo slot1
        AnchorPane.setRightAnchor(checkBoxS1, 900.0);
        AnchorPane.setTopAnchor(checkBoxS1, 25.0); // Puoi regolare la posizione in base alle tue esigenze.
        //checkbox per lo slot2
        AnchorPane.setRightAnchor(checkBoxS2, 750.0);
        AnchorPane.setTopAnchor(checkBoxS2, 25.0);
        //checkbox per lo slot3
        AnchorPane.setRightAnchor(checkBoxS3, 590.0);
        AnchorPane.setTopAnchor(checkBoxS3, 25.0);
        //checkbox per lo slot4
        AnchorPane.setRightAnchor(checkBoxS4, 440.0);
        AnchorPane.setTopAnchor(checkBoxS4, 25.0);
        //checkbox per lo slot5
        AnchorPane.setRightAnchor(checkBoxS5, 300.0);
        AnchorPane.setTopAnchor(checkBoxS5, 25.0);

        entryPane.getChildren().addAll(checkBoxS1, checkBoxS2, checkBoxS3, checkBoxS4, checkBoxS5, textLabel1, textLabel2, textLabel3, textLabel4, textLabel5);


        resultsBox = new VBox(); // Creazione del VBox per contenere i risultati
        resultsBox.setPrefWidth(1049); // Imposta la larghezza desiderata per il VBox dei risultati
        resultsBox.setPrefHeight(60); // Imposta l'altezza desiderata per il VBox dei risultati
        resultsBox.setSpacing(10); // Imposta lo spazio tra gli elementi all'interno del VBox dei risultati
        resultsBox.setStyle("-fx-border-color: #74c69d; -fx-border-radius: 10;");


        slotTP.getChildren().add(resultsBox); // Aggiunta del VBox dei risultati al TilePane
        resultsBox.getChildren().add(entryPane);

        if(check1.isSelected()){
            SlotHoursEntity sh= SlotHoursEntity.getInstance();
            sh.setAppointment(slot1);
        }


    }


    public void createSlotTilePane(){
        slotTP= new TilePane();
        slotTP.setPrefColumns(7);
        slotTP.setPrefWidth(700/*1049*/); // Imposta la larghezza desiderata per il TilePane
        slotTP.setPrefHeight(10/*121*/); // Imposta l'altezza desiderata per il TilePane
        slotTP.setVgap(10);        // Imposta uno spazio di 10 pixel tra le righe
        slotTP.setPadding(new Insets(10)); // Imposta uno spazio di 10 pixel intorno al TilePane

    }
    public TilePane getSlotTP(){return slotTP;}

}
