package com.example.progetto_ispw;

import com.example.progetto_ispw.acceptappointment.AcceptView;
import com.example.progetto_ispw.bookedServicesUser.BookedServicesUserView;
import com.example.progetto_ispw.bookedServicesWorker.BookedServicesWorkerView;
import com.example.progetto_ispw.fillform.FillFormView;
import com.example.progetto_ispw.home.HomeBean;
import com.example.progetto_ispw.home.HomeController;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.notifications.NotificationsView;
import com.example.progetto_ispw.profilesignup.ProfileSignUpView;
import com.example.progetto_ispw.savehoursslots.SlotHoursView;
import com.example.progetto_ispw.signup.SignUpView;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.userprofile.UserProfileView;
import com.example.progetto_ispw.workerprofile.WorkerProfileView;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
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
    private String[] previousStageStyles;

    private UIController(){}
    public static UIController getUIControllerInstance() {
        if(UIController.singleUIControllerInstance == null){
            UIController.singleUIControllerInstance = new UIController();
        }
        return UIController.singleUIControllerInstance;
    }

    public void showHome() throws IOException{
        this.loadStage("interfacciaHome.fxml","home.css" );
    }

    public void showLogin() throws IOException {
        this.loadStage("login.fxml","login.css");
    }
  
    //FINO A QUI
    public void showSignUp() throws IOException {
        this.loadStage("interfaccia SignUp.fxml","signup.css");
    }
    private void loadStage(String stageFXML, String stageCSS) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(stageFXML));
        Parent root1 = fxmlLoader.load();
        root1.getStylesheets().add(Objects.requireNonNull(getClass().getResource(stageCSS)).toExternalForm());

        this.fadeAnimation(root1, this.stage.getScene().getRoot());

        this.stage.setScene(new Scene(root1));

    }
    public void showExit() throws IOException{
        this.loadStage("login.fxml","login.css");
    }
   public void showNotificheDaCliente() throws IOException{
        this.loadStage("interfaccianotificadacliente.fxml","profileMyDetails.css");
    }

    public void showProfileRecensione() throws IOException{
        this.loadStage("interfaccia profilerecensione.fxml","p");
    }

    public void showForm(String emailWorker, String emailC, String nameC, String surnameC, String date) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interfacciaForm.fxml"));
        Parent root1 = null;
        try {
            root1 = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        root1.getStylesheets().add(Objects.requireNonNull(getClass().getResource("form.css")).toExternalForm());
        FillFormView ffV = fxmlLoader.getController();
        ffV.preCompileInfo(emailWorker,emailC,nameC,surnameC,date);




        this.fadeAnimation(root1, this.stage.getScene().getRoot());

        this.stage.setScene(new Scene(root1));
    }

    public void showProfileMyDetails() throws IOException{
        this.loadStage("interfacciaprofileMyDetails.fxml","profileMyDetails.css");
    }


