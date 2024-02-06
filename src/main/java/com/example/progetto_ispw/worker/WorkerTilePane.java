package com.example.progetto_ispw.worker;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class WorkerTilePane {
    AnchorPane entryPane;

     TilePane workerTP;
    VBox resultsBox;

    public void addElements(Button  accepttButton,Button rejectButton, String name_client, String surname_client, String email_client, String description_work,String phone_client,String date_work, String time_work){

        AnchorPane entryPane = new AnchorPane();


         accepttButton.setPrefWidth(150);
        accepttButton.setPrefHeight(50);
        AnchorPane.setRightAnchor(accepttButton, 25.0);
        AnchorPane.setTopAnchor(accepttButton, 150.0);


        rejectButton.setPrefWidth(150);
        rejectButton.setPrefHeight(50);
        AnchorPane.setRightAnchor(rejectButton, 25.0);
        AnchorPane.setTopAnchor(rejectButton, 80.0);

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

        entryPane.getChildren().addAll(accepttButton,rejectButton, textLabel1, textLabel2, textLabel3, textLabel4, textLabel5,textLabel6,textLabel7);

        resultsBox = new VBox();
        resultsBox.setPrefWidth(700);
        resultsBox.setPrefHeight(100);
        resultsBox.setSpacing(50);
        resultsBox.setStyle("-fx-border-color: #74c69d; -fx-border-radius: 10;  ");


        workerTP.getChildren().add(resultsBox); // Aggiunta del VBox dei risultati al TilePane
        resultsBox.getChildren().add(entryPane);

    }

    public  void createWorkerTilePane(){
        workerTP= new TilePane();
        workerTP.setPrefColumns(7);
        workerTP.setPrefWidth(700);
        workerTP.setPrefHeight(600);
        workerTP.setVgap(15);
        workerTP.setPadding(new Insets(10));

    }

    public TilePane getWorkerTP(){return workerTP;}


}
