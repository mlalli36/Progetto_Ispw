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
    /*    if(email worker esiste nella tabella appont request){
            apri la pagina notifica cliente con i riquadri
                    e popola i riquadri in base a quanta gente ha chiesto un appuntamento
        }else{
            apri la pagina notifica cliente con 1 riquadro con scritto "no notifiche"
        }
        */
     //   String email=

        // per tenere traccia della mail del worker dopo il login
        WorkerEntity wkE= WorkerEntity.getInstance();
        String email= wkE.getEmail();
        WorkerProfileBean bean = new WorkerProfileBean();
        bean.setEmail(email);
        WorkerProfileController ctrl= new WorkerProfileController();
       if( ctrl.verfica(bean)){// creazione dei riquadri dinamici con i tasti
           //List<InfoAppoinEntity2> appointments = WorkerDAO.getInstance().getAppointmentforWoker(email);
           List<InfoAppoinEntity> appointments = WorkerDAO.getInstance().getAppointmentforWoker(email);
           if (!appointments.isEmpty()) {
               scrollPane.setVisible(true);
              // paneInsideScrollpane.getChildren().clear(); // Rimuovi eventuali contenuti precedenti
               vboxInsideScrollPane.getChildren().clear();

         //      for (InfoAppoinEntity2 infoE : appointments) { il problema potrebbe forse essere che infoE è singletone provo con quella originale
               for (InfoAppoinEntity infoE : appointments) {
                   WorkerTilePane workerTilePane = new WorkerTilePane();
                   workerTilePane.createWorkerTilePane();

                   String email_client = infoE.getCEmail();
                   String name_client = infoE.getCName();
                   String surname_client = infoE.getCSurname();
                   String phone_client = infoE.getCNumber();
                   String description_work = infoE.getdescriptionWork();
                   String time = infoE.getTime();
                   String date = infoE.getDAppo();

                   System.out.println();
                   System.out.println("email client: "+email_client);
                   System.out.println("name_client: "+name_client);
                   System.out.println("surname_client: "+surname_client);
                   System.out.println("phone_client: "+phone_client);
                   System.out.println("description work: "+description_work);
                   System.out.println("time: "+time);
                   System.out.println("date: "+date);

                   workerTilePane.addElements(name_client, surname_client, email_client, description_work, phone_client, date, time);
                  // paneInsideScrollpane.getChildren().add(workerTilePane.getWorkerTP());
                   vboxInsideScrollPane.getChildren().add(workerTilePane.getWorkerTP());
                                                            }
                                          }
                                 } else {
               noAppointmentText.setText("You have no appointments in your schedule..");
           }
      //  this.scrollPane.setContent(WorkerTilePane.getWorkerTP());
    }

        /*   WorkerTilePane workerTilePane = new WorkerTilePane();
           workerTilePane.createWorkerTilePane();
           scrollPane.setVisible(true);

           InfoAppoinEntity2 infoE= InfoAppoinEntity2.getInstance();
           String email_client = infoE.getCEmail();
           String name_client= infoE.getCName();
           String surname_client = infoE.getCSurname();
           String phone_client=infoE.getCNumber();
           String description_work= infoE.getdescriptionWork();
           String time=infoE.getTime();
           String date= infoE.getDAppo();
           // ok funziona, ma non crea i bottoni e stampa solo un appuntamento, controllare bene se serve creare una lista
           // invece che una nuova entity!!!

            /* li lascio, potrebbero servire per l'interfaccia da riga di comando
           System.out.println("email client: "+email_client);
           System.out.println("name_client: "+name_client);
           System.out.println("surname_client: "+surname_client);
           System.out.println("phone_client: "+phone_client);
           System.out.println("description work: "+description_work);
           System.out.println("time: "+time);
           System.out.println("date: "+date);
            *//*
           workerTilePane.addElements(name_client,surname_client,email_client,description_work,phone_client,date,time);
            this.paneInsideScrollpane.getChildren().add(workerTilePane.getWorkerTP());
*//*
           System.out.println("ctrl: "+ctrl.verfica(bean));
           System.out.println("l'email è nella tabella");
       }else{// messaggio stampato che non esistono appuntamenti
           System.out.println("l'email NON è nella tabella");
            noAppointmentText.setText("You have no appointments in your schedule..");
       }*/
        /* UIController controller =  UIController.getUIControllerInstance();
        controller.showNotificheDaCliente();*/
    }

