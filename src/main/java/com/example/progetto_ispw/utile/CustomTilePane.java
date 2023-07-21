package com.example.progetto_ispw.utile;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.security.cert.PolicyNode;

public class CustomTilePane {
        AnchorPane entryPane;
        TilePane customTP;
        VBox resultsBox;
        public void addElements( String name, String job, String location, String description,Button selectButton){
            AnchorPane entryPane = new AnchorPane();
            selectButton.setPrefWidth(190);
            selectButton.setPrefHeight(56);
            AnchorPane.setRightAnchor(selectButton, 50.0);
            AnchorPane.setTopAnchor(selectButton, 150.0);

            Label textLabel1= new Label("Name: "+ name);
            AnchorPane.setLeftAnchor(textLabel1, 50.0);
            AnchorPane.setTopAnchor(textLabel1, 25.0);


            Label textLabel2= new Label("Lavoro: "+ job);
            AnchorPane.setLeftAnchor(textLabel2, 50.0);
            AnchorPane.setTopAnchor(textLabel2, 55.0);


            Label textLabel3= new Label("Località: "+ location);
            AnchorPane.setLeftAnchor(textLabel3, 50.0);
            AnchorPane.setTopAnchor(textLabel3, 85.0);


            Label textLabel4 =new Label("Descrizione: "+ description);
            AnchorPane.setLeftAnchor(textLabel4, 50.0);
            AnchorPane.setTopAnchor(textLabel4, 115.0);

            entryPane.getChildren().addAll(selectButton, textLabel1, textLabel2, textLabel3, textLabel4);

            resultsBox = new VBox(); // Creazione del VBox per contenere i risultati
            resultsBox.setPrefWidth(1180); // Imposta la larghezza desiderata per il VBox dei risultati
            resultsBox.setPrefHeight(225); // Imposta l'altezza desiderata per il VBox dei risultati
            resultsBox.setSpacing(50); // Imposta lo spazio tra gli elementi all'interno del VBox dei risultati
            resultsBox.setStyle("-fx-border-color: #74c69d; -fx-border-radius: 10;");


            customTP.getChildren().add(resultsBox); // Aggiunta del VBox dei risultati al TilePane
            resultsBox.getChildren().add(entryPane);

        }

        public void createCustomTilePane(){
            customTP= new TilePane();
            customTP.setPrefColumns(7);
            customTP.setPrefWidth(1180); // Imposta la larghezza desiderata per il TilePane
            customTP.setPrefHeight(6000); // Imposta l'altezza desiderata per il TilePane
            customTP.setVgap(15); // Imposta uno spazio di 10 pixel tra le righe
            customTP.setPadding(new Insets(10)); // Imposta uno spazio di 10 pixel intorno al TilePane

        }
    public TilePane getCustomTP(){return customTP;}
}
