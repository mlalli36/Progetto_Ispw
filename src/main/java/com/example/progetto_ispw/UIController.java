package com.example.progetto_ispw;

import com.example.progetto_ispw.fillform.FillFormView;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.profilesignup.ProfileSignUpView;
import com.example.progetto_ispw.savehoursslots.SlotHoursView;
import com.example.progetto_ispw.searchdinamica.SearchDinamicaBean;
import com.example.progetto_ispw.searchdinamica.SearchDinamicaController;
import com.example.progetto_ispw.searchdinamica.SearchDinamicaView;
import com.example.progetto_ispw.signup.SignUpView;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.userprofile.UserProfileView;
import com.example.progetto_ispw.workerprofile.WorkerProfileView;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.AccessibleAction;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

public class UIController {



    private static UIController singleUIControllerInstance = null;

    private Stage stage;
    private String[] previousStageStyles;
    //tiene traccia del file .fxml ( previousStageStyle[0] e di quello .css (previousStageSyle[1])
    //della schermata precedente, per poterli usare in caso di pulsante back
    //con static non va
    private UIController(){} // Singleton GoF Pattern applicato to UIController

    public static UIController getUIControllerInstance() {
        if(UIController.singleUIControllerInstance == null){
            UIController.singleUIControllerInstance = new UIController();
        }
        return UIController.singleUIControllerInstance;
    }

    public void showHome() throws IOException{//mostra a schermo la com.example.progetto_ispw.home
        this.loadStage("interfacciaHome.fxml","home.css" );
    }

    public void showLogin() throws IOException {//mostra la schermata login, la invoco dopo la registrazione
        this.loadStage("login.fxml","login.css");
    }
    public void showSignUp() throws IOException {//mostra la schermata login, la invoco dopo la registrazione
        this.loadStage("interfaccia SignUp.fxml","signup.css");
    }
    private void loadStage(String stageFXML, String stageCSS) throws IOException { //mostra a schermo la schermata passato con i parametri
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(stageFXML));
        Parent root1 = fxmlLoader.load();
        root1.getStylesheets().add(Objects.requireNonNull(getClass().getResource(stageCSS)).toExternalForm());

        this.fadeAnimation(root1, this.stage.getScene().getRoot());

