package com.example.progetto_ispw.saveHoursSlots;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.login.exception.LoginFailedException;
import com.example.progetto_ispw.saveHoursSlots.exception.InvalidTimeException;
import com.example.progetto_ispw.saveHoursSlots.exception.TimeSlotAlreadyExistsException;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.worker.WorkerEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;

public class SlotHoursView {
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
    public Label errorLabel;

    public void preCompile(String namesearch, String surnamesearch, String emailsearch) {
        this.nameLabel.setText(namesearch);
        this.surnameLabel.setText(surnamesearch);
        this.emailLabel.setText(emailsearch);

    }

    public void saveEditsMethod(ActionEvent actionEvent) throws IOException {
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

            bean.setDateCalendar(dateStringCalendar,slot1Text.getText(),slot2Text.getText(),slot3Text.getText(),slot4Text.getText(),slot5Text.getText());


            SaveHoursController controller = new SaveHoursController();
            controller.saveHoursSlots(bean);
            UIController viewController = UIController.getUIControllerInstance();//è singletone
            viewController.showHome();
        }
    catch (InvalidTimeException exception) {
            errorLabel.setText(exception.getMessage());
            errorLabel.setOpacity(1);
        }
        catch ( TimeSlotAlreadyExistsException exception){
            errorLabel.setText("Slot già selezionato!!!!!");
            errorLabel.setOpacity(1);
        }
    }
}
