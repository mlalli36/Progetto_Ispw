package com.example.progetto_ispw;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class StartApp2 extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApp.class.getResource("login2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("WORKER-LINK");
        stage.setScene(scene);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("Login.css")).toExternalForm());

        UIController viewController = UIController.getUIControllerInstance();
        viewController.setStage(stage);

        stage.show();
    }
// c'è un problema di percorso per trovare la schermata dice chatgpt

    public static void main(String[] args) {
        launch();
    }
}
