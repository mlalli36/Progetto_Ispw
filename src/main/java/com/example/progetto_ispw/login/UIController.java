package com.example.progetto_ispw.login;

import com.example.progetto_ispw.SignUpView;
import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

public class UIController {


    private static UIController singleUIControllerInstance = null;

    private Stage stage;
   private String[] previousStageStyles;  //tiene traccia del file .fxml ( previousStageStyle[0] e di quello .css (previousStageSyle[1])
                                         //della schermata precedente, per poterli usare in caso di pulsante back
                                        //con static non va
    private UIController(){} // Singleton GoF Pattern applicato to UIController

    public static UIController getUIControllerInstance() {
        if(UIController.singleUIControllerInstance == null){
            UIController.singleUIControllerInstance = new UIController();
        }
        return UIController.singleUIControllerInstance;
    }

    public void showHome() throws IOException{//mostra a schermo la home
        this.loadStage("interfacciaHome.fxml","home.css");
    }

    public void showNotificheDaCliente() throws IOException{//mostra le notifiche da cliente
        this.loadStage("interfaccia notifica da cliente.fxml" , " notificaDaCliente.css" );
    }

    public void showProfileRecensione() throws IOException{//mostra il profilo sulla sezione recensione
        this.loadStage("interfaccia profilerecensione.fxml","recensione.css");
    }

    public void showForm() throws IOException{//mostra il form
        this.loadStage("interfacciaForm.fxml","form.css");
    }

    public void showProfileMyDetails() throws IOException{//mostra i dettagli del proprio profilo
        this.loadStage("interfacciaprofileMyDetails.fxml","profileMyDetails.css");
    }

    public void showProfiloDinamica() throws  IOException{//mostra il profilo
        this.loadStage("interfacciaprofilodinamica.fxml","profileMyDetails.css");
    }

    public void showSearchDinamica() throws IOException{//mostra la schermata di search
        this.loadStage("interfacciaSearch Dinamica.fxml", "search.css");
    }

    private void loadStage(String stageFXML, String stageCSS) throws IOException { //mostra a schermo la schermata passato con i parametri
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(stageFXML));
        Parent root1 = fxmlLoader.load();
        root1.getStylesheets().add(Objects.requireNonNull(getClass().getResource(stageCSS)).toExternalForm());

        this.fadeAnimation(root1, this.stage.getScene().getRoot());

        this.stage.setScene(new Scene(root1));
    }
    public String getPreviousFxml(){
        return  previousStageStyles[0];
    }

    public String getPreviousCss(){
        return  previousStageStyles[1];
    }

    private void fadeAnimation(Parent screenToFadeIn, Parent screenToFadeOut){//Metodo privato perchè deve essere utilizzato
        this.fadeOut(screenToFadeOut);                                        // solo in loadStage
        this.fadeIn(screenToFadeIn);
    }

    private void fadeOut(Parent root){
        FadeTransition ft = new FadeTransition(Duration.millis(300), root); //Metodo privato perchè deve essere utilizzato
        ft.setFromValue(1.0);                                               // solo in fadeAnimation
        ft.setToValue(0);
        ft.play();
    }

    private void fadeIn(Parent root){
        FadeTransition ft = new FadeTransition(Duration.millis(300), root); //Metodo privato perchè deve essere utilizzato
        ft.setFromValue(0);                                                 // solo in fadeAnimation
        ft.setToValue(1.0);
        ft.play();
    }
    public void setStage(Stage stage){
        this.stage = stage;
    }
    public void precompileSignUp(String email, String password) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interfaccia SignUp.fxml"));
        Parent root1 = fxmlLoader.load();
        root1.getStylesheets().add(Objects.requireNonNull(getClass().getResource("login.css")).toExternalForm());
        SignUpView signUpView = fxmlLoader.getController();
        signUpView.preCompile(email, password);

        this.fadeAnimation(root1, this.stage.getScene().getRoot());

        this.stage.setScene(new Scene(root1));

    }

    public void setPreviousStageStyles(String[] previousStageStyles) {
        this.previousStageStyles = previousStageStyles;
    }
}

