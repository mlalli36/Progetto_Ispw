package com.example.progetto_ispw.acceptAppointment;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class AcceptTilePane {
    TilePane acceptTP;
    VBox resultsBox;

    public void addElements(String name_client, String surname_client, String email_client, String description_work, String phone_client, String date_work, String time_work){

        AnchorPane entryPane = new AnchorPane();




        Label textLabel1= new Label("NAME: "+ name_client);
        AnchorPane.setLeftAnchor(textLabel1, 10.0);
        AnchorPane.setTopAnchor(textLabel1, 10.0);


        Label textLabel2= new Label("SURNAME: "+ surname_client);
        AnchorPane.setLeftAnchor(textLabel2, 10.0);
        AnchorPane.setTopAnchor(textLabel2, 40.0);


        Label textLabel3= new Label("EMAIL CLIENT: "+ email_client);
        AnchorPane.setLeftAnchor(textLabel3, 10.0);
        AnchorPane.setTopAnchor(textLabel3, 70.0);


        Label textLabel4 =new Label("DESCRIPTION CLIENT: "+ description_work);
        AnchorPane.setLeftAnchor(textLabel4, 10.0);
        AnchorPane.setTopAnchor(textLabel4, 100.0);

        Label textLabel5 =new Label("PHONE CLIENT: "+ phone_client);
        AnchorPane.setLeftAnchor(textLabel5, 10.0);
        AnchorPane.setTopAnchor(textLabel5, 130.0);

        Label textLabel6 =new Label("DATE APPOINTMENT: "+ date_work);
        AnchorPane.setLeftAnchor(textLabel6, 10.0);
        AnchorPane.setTopAnchor(textLabel6, 160.0);

        Label textLabel7 =new Label("TIME APPOINTMENT: "+ time_work);
        AnchorPane.setLeftAnchor(textLabel7, 10.0);
        AnchorPane.setTopAnchor(textLabel7, 190.0);

        entryPane.getChildren().addAll(textLabel1, textLabel2, textLabel3, textLabel4, textLabel5,textLabel6,textLabel7);

        resultsBox = new VBox();
        resultsBox.setPrefWidth(700);
        resultsBox.setPrefHeight(100);
        resultsBox.setSpacing(50);
        resultsBox.setStyle("-fx-border-color: #74c69d; -fx-border-radius: 10;  ");


        acceptTP.getChildren().add(resultsBox); // Aggiunta del VBox dei risultati al TilePane
        resultsBox.getChildren().add(entryPane);

    }

    public  void createAcceptTilePane(){
        acceptTP= new TilePane();
        acceptTP.setPrefColumns(7);
        acceptTP.setPrefWidth(700); // Imposta la larghezza desiderata per il TilePane
        acceptTP.setPrefHeight(600); // Imposta l'altezza desiderata per il TilePane
        acceptTP.setVgap(15); // Imposta uno spazio di 10 pixel tra le righe
        acceptTP.setPadding(new Insets(10)); // Imposta uno spazio di 10 pixel intorno al TilePane

    }

    public TilePane getAcceptTP(){return acceptTP;}


}
