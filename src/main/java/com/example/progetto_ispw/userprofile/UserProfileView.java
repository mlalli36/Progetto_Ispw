package com.example.progetto_ispw.userprofile;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.bookedServicesUser.BookedServicesUserBean;
import com.example.progetto_ispw.bookedServicesUser.BookedServicesUserController;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.searchdinamica.SearchDinamicaBean;
import com.example.progetto_ispw.searchdinamica.SearchDinamicaController;
import com.example.progetto_ispw.user.UserDAO;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.worker.InfoAppoinEntity;
import com.example.progetto_ispw.worker.InfoAppoinEntity2;
import com.example.progetto_ispw.worker.WorkerTilePane;
import com.example.progetto_ispw.workerprofile.WorkerProfileBean;
import com.example.progetto_ispw.workerprofile.WorkerProfileController;
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

    public void bookedServicesMethod(ActionEvent actionEvent) throws UserNotFoundException, IOException {
        UserEntity user=UserEntity.getInstance();
        UIController viewController= UIController.getUIControllerInstance();

        String emailsearch= user.getEmail();
        UserProfileBean bean = new UserProfileBean();
        bean.setEmail(user.getEmail());
        UserProfileController controller =new UserProfileController();
        controller.searchInfo(bean);
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();

        viewController.showBookedServicesUser(namesearch,surnamesearch,emailsearch);
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
