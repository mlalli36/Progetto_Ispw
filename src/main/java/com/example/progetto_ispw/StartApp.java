package com.example.progetto_ispw;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class StartApp extends Application {
    private boolean useLoginInterface = true; // Imposta su true per avviare l'interfaccia di login, false per avviare un'altra interfaccia

    @Override
    public void start(Stage stage) throws IOException {
        if (useLoginInterface) {
            FXMLLoader fxmlLoader = new FXMLLoader(StartApp.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("WORKER-LINK - Login");
            stage.setScene(scene);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("login.css")).toExternalForm());
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(StartApp.class.getResource("login2.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("WORKER-LINK - Second Interface");
            stage.setScene(scene);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("login.css")).toExternalForm());
        }

        UIController viewController = UIController.getUIControllerInstance();
        viewController.setStage(stage);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
 /*   @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApp.class.getResource("login.fxml"));
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
    }*/
}