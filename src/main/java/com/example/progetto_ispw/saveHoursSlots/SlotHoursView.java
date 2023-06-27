package com.example.progetto_ispw.saveHoursSlots;

import com.example.progetto_ispw.saveHoursSlots.exception.TimeSlotAlreadyExistsException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

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

    public void saveEditsMethod(ActionEvent actionEvent) throws TimeSlotAlreadyExistsException {
        SaveHoursBean bean = new SaveHoursBean();

        bean.setSlot1(slot1Text.getText());
        bean.setSlot2(slot2Text.getText());
        bean.setSlot3(slot3Text.getText());
        bean.setSlot4(slot4Text.getText());
        bean.setSlot5(slot5Text.getText());
        bean.setDateCalendar(dateCalendar.getEditor());

        SaveHoursController controller = new SaveHoursController();
        controller.saveHoursSlots(bean);

    }
}
