package com.example.progetto_ispw.userprofile;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.searchdinamica.SearchDinamicaBean;
import com.example.progetto_ispw.searchdinamica.SearchDinamicaController;
import com.example.progetto_ispw.user.UserDAO;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.worker.InfoAppoinEntity;
import com.example.progetto_ispw.worker.InfoAppoinEntity2;
import com.example.progetto_ispw.worker.WorkerTilePane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;

public class UserProfileView {
    @FXML
    public AnchorPane anchorPaneProfile;
    @FXML
    public Button profile;
    @FXML
    public ImageView home;
    @FXML
    public ImageView favorites;
    @FXML
    public Button bookedServices;
    @FXML
    public Button myDetails;
    @FXML
    public Button changePassword;
    @FXML
    public Button addresses;
    @FXML
    public Button needHelp;
    @FXML
    public Button exit;
    @FXML
    public Label nameLabelUserProfile;
    @FXML
    public Label surnameLabelUserProfile;
    @FXML
    public Label emailLabelUserProfile;
    @FXML
    public Button homeButton;
    @FXML
    public ScrollPane scrollPane;
    @FXML
    public VBox vBox;
    @FXML
    public Text noAppointmentText;

    public void profileMethod(ActionEvent actionEvent) throws UserNotFoundException, IOException {//da implementare
      UIController controller= UIController.getUIControllerInstance();
      controller.showProfile();
    }

    public void homeMethod(ActionEvent actionEvent) throws IOException {
        UIController viewController = UIController.getUIControllerInstance();//è singletone
        viewController.showHome();
    }

    public void favoritesMethod(MouseEvent mouseEvent) {//da implementare
    }

    public void bookedServicesMethod(ActionEvent actionEvent) {//da implementare
        UserEntity uE= UserEntity.getInstance();
        String email = uE.getEmail();
        UserProfileBean bean= new UserProfileBean();
        bean.setEmail(email);
        UserProfileController ctrl= new UserProfileController();
        if(ctrl.verifica(bean)) {
            List<InfoAppoinEntity> appointments = UserDAO.getInstance().getAppointmentforUser(email);
            if (!appointments.isEmpty() && appointments != null) {
                scrollPane.setVisible(true);
                vBox.getChildren().clear();

                VBox userTilesContainer = new VBox(); // Contenitore per le caselle dei lavoratori

                for (InfoAppoinEntity infoE : appointments) {
                    UserTilePane userTilePane = new UserTilePane();
                    userTilePane.createUserTilePane();
                    Button deleteButton = new Button("Delete");


                    String email_client = infoE.getCEmail();
                    String name_client = infoE.getCName();
                    String surname_client = infoE.getCSurname();
                    String phone_client = infoE.getCNumber();
                    String description_work = infoE.getdescriptionWork();
                    String time = infoE.getTime();
                    String date = infoE.getDAppo();
                    String email_worker = infoE.getWEmail();
                    deleteButton.setOnAction(event -> {
                        // Qui puoi utilizzare le variabili email_client, date_work e time_work
                        // per eseguire le azioni necessarie quando il bottone rejectButton viene premuto
                        InfoAppoinEntity2 in = InfoAppoinEntity2.getInstance();
                        System.out.println();
                        System.out.println("Reject button clicked for email: " + email_client);
                        System.out.println("Date: " + date);
                        System.out.println("Time: " + time);
                        in.setDAppo(date);
                        in.setTime(time);
                        in.setCEmail(email_client);
                        System.out.println();
                        System.out.println("infoappent for email: " + in.getTime());
                        UserProfileController controller = new UserProfileController();
                        controller.deleteAppoU(email_client, date, time);
                    });

                    userTilePane.addElements(deleteButton, name_client, surname_client, email_client, description_work, phone_client, date, time, email_worker);
                    userTilesContainer.getChildren().add(userTilePane.getUserTP()); // Aggiungi la casella al contenitore

                }
                scrollPane.setContent(userTilesContainer);
                //  }
            } else {
                noAppointmentText.setText("You have no appointments in your schedule..");
            }

    }
  }




    public void myDetailsMethod(ActionEvent actionEvent) {


    }

    public void changePasswordMethod(ActionEvent actionEvent) {//da implementare
    }

    public void addressesMethod(ActionEvent actionEvent) {//da implementare
    }



    public void exitMethod(ActionEvent actionEvent) throws IOException {
        UIController controller= UIController.getUIControllerInstance();
        controller.showExit();
    }


    public void preCompileUser( String namesearch, String surnamesearch, String emailsearch) {
        this.nameLabelUserProfile.setText(namesearch);
        this.surnameLabelUserProfile.setText(surnamesearch);
        this.emailLabelUserProfile.setText(emailsearch);

    }
    // prova come dice pamela per scrivere da qui


}
