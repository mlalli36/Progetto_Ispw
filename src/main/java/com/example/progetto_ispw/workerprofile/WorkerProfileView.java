package com.example.progetto_ispw.workerprofile;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.home.ResultElement;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.utile.CustomTilePane;
import com.example.progetto_ispw.worker.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class WorkerProfileView {
    @FXML
    public AnchorPane anchorPaneProfile;
    @FXML
    public Button myDetails;
    @FXML
    public Button bookedServices;
    @FXML
    public Button changePassword;
    @FXML
    public Button addresses;

    @FXML
    public Button exit;
    @FXML
    public Button saveEdits;
    @FXML
    public ImageView profile;
    @FXML
    public ImageView home;
    @FXML
    public Button favorites;
    @FXML
    public TextField emailTextFild;
    @FXML
    public Button changeOfWorkingHoursButton;

    @FXML
    public Label nameLabelWorkerProfile;
    @FXML
    public Label surnameLabelWorkerProfile;
    @FXML
    public Label emailLabelWorkerProfile;
    @FXML
    public Button notificationButton;
    @FXML
    public Button profileButton;
    @FXML
    public Button homeButton;
    @FXML
    public Button exitButton;
   @FXML
   public ScrollPane scrollPane;
   @FXML
   public Pane paneInsideScrollpane;
   @FXML
   public Text noAppointmentText;
   @FXML
   public VBox vboxInsideScrollPane;


    public void homeMethod(ActionEvent actionEvent) throws IOException {
        UIController controller= UIController.getUIControllerInstance();
        controller.showHome();}

    public void favoritesMethod(ActionEvent actionEvent) {//da implementare
    }

    public void saveEditsMethod(ActionEvent actionEvent) {//da implementare
    }

    public void bookedServicesMethod(ActionEvent actionEvent) {//da implementare
    }

    public void myDetailsMethod(ActionEvent actionEvent) {//da implementare
    }

    public void changePasswordMethod(ActionEvent actionEvent) {//da implementare
    }

    public void addressesMethod(ActionEvent actionEvent) {//da implementare
    }

    public void exitMethod(ActionEvent actionEvent) throws IOException {
        UIController controller= UIController.getUIControllerInstance();
        controller.showExit();
    }

    public void profileMethod(ActionEvent actionEvent) {//da implementare
    }

    public void changeOfWorkingHoursMethod(ActionEvent actionEvent) throws IOException, UserNotFoundException {
        UserEntity user = UserEntity.getInstance();
        UIController viewController = UIController.getUIControllerInstance();//è singletone

        String emailsearch= user.getEmail();
        WorkerProfileBean wPB=new WorkerProfileBean();
        wPB.setEmail(emailsearch);
        WorkerProfileController wPC=new WorkerProfileController();
        wPC.searchInfo(wPB);
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();




        viewController.insertInfo(namesearch,surnamesearch,emailsearch);
    }

    public void preCompileWorker(String namesearch, String surnamesearch, String emailsearch) {
        this.nameLabelWorkerProfile.setText(namesearch);
        this.surnameLabelWorkerProfile.setText(surnamesearch);
        this.emailLabelWorkerProfile.setText(emailsearch);

    }


    public void notificationMethod(ActionEvent actionEvent) throws IOException {

        WorkerEmailEntity wkE= WorkerEmailEntity.getInstance();
        String email= wkE.getEmailWEE();
        WorkerProfileBean bean = new WorkerProfileBean();
        bean.setEmail(email);
        WorkerProfileController ctrl= new WorkerProfileController();

        if( ctrl.verfica(bean)){// creazione dei riquadri dinamici con i tasti
           List<InfoAppoinEntity> appointments = WorkerDAO.getInstance().getAppointmentforWoker(email);
           if (!appointments.isEmpty() && appointments!=null) {
               scrollPane.setVisible(true);
               vboxInsideScrollPane.getChildren().clear();

               VBox workerTilesContainer = new VBox(); // Contenitore per le caselle dei lavoratori

               for (InfoAppoinEntity infoE : appointments) {
                   WorkerTilePane workerTilePane = new WorkerTilePane();
                   workerTilePane.createWorkerTilePane();
                   Button accepttButton= new Button("Accept");
                   Button rejectButton= new Button("Reject");


                   String email_client = infoE.getCEmail();
                   String name_client = infoE.getCName();
                   String surname_client = infoE.getCSurname();
                   String phone_client = infoE.getCNumber();
                   String description_work = infoE.getdescriptionWork();
                   String time = infoE.getTime();
                   String date = infoE.getDAppo();
                   rejectButton.setOnAction(event -> {
                       // Qui puoi utilizzare le variabili email_client, date_work e time_work
                       // per eseguire le azioni necessarie quando il bottone rejectButton viene premuto
                       InfoAppoinEntity2 in=InfoAppoinEntity2.getInstance();
                       System.out.println();
                       System.out.println("Reject button clicked for email: " + email_client);
                       System.out.println("Date: " + date);
                       System.out.println("Time: " + time);
                       in.setDAppo(date);
                       in.setTime(time);
                       in.setWEmail(email);
                       System.out.println();
                       System.out.println("infoappent for email: " + in.getTime());
                       WorkerProfileController controller= new WorkerProfileController();
                       controller.deleteAppo(date,time,email);
                   });

                   workerTilePane.addElements(accepttButton,rejectButton,name_client, surname_client, email_client, description_work, phone_client, date, time);
                 //  vboxInsideScrollPane.getChildren().add(workerTilePane.getWorkerTP());
                   workerTilesContainer.getChildren().add(workerTilePane.getWorkerTP()); // Aggiungi la casella al contenitore

               }scrollPane.setContent(workerTilesContainer);
               //  }
           } else {
               noAppointmentText.setText("You have no appointments in your schedule..");
           }
       }
        //this.scrollPane.setContent(workerTilePane.getWorkerTP());

    }
    }

