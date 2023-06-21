package com.example.progetto_ispw.utile;

import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.security.cert.PolicyNode;

public class CustomTilePane {
        TilePane customTP;
        VBox resultsBox;
        public void addElements( String name, String job, String location, String description,Button selectButton){
            AnchorPane entryPane = new AnchorPane();
            VBox entryBox = new VBox(); // Creazione del VBox per ogni elemento
            selectButton.setPrefWidth(190);
            selectButton.setPrefHeight(56);
            selectButton.setLayoutX(772);
            selectButton.setLayoutY(155);
            selectButton.setStyle("-fx-background-color: #74c69d;");
            selectButton.setStyle("-fx-background-radius:10;");
            selectButton.setFont(new Font("Bookman Old Style", 20));
            AnchorPane.setRightAnchor(selectButton, 190.0);
            AnchorPane.setTopAnchor(selectButton, 56.0);

            Label textLabel1= new Label(name);
            AnchorPane.setLeftAnchor(textLabel1, 10.0);
            AnchorPane.setTopAnchor(textLabel1, 10.0);
            textLabel1.setFont(Font.font("Bookman Old Style", 16.5));

            Label textLabel2= new Label(job);
            AnchorPane.setLeftAnchor(textLabel2, 10.0);
            AnchorPane.setTopAnchor(textLabel2, 40.0);
            textLabel2.setFont(Font.font("Bookman Old Style", 16.5));

            Label textLabel3= new Label(location);
            AnchorPane.setLeftAnchor(textLabel3, 10.0);
            AnchorPane.setTopAnchor(textLabel3, 70.0);
            textLabel3.setFont(Font.font("Bookman Old Style", 16.5));

            Label textLabel4 =new Label(description);
            AnchorPane.setLeftAnchor(textLabel4, 10.0);
            AnchorPane.setTopAnchor(textLabel4, 100.0);
            textLabel4.setFont(Font.font("Bookman Old Style", 16.5));



            entryPane.getChildren().addAll(selectButton, textLabel1, textLabel2, textLabel3, textLabel4);
            resultsBox.getChildren().add(entryPane);

            //customTP.getChildren().addAll( textLabel1,textLabel2,textLabel3,textLabel4,selectButton);
        }

        public void createCustomTilePane(){
            customTP= new TilePane();
            customTP.setPrefColumns(7);
            customTP.setPrefWidth(1000); // Imposta la larghezza desiderata per il TilePane
            customTP.setPrefHeight(6000); // Imposta l'altezza desiderata per il TilePane
            customTP.setVgap(15); // Imposta uno spazio di 10 pixel tra le righe
            customTP.setPadding(new Insets(10)); // Imposta uno spazio di 10 pixel intorno al TilePane
            resultsBox = new VBox(); // Creazione del VBox per contenere i risultati
            //o questa parte di codice la metto qui o in addELements, teoricamente fa sempre la stessa cosa
            resultsBox.setPrefWidth(1100); // Imposta la larghezza desiderata per il VBox dei risultati
            resultsBox.setPrefHeight(225); // Imposta l'altezza desiderata per il VBox dei risultati
            resultsBox.setSpacing(50); // Imposta lo spazio tra gli elementi all'interno del VBox dei risultati
            resultsBox.setLayoutX(160);
            resultsBox.setLayoutY(70);
            //fino a qui
            resultsBox.setStyle("-fx-border-color: #74c69d; -fx-border-radius: 10;");
            customTP.getChildren().add(resultsBox); // Aggiunta del VBox dei risultati al TilePane
        }
    public TilePane getCustomTP(){return customTP;}
}
