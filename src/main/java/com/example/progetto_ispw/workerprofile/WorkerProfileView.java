package com.example.progetto_ispw.workerprofile;

import com.example.progetto_ispw.UIController;

import com.example.progetto_ispw.login.exception.UserNotFoundException;

import com.example.progetto_ispw.savehoursslots.SlotHours;
import com.example.progetto_ispw.savehoursslots.SlotHoursEntity;

import com.example.progetto_ispw.user.UserEntity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javafx.scene.text.Text;


import java.io.IOException;


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
   public Text noAppointmentText;
    @FXML
    public Button acceptButton;
    @FXML
    public TextArea notificationTextArea;



    public void homeMethod() throws IOException {
        UIController controller= UIController.getUIControllerInstance();
        controller.showHome();}



    public void bookedServicesMethod( ) throws UserNotFoundException, IOException {
        UserEntity user = UserEntity.getInstance();
        UIController viewController = UIController.getUIControllerInstance();//è singletone

        String emailsearch= user.getEmail();
        WorkerProfileBean wPB=new WorkerProfileBean();
        wPB.setEmail(emailsearch);
        WorkerProfileController wPC=new WorkerProfileController();
        wPC.searchInfo(wPB);
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();




        viewController.showBookedServicesWorker(namesearch,surnamesearch,emailsearch);
    }

    public void myDetailsMethod(  )  throws UserNotFoundException, IOException {
        UserEntity user = UserEntity.getInstance();
        UIController viewController = UIController.getUIControllerInstance();//è singletone

        String emailsearch= user.getEmail();
        WorkerProfileBean wPB=new WorkerProfileBean();
        wPB.setEmail(emailsearch);
        WorkerProfileController wPC=new WorkerProfileController();
        wPC.searchInfo(wPB);
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();
        viewController.showMyDetailsWorker(namesearch,surnamesearch,emailsearch);
    }



    public void exitMethod() throws IOException {
        UIController controller= UIController.getUIControllerInstance();
        controller.showExit();
    }

    public void profileMethod() throws IOException {
        UserEntity user=UserEntity.getInstance();
        UIController viewController= UIController.getUIControllerInstance();
        String emailsearch= user.getEmail();
        WorkerProfileBean bean = new WorkerProfileBean();
        bean.setEmail(user.getEmail());

        String namesearch= user.getName();
        String surnamesearch= user.getSurname();
        viewController.insertInfoWorker(namesearch,surnamesearch,emailsearch);
    }

    public void changeOfWorkingHoursMethod() throws IOException, UserNotFoundException {
        UserEntity user = UserEntity.getInstance();
        UIController viewController = UIController.getUIControllerInstance();
         SlotHoursEntity slotHoursEntity= SlotHoursEntity.getInstance();
        SlotHours slotHours= new SlotHours();
        slotHoursEntity.setSlotHours(slotHours);

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


    public void notificationMethod( ) throws IOException, UserNotFoundException {
        UserEntity user=UserEntity.getInstance();
        UIController viewController= UIController.getUIControllerInstance();

        String emailsearch= user.getEmail();
        WorkerProfileBean bean = new WorkerProfileBean();
        bean.setEmail(user.getEmail());
        WorkerProfileController controller =new WorkerProfileController();
        controller.searchInfo(bean);
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();

        viewController.showNotifications(namesearch,surnamesearch,emailsearch);
}



    public void acceptMethod( ) throws UserNotFoundException, IOException {
        UserEntity user=UserEntity.getInstance();
        UIController viewController= UIController.getUIControllerInstance();

        String emailsearch= user.getEmail();
        WorkerProfileBean bean = new WorkerProfileBean();
        bean.setEmail(user.getEmail());
        WorkerProfileController controller =new WorkerProfileController();
        controller.searchInfo(bean);
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();

        viewController.showAccept(namesearch,surnamesearch,emailsearch);


    }
}


