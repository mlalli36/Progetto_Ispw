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
        public void addElements( String name, String job, String location, String description,Button selectButton, String emailWorker){
            AnchorPane entryPane = new AnchorPane();
            selectButton.setPrefWidth(190);
            selectButton.setPrefHeight(56);
            selectButton.setStyle("-fx-background-color: #74c69d;");

            AnchorPane.setRightAnchor(selectButton, 50.0);
            AnchorPane.setTopAnchor(selectButton, 150.0);

            Label textLabel1= new Label("NAME: "+ name);
            AnchorPane.setLeftAnchor(textLabel1, 50.0);
            AnchorPane.setTopAnchor(textLabel1, 25.0);


            Label textLabel2= new Label("WORK: "+ job);
            AnchorPane.setLeftAnchor(textLabel2, 50.0);
            AnchorPane.setTopAnchor(textLabel2, 55.0);


            Label textLabel3= new Label("LOCATION: "+ location);
            AnchorPane.setLeftAnchor(textLabel3, 50.0);
            AnchorPane.setTopAnchor(textLabel3, 85.0);


            Label textLabel4 =new Label("DESCRIPTION: "+ description);
            AnchorPane.setLeftAnchor(textLabel4, 50.0);
            AnchorPane.setTopAnchor(textLabel4, 115.0);

            Label textLabel5 =new Label("WORKER EMAIL: "+ emailWorker);
            AnchorPane.setLeftAnchor(textLabel5, 50.0);
            AnchorPane.setTopAnchor(textLabel5, 145.0);

            entryPane.getChildren().addAll(selectButton, textLabel1, textLabel2, textLabel3, textLabel4, textLabel5);

            resultsBox = new VBox();
            resultsBox.setPrefWidth(1180);
            resultsBox.setPrefHeight(225);
            resultsBox.setSpacing(50);
            resultsBox.setStyle("-fx-border-color: #74c69d; -fx-border-radius: 10;");


            customTP.getChildren().add(resultsBox);
            resultsBox.getChildren().add(entryPane);

        }

        public void createCustomTilePane(){
            customTP= new TilePane();
            customTP.setPrefColumns(7);
            customTP.setPrefWidth(1180);
            customTP.setPrefHeight(6000);
            customTP.setVgap(15);
            customTP.setPadding(new Insets(10));

        }
    public TilePane getCustomTP(){return customTP;}
}
