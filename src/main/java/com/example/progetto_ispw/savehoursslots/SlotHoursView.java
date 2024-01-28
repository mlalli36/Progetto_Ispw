package com.example.progetto_ispw.savehoursslots;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.savehoursslots.exception.InvalidTimeException;
import com.example.progetto_ispw.savehoursslots.exception.TimeSlotAlreadyExistsException;
import com.example.progetto_ispw.savehoursslots.observer.Observer;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.workerprofile.WorkerProfileBean;
import com.example.progetto_ispw.workerprofile.WorkerProfileController;
import com.example.progetto_ispw.workerprofile.WorkerProfileView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;

public class SlotHoursView implements Observer {
    @FXML
    public TextField slot1Text;
    @FXML
    public TextField slot2Text;
    @FXML
    public TextField slot3Text;
    @FXML
    public TextField slot4Text;
    @FXML
    public TextField slot5Text;
    @FXML
    public DatePicker dateCalendar;
    @FXML
    public Button saveEdits;
    @FXML
    public TextField emailText;

    @FXML
    public Label nameLabel;
    @FXML
    public Label surnameLabel;
    @FXML
    public Label emailLabel;
    @FXML
    public Label errorLabel;
    @FXML
    public Button homeButton;
    @FXML
    public Button exitButton;
    @FXML
    public Button notificationButton;
    @FXML
    public Button bookedServiceButton;
    @FXML
    public Button acceptButton;
    @FXML
    public Button myDetails;
    @FXML
    public Label successLabel;

    private SlotHours slotHours;

    public SlotHoursView() {
        SlotHoursEntity.getInstance().getSlotHours().attach(this);
    }

    public void preCompile(String namesearch, String surnamesearch, String emailsearch) {
        this.nameLabel.setText(namesearch);
        this.surnameLabel.setText(surnamesearch);
        this.emailLabel.setText(emailsearch);

    }
    public void exitMethod(ActionEvent actionEvent) throws IOException {
        UIController controller= UIController.getUIControllerInstance();
        controller.showExit();
    }

    public void saveEditsMethod(ActionEvent actionEvent) {
        try {
            SaveHoursBean bean = new SaveHoursBean();
            String string = this.emailLabel.getText();


          //  DatePicker datePicker = new DatePicker();
            bean.setemail(string);  // controllare questo che non funziona, ma abbiamo aggiunto il passaggio dei dati quindi la dovrebbe poter prendere più facilmente

            bean.setSlot1(slot1Text.getText());
            bean.setSlot2(slot2Text.getText());
            bean.setSlot3(slot3Text.getText());
            bean.setSlot4(slot4Text.getText());
            bean.setSlot5(slot5Text.getText());

            LocalDate selectedDate = dateCalendar.getValue();
            String dateStringCalendar = selectedDate.toString();

            bean.setDateCalendar(dateStringCalendar);


            SaveHoursController controller = new SaveHoursController();
            controller.saveHoursSlots(bean);

        }
    catch (InvalidTimeException exception) {
            errorLabel.setText(exception.getMessage());
            errorLabel.setOpacity(1);
        }
        catch ( TimeSlotAlreadyExistsException exception){
            errorLabel.setText(exception.getMessage());
            errorLabel.setOpacity(1);
            exception.printStackTrace(); // o utilizza un logger
        }
    }

    public void homeMethod(ActionEvent actionEvent) throws IOException {
        UIController viewController=UIController.getUIControllerInstance();
        viewController.showHome();

    }

    public void profileMethod(ActionEvent actionEvent) throws IOException {
        UserEntity user=UserEntity.getInstance();
        UIController viewController= UIController.getUIControllerInstance();
        String emailsearch= user.getEmail();
        SaveHoursBean bean = new SaveHoursBean();
        bean.setEmail(user.getEmail());
        // SaveHoursController controller =new SaveHoursController();

        String namesearch= user.getName();
        String surnamesearch= user.getSurname();
        viewController.insertInfoWorker(namesearch,surnamesearch,emailsearch);
    }


   public void notificationMethod(ActionEvent actionEvent) throws IOException, UserNotFoundException { //da implementare
        UserEntity user=UserEntity.getInstance();
        UIController viewController= UIController.getUIControllerInstance();

        String emailsearch= user.getEmail();
        SaveHoursBean bean = new SaveHoursBean();
        bean.setEmail(user.getEmail());
        SaveHoursController controller =new SaveHoursController();
        controller.searchInfo(bean);
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();

        viewController.showNotifications(namesearch,surnamesearch,emailsearch);
    }

    public void bookedServiceMethod(ActionEvent actionEvent) throws UserNotFoundException, IOException {
        UserEntity user=UserEntity.getInstance();
        UIController viewController= UIController.getUIControllerInstance();

        String emailsearch= user.getEmail();
        SaveHoursBean bean = new SaveHoursBean();
        bean.setEmail(user.getEmail());
        SaveHoursController controller =new SaveHoursController();
        controller.searchInfo(bean);
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();

        viewController.showBookedServicesWorker(namesearch,surnamesearch,emailsearch);

    }

    public void acceptMethod(ActionEvent actionEvent) throws UserNotFoundException, IOException {
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
    public void myDetailsMethod(ActionEvent actionEvent) throws UserNotFoundException, IOException {
        UserEntity user=UserEntity.getInstance();
        UIController viewController= UIController.getUIControllerInstance();

        String emailsearch= user.getEmail();
        WorkerProfileBean bean = new WorkerProfileBean();
        bean.setEmail(user.getEmail());
        WorkerProfileController controller =new WorkerProfileController();
        controller.searchInfo(bean);
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();
        viewController.showMyDetailsWorker(namesearch,surnamesearch,emailsearch);
    }

    @Override
    public void update() {
        /* Questo metodo implementa il metodo richiesto dall'interface Observer, per implementare il GoF Pattern
         * Observer, per fare in modo che una volta che l'utente aggiorna le proprie preferenze dalla GUI, questa venga
         * poi aggiornata per riflettere i cambiamenti.
         */

        this.showLabel();

    }
    private void showLabel(){
        successLabel.setText("Il salvataggio è andato a buon fine");
    }
}
