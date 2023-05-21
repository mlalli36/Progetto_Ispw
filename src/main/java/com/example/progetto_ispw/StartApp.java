package com.example.progetto_ispw;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApp.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Mi offro.");
        stage.setScene(scene);
        stage.show();
    }
// c'è un problema di percorso per trovare la schermata dice chatgpt

    public static void main(String[] args) {
        launch();
    }
}