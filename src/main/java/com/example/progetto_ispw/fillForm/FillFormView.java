package com.example.progetto_ispw.fillForm;

import com.example.progetto_ispw.saveHoursSlots.SlotHoursEntity;
import com.example.progetto_ispw.utile.CustomTilePane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.time.LocalDate;

public class FillFormView {
    @FXML
    public AnchorPane anchorPaneFillOutForm;
    @FXML
    public Pane paneFillOutForm;
    @FXML
    public Button profile;
    @FXML
    public Button favorites;

    @FXML
    public Button home;
    @FXML
    public Button sendForm; //non so se va private o public
    @FXML
    public Button back;
    @FXML
    public ScrollPane scrollPane;

    @FXML
    public TextField nameTextField;
    @FXML
    public TextField surnameTextField;
    @FXML
    public TextField emailUserTextField;
    @FXML
    public TextField phoneUserTextField;
    @FXML
    public TextField descriptionUserTextField;
    @FXML
    public DatePicker date;

    @FXML
    public Text emailWorkerTextField;
    @FXML
    public Pane paneSlot;

    @FXML
    public CheckBox check1;


    public void profileMethod(ActionEvent actionEvent) {
        //da implementare
    }

    public void favoritesMethod(ActionEvent actionEvent) {
        //da implementare
    }

    public void homeMethod(ActionEvent actionEvent) {
        //da implementare
    }
    FillFormBean bean= new FillFormBean();
    FillFormController controller= new FillFormController();

    public void sendFormMethod(ActionEvent actionEvent) {
        bean.setEmailUser(emailUserTextField.getText());
       bean.setName(nameTextField.getText());
       bean.setSurname(surnameTextField.getText());
       bean.setDescription(descriptionUserTextField.getText());
       bean.setPhone(phoneUserTextField.getText());
       //data da riprendere sotto

        SlotHoursEntity sh=SlotHoursEntity.getInstance();
        String appuntamento=sh.getAppointment();
        System.out.println("appuntamento alle ore: "+appuntamento);


    }



    public void backMethod(ActionEvent actionEvent) {
        //da implementare
    }

    public void searchDataFormMethod(ActionEvent actionEvent) {


        LocalDate selectedDate = date.getValue();

        String dateStringCalendar = selectedDate.toString();
        bean.setDate(dateStringCalendar);// funzionerà?? da verificare!
        System.out.println("prova data "+dateStringCalendar);

        //data selezionata dall'utente e dobbiamo prendere la mail da un precompile che dobbiamo fare
        //poi usiamo la query getslots
        SlotTilePane slPane= new SlotTilePane();
        slPane.createSlotTilePane();
        paneSlot.setVisible(true);
        //mostriamo quei dati in una riga che si compila in automatico con dei bottoni
        controller.TakeSlot(bean);
        SlotHoursEntity sl=SlotHoursEntity.getInstance();
        String slot1=sl.getSlot1();
        String slot2=sl.getSlot2();
        String slot3=sl.getSlot3();
        String slot4=sl.getSlot4();
        String slot5=sl.getSlot5();
        System.out.println("slot1: "+slot1);

        slPane.addElements(check1,slot1,slot2,slot3,slot4,slot5);


        this.paneSlot.getChildren().add(slPane.getSlotTP());


        }


    public void preCompileInfo(String emailWorker) {
        this.emailWorkerTextField.setText(emailWorker);
        bean.setEmailWorker(emailWorker);}
}
