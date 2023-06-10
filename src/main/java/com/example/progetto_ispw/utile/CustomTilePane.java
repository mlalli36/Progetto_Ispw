package com.example.progetto_ispw.utile;

import javafx.scene.layout.TilePane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


import java.awt.*;

public class CustomTilePane {
        TilePane customTP;

        public void addElements(Button selectButton, String name, String surname, String address, String description){
            selectButton.setPrefSize(190,56);
            Label textLabel1= new Label(name);
            Label textLabel2= new Label(surname);
            Label textLabel3= new Label(address);
            Label textLabel4= new Label(description);
            customTP.getChildren().addAll(textLabel1,textLabel2,textLabel3,textLabel4,selectButton);
        }

        public void createCustomTilePane(){
            customTP= new TilePane();
            customTP.setPrefColumns(4);
        }
    public TilePane getCustomTP(){return customTP;}
}
