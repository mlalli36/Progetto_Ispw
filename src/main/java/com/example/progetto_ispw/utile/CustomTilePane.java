package com.example.progetto_ispw.utile;

import javafx.scene.layout.TilePane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CustomTilePane {
        TilePane customTP;

        public void addElements(Button selectButton, String name, String job, String location){
            selectButton.setPrefSize(190,56);
            Label textLabel1= new Label(name);
            Label textLabel2= new Label(job);
            Label textLabel3= new Label(location);

            customTP.getChildren().addAll(selectButton, textLabel1,textLabel2,textLabel3);
        }

        public void createCustomTilePane(){
            customTP= new TilePane();
            customTP.setPrefColumns(4);
            customTP.setPrefWidth(800); // Imposta la larghezza desiderata per il TilePane
            customTP.setPrefHeight(200); // Imposta l'altezza desiderata per il TilePane

        }
    public TilePane getCustomTP(){return customTP;}
}