        this.stage.setScene(new Scene(root1));

    }
    public void showExit() throws IOException{
        this.loadStage("login.fxml","login.css");
    }
   public void showNotificheDaCliente() throws IOException{//mostra le notifiche da cliente
        this.loadStage("interfaccianotificadacliente.fxml","profileMyDetails.css");
    }

    public void showProfileRecensione() throws IOException{//mostra il profilo sulla sezione recensione
        this.loadStage("interfaccia profilerecensione.fxml","p");
    }

    public void showForm(String emailWorker, String emailC, String nameC, String surnameC) {//mostra il form
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interfacciaForm.fxml"));
        Parent root1 = null;
        try {
            root1 = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        root1.getStylesheets().add(Objects.requireNonNull(getClass().getResource("form.css")).toExternalForm());
        FillFormView ffV = fxmlLoader.getController();
        ffV.preCompileInfo(emailWorker,emailC,nameC,surnameC);

        this.fadeAnimation(root1, this.stage.getScene().getRoot());

        this.stage.setScene(new Scene(root1));
    }

    public void showProfileMyDetails() throws IOException{//mostra i dettagli del proprio profilo
        this.loadStage("interfacciaprofileMyDetails.fxml","profileMyDetails.css");
    }

/* commento perché showUserProfile non dovrebbe più servire ma lo lasciamo un attimo per vedere se servirà
    public void showUserProfile() throws  IOException{//mostra il profilo dell'user
        this.loadStage("interfacciaUserProfile.fxml", "profileMyDetails.css");
    }*/
    //prova da homeview
public void insertInfoUser(String namesearch, String surnamesearch,String emailsearch) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interfacciaUserProfile.fxml"));
    Parent root1 = fxmlLoader.load();
    root1.getStylesheets().add(Objects.requireNonNull(getClass().getResource("profileMyDetails.css")).toExternalForm());
    UserProfileView userProfileView = fxmlLoader.getController();
    userProfileView.preCompileUser(namesearch, surnamesearch,emailsearch);

    this.fadeAnimation(root1, this.stage.getScene().getRoot());

    this.stage.setScene(new Scene(root1));
}
    //fine prova, funziona!










    /*public void showProfilo() throws  IOException{//mostra il profilo del worker
        this.loadStage("interfacciaWorkerProfile.fxml", "profileMyDetails.css");
    }*/

    // stessa prova del showUserP.
    public void insertInfoWorker(String namesearch, String surnamesearch,String emailsearch) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interfacciaWorkerProfile.fxml"));
        Parent root1 = fxmlLoader.load();
        root1.getStylesheets().add(Objects.requireNonNull(getClass().getResource("profileMyDetails.css")).toExternalForm());
        WorkerProfileView workerProfileView = fxmlLoader.getController();
        workerProfileView.preCompileWorker(namesearch, surnamesearch,emailsearch);

        this.fadeAnimation(root1, this.stage.getScene().getRoot());

        this.stage.setScene(new Scene(root1));
    }
    //fine seconda prova
















    public void showSearchDinamica(SearchDinamicaBean bean) throws IOException{//mostra la schermata di search
    //facciamo così perchè ci serve sapere il file fxml a quale controller è associato, per far riferire tuuti allo stesso controller (controller scritto nella prima riga del file fxml)
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interfacciaSearch Dinamica.fxml"));
        Parent root1 = fxmlLoader.load();
        root1.getStylesheets().add(Objects.requireNonNull(getClass().getResource("search.css")).toExternalForm());

        this.fadeAnimation(root1, this.stage.getScene().getRoot());
        this.stage.setScene(new Scene(root1));

        SearchDinamicaView sdv = fxmlLoader.getController();
        sdv.showResult(bean);


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
        root1.getStylesheets().add(Objects.requireNonNull(getClass().getResource("signup.css")).toExternalForm());
        SignUpView signUpView = fxmlLoader.getController();
        signUpView.preCompile(email, password);

        this.fadeAnimation(root1, this.stage.getScene().getRoot());

        this.stage.setScene(new Scene(root1));

    }

    public void signUpMethod(String email, String nome, String cognome) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interfaccia profileSignUp.fxml"));
        Parent root1 = fxmlLoader.load();
        root1.getStylesheets().add(Objects.requireNonNull(getClass().getResource("signup.css")).toExternalForm());
        ProfileSignUpView profileSignUpView = fxmlLoader.getController();
        profileSignUpView.signUpMethodPrecompile(email, nome, cognome);

        this.fadeAnimation(root1, this.stage.getScene().getRoot());

        this.stage.setScene(new Scene(root1));
    }

    public void setPreviousStageStyles(String[] previousStageStyles) {
        this.previousStageStyles = previousStageStyles;
    }


    public void showSettings() { // da implementare
    }

    public void showProfileSignUp()throws IOException {
        this.loadStage("interfaccia profileSignUp.fxml","signup.css");
    }


    public void showSlotHours() throws IOException{
        this.loadStage("interfaccia SlotHours.fxml", "profileMyDetails.css");
    }

    public void insertInfo(String namesearch, String surnamesearch,String emailsearch) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interfaccia SlotHours.fxml"));
        Parent root1 = fxmlLoader.load();
        root1.getStylesheets().add(Objects.requireNonNull(getClass().getResource("profileMyDetails.css")).toExternalForm());
        SlotHoursView slotHoursView = fxmlLoader.getController();
        slotHoursView.preCompile(namesearch, surnamesearch,emailsearch);

        this.fadeAnimation(root1, this.stage.getScene().getRoot());

        this.stage.setScene(new Scene(root1));
    }
// prova per passaggio di email nome e cognome

    //prova per non duplicare le righe di quando bisogna aprire il profilo
    public void showProfile() throws UserNotFoundException, IOException {
        UserEntity user = UserEntity.getInstance();
        String emailsearch= user.getEmail();
        String type = user.getTipoaccesso();
        System.out.println(type);
        UIController viewController = UIController.getUIControllerInstance();//è singletone
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();
        SearchDinamicaBean searchDBean=new SearchDinamicaBean();
        searchDBean.setEmail(emailsearch);
        SearchDinamicaController searchDController =new SearchDinamicaController();
        searchDController.searchInfo(searchDBean);


        System.out.println("namesearch "+namesearch);
        System.out.println("surnamesearch "+surnamesearch);


        if(!"Worker".equals(type)) {

            viewController.insertInfoUser(namesearch,surnamesearch,emailsearch);
        } else{


            viewController.insertInfoWorker(namesearch,surnamesearch,emailsearch);
        }
    }






}


