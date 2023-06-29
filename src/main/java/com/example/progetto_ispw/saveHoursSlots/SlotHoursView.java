package com.example.progetto_ispw.saveHoursSlots;

import com.example.progetto_ispw.saveHoursSlots.exception.TimeSlotAlreadyExistsException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    public Label nomePrecompile;
    @FXML
    public Label cognomePrecompile;
    @FXML
    public Label emailPrecompile;

    public void saveEditsMethod(ActionEvent actionEvent) {
        SaveHoursBean bean = new SaveHoursBean();
        DatePicker datePicker = new DatePicker();
        bean.setemail(emailText.getText());
        bean.setSlot1(slot1Text.getText());
        bean.setSlot2(slot2Text.getText());
        bean.setSlot3(slot3Text.getText());
        bean.setSlot4(slot4Text.getText());
        bean.setSlot5(slot5Text.getText());
       // bean.setDateCalendar(dateCalendar.getValue());
      /*  datePicker.setOnAction(event -> {
            LocalDate selectedDate = datePicker.getValue();
            System.out.println("Data selezionata: " + selectedDate);
            bean.setDateCalendar(selectedDate);
        });*/
        LocalDate selectedDate = dateCalendar.getValue();
        String dateStringCalendar = selectedDate.toString();
        bean.setDateCalendar(dateStringCalendar);



        SaveHoursController controller = new SaveHoursController();
        controller.saveHoursSlots(bean);

    }
}