public void insertInfoUser(String namesearch, String surnamesearch,String emailsearch) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interfacciaUserProfile.fxml"));
    Parent root1 = fxmlLoader.load();
    root1.getStylesheets().add(Objects.requireNonNull(getClass().getResource("profileMyDetails.css")).toExternalForm());
    UserProfileView userProfileView = fxmlLoader.getController();
    userProfileView.preCompileUser(namesearch, surnamesearch,emailsearch);

    this.fadeAnimation(root1, this.stage.getScene().getRoot());

    this.stage.setScene(new Scene(root1));
}
    public void insertInfoWorker(String namesearch, String surnamesearch,String emailsearch) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interfacciaWorkerProfile.fxml"));
        Parent root1 = fxmlLoader.load();
        root1.getStylesheets().add(Objects.requireNonNull(getClass().getResource("profileMyDetails.css")).toExternalForm());
        WorkerProfileView workerProfileView = fxmlLoader.getController();
        workerProfileView.preCompileWorker(namesearch, surnamesearch,emailsearch);

        this.fadeAnimation(root1, this.stage.getScene().getRoot());

        this.stage.setScene(new Scene(root1));
    }

    public void showNotifications(String namesearch, String surnamesearch,String emailsearch) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interfacciaNotifications.fxml"));
        Parent root1 = fxmlLoader.load();
        root1.getStylesheets().add(Objects.requireNonNull(getClass().getResource("profileMyDetails.css")).toExternalForm());
        NotificationsView notificationsView = fxmlLoader.getController();
        notificationsView.preCompileWorker(namesearch, surnamesearch,emailsearch);
        ActionEvent dummyEvent = new ActionEvent(); // Crea un oggetto ActionEvent
        notificationsView.notificationMethod(dummyEvent);
        this.fadeAnimation(root1, this.stage.getScene().getRoot());

        this.stage.setScene(new Scene(root1));
    }
    public void showAccept(String namesearch, String surnamesearch,String emailsearch) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interfacciaAcceptAppointment.fxml"));
        Parent root1 = fxmlLoader.load();
        root1.getStylesheets().add(Objects.requireNonNull(getClass().getResource("profileMyDetails.css")).toExternalForm());
        AcceptView acceptView = fxmlLoader.getController();
        acceptView.preCompileWorker(namesearch, surnamesearch,emailsearch);
        ActionEvent dummyEvent = new ActionEvent();
        acceptView.acceptMethod(dummyEvent);
        this.fadeAnimation(root1, this.stage.getScene().getRoot());

        this.stage.setScene(new Scene(root1));
    }

    public void showBookedServicesUser(String namesearch, String surnamesearch,String emailsearch) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interfacciaBookedServicesUser.fxml"));
        Parent root1 = fxmlLoader.load();
        root1.getStylesheets().add(Objects.requireNonNull(getClass().getResource("profileMyDetails.css")).toExternalForm());
        BookedServicesUserView bookedServicesUserView = fxmlLoader.getController();
        bookedServicesUserView.preCompileUser(namesearch, surnamesearch,emailsearch);
        ActionEvent dummyEvent = new ActionEvent(); // Crea un oggetto ActionEvent
        bookedServicesUserView.bookedServicesMethod(dummyEvent);
        this.fadeAnimation(root1, this.stage.getScene().getRoot());

        this.stage.setScene(new Scene(root1));
    }

    public void showBookedServicesWorker(String namesearch, String surnamesearch,String emailsearch) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interfacciaBookedServicesWorker.fxml"));
        Parent root1 = fxmlLoader.load();
        root1.getStylesheets().add(Objects.requireNonNull(getClass().getResource("profileMyDetails.css")).toExternalForm());
        BookedServicesWorkerView bookedServicesWorkerView = fxmlLoader.getController();
        bookedServicesWorkerView.preCompileWorker(namesearch, surnamesearch,emailsearch);
        ActionEvent dummyEvent = new ActionEvent();
        bookedServicesWorkerView.bookedServicesMethod(dummyEvent);
        this.fadeAnimation(root1, this.stage.getScene().getRoot());

        this.stage.setScene(new Scene(root1));
    }



    private void fadeAnimation(Parent screenToFadeIn, Parent screenToFadeOut){
        this.fadeOut(screenToFadeOut);
        this.fadeIn(screenToFadeIn);
    }

    private void fadeOut(Parent root){
        FadeTransition ft = new FadeTransition(Duration.millis(300), root);
        ft.setFromValue(1.0);
        ft.setToValue(0);
        ft.play();
    }

    private void fadeIn(Parent root){
        FadeTransition ft = new FadeTransition(Duration.millis(300), root);
        ft.setFromValue(0);
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

   public void showProfile() throws UserNotFoundException, IOException {
        UserEntity user = UserEntity.getInstance();
        String emailsearch= user.getEmail();
        String type = user.getTipoaccesso();
        System.out.println(type);
        UIController viewController = UIController.getUIControllerInstance();
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();
        HomeBean hBean=new HomeBean();
        hBean.setEmail(emailsearch);
        HomeController searchDController =new HomeController();
        searchDController.searchInfo(hBean);


        System.out.println("namesearch "+namesearch);
        System.out.println("surnamesearch "+surnamesearch);


        if(!"Worker".equals(type)) {

            viewController.insertInfoUser(namesearch,surnamesearch,emailsearch);
        } else{


            viewController.insertInfoWorker(namesearch,surnamesearch,emailsearch);
        }
    }
    public void showMyDetailsWorker(String namesearch, String surnamesearch, String emailsearch) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interfaccia profileSignUp.fxml"));
        Parent root1 = fxmlLoader.load();
        root1.getStylesheets().add(Objects.requireNonNull(getClass().getResource("profileMyDetails.css")).toExternalForm());
        ProfileSignUpView profileView = fxmlLoader.getController();
        profileView.preCompile(namesearch, surnamesearch,emailsearch);

        this.fadeAnimation(root1, this.stage.getScene().getRoot());

        this.stage.setScene(new Scene(root1));
    }





}


