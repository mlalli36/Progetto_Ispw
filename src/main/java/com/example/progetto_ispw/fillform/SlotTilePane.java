package com.example.progetto_ispw.fillform;

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


    public void addElements(CheckBox check1,CheckBox check2,CheckBox check3,CheckBox check4,CheckBox check5, String slot1, String slot2, String slot3, String slot4, String slot5) {
        AnchorPane entryPane = new AnchorPane();

        Label textLabel1 = new Label("      " + slot1);
        AnchorPane.setLeftAnchor(textLabel1, 50.0);
        AnchorPane.setTopAnchor(textLabel1, 25.0);

        Label textLabel2 = new Label("      " + slot2);
        AnchorPane.setLeftAnchor(textLabel2, 200.0);
        AnchorPane.setTopAnchor(textLabel2, 25.0);

        Label textLabel3 = new Label("      " + slot3);
        AnchorPane.setLeftAnchor(textLabel3, 350.0);
        AnchorPane.setTopAnchor(textLabel3, 25.0);

        Label textLabel4 = new Label("      " + slot4);
        AnchorPane.setLeftAnchor(textLabel4, 500.0);
        AnchorPane.setTopAnchor(textLabel4, 25.0);

        Label textLabel5 = new Label("      " + slot5);
        AnchorPane.setLeftAnchor(textLabel5, 650.0);
        AnchorPane.setTopAnchor(textLabel5, 25.0);

        check1.setOpacity(1);
        check2.setOpacity(1);
        check3.setOpacity(1);
        check4.setOpacity(1);
        check5.setOpacity(1);

        entryPane.getChildren().addAll(textLabel1, textLabel2, textLabel3, textLabel4, textLabel5);


        resultsBox = new VBox();
        resultsBox.setPrefWidth(1049);
        resultsBox.setPrefHeight(60);
        resultsBox.setSpacing(10);
        resultsBox.setStyle("-fx-border-color: #74c69d; -fx-border-radius: 10;");


        slotTP.getChildren().add(resultsBox);
        resultsBox.getChildren().add(entryPane);


    }


    public void createSlotTilePane(){
        slotTP= new TilePane();
        slotTP.setPrefColumns(7);
        slotTP.setPrefWidth(700 );
        slotTP.setPrefHeight(10 );
        slotTP.setVgap(10);
        slotTP.setPadding(new Insets(10));

    }
    public TilePane getSlotTP(){return slotTP;}

}
