package com.example.progetto_ispw.fillform;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.fillform.exception.*;
import com.example.progetto_ispw.savehoursslots.SlotHoursEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


import com.example.progetto_ispw.home.ResultElement;

import java.io.IOException;
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
    @FXML
    public CheckBox check2;
    @FXML
    public CheckBox check3;
    @FXML
    public CheckBox check4;
    @FXML
    public CheckBox check5;
    @FXML
    public Label errorLabel;


    public void profileMethod(ActionEvent actionEvent) {
        //da implementare
    }

    public void favoritesMethod(ActionEvent actionEvent) {
        //da implementare
    }

    public void homeMethod(ActionEvent actionEvent) throws IOException {
        UIController viewController = UIController.getUIControllerInstance();//è singletone

        viewController.showHome();    }
    FillFormBean bean= new FillFormBean();
    // eccezioni
    // nome vuoto
    // cognome vuoto
    // email cliente vuota/errata
    // data calendario vuota
    // orario appuntamento vuoto
    // descrizione vuota

    public void sendFormMethod(ActionEvent actionEvent) throws IOException  {
        FillFormController controller= new FillFormController();

       try {

            bean.setEmailUser(emailUserTextField.getText());
            bean.setName(nameTextField.getText());
            bean.setSurname(surnameTextField.getText());
            bean.setDescription(descriptionUserTextField.getText());
            bean.setPhone(phoneUserTextField.getText());
            //prendo la data
            LocalDate selectedDate = date.getValue();
           if(selectedDate==null){
               throw new EmptyDateFieldException("");}
            String dateStringCalendar = selectedDate.toString();
            bean.setDate(dateStringCalendar);


            SlotHoursEntity sl = SlotHoursEntity.getInstance();
            String slot1 = sl.getSlot1();
            String slot2 = sl.getSlot2();
            String slot3 = sl.getSlot3();
            String slot4 = sl.getSlot4();
            String slot5 = sl.getSlot5();

            if (check1.isSelected()) {
                sl.setAppointment(slot1);
                String appuntamento = sl.getAppointment();
                bean.setTime(appuntamento);

            }

            if (check2.isSelected()) {
                sl.setAppointment(slot2);
                String appuntamento = sl.getAppointment();
                bean.setTime(appuntamento);

            }

            if (check3.isSelected()) {
                sl.setAppointment(slot3);
                String appuntamento = sl.getAppointment();
                bean.setTime(appuntamento);

            }

            if (check4.isSelected()) {
                sl.setAppointment(slot4);
                String appuntamento = sl.getAppointment();
                bean.setTime(appuntamento);

            }

            if (check5.isSelected()) {
                sl.setAppointment(slot5);
                String appuntamento = sl.getAppointment();
                bean.setTime(appuntamento);

            }

            //aggiungere un controllo per far si che solo un check possa essere spuntato!


           controller.fill(bean);

            UIController viewController = UIController.getUIControllerInstance();//è singletone
            viewController.showHome();

        } catch (TimeAlreadySelectedException e) {
           errorLabel.setText("The selected time is no longer valid.");
          // errorTimeNotValid.setOpacity(1);
       }catch (EmptyNameFieldException e ){
           errorLabel.setText("WARNING: NAME FIELD IS EMPTY!");
          // errorTimeNotValid.setOpacity(1);
       }catch (EmptySurameFieldException e){
           errorLabel.setText("WARNING: SURNAME FIELD IS EMPTY!");
        //   errorTimeNotValid.setOpacity(1);
       }catch (EmptyDescriptionFieldException e){
           errorLabel.setText("WARNING: DESCRIPTION FIELD IS EMPTY!");
        //   errorTimeNotValid.setOpacity(1);
       }catch(NotValidNumberPhoneException e){
           errorLabel.setText("WARNING: PHONE FIELD ISN'T VALID!");
          // errorTimeNotValid.setOpacity(1);
       }catch(InvalidEmailFormatException e){
           errorLabel.setText("WARNING: INVALID EMAIL FORMAT!");
          // errorTimeNotValid.setOpacity(1);
       }catch(EmptyDateFieldException e){
           errorLabel.setText("WARNING: DATE FIELD IS EMPTY!");
          // errorTimeNotValid.setOpacity(1);
       }catch(NotValidTimeException e){
           errorLabel.setText("WARNING: TIME CHECK IS EMPTY!");
          // errorTimeNotValid.setOpacity(1);
       }finally{
           errorLabel.setOpacity(1);
       }

    }



    public void backMethod(ActionEvent actionEvent) {
        //da implementare
    }

    public void searchDataFormMethod(ActionEvent actionEvent) {

        FillFormController controller= new FillFormController( );

        LocalDate selectedDate = date.getValue();

        String dateStringCalendar = selectedDate.toString();
        bean.setDate(dateStringCalendar);// funzionerà?? da verificare!

        //data selezionata dall'utente e dobbiamo prendere la mail da un precompile che dobbiamo fare
        //poi usiamo la query getslots
        SlotTilePane slPane= new SlotTilePane();
        slPane.createSlotTilePane();
        paneSlot.setVisible(true);
        //mostriamo quei dati in una riga che si compila in automatico con dei bottoni
        controller.takeSlot(bean);
        SlotHoursEntity sl=SlotHoursEntity.getInstance();
        String slot1=sl.getSlot1();
        String slot2=sl.getSlot2();
        String slot3=sl.getSlot3();
        String slot4=sl.getSlot4();
        String slot5=sl.getSlot5();


        slPane.addElements(check1,check2,check3,check4,check5,slot1,slot2,slot3,slot4,slot5);


        this.paneSlot.getChildren().add(slPane.getSlotTP());



        }


    public void preCompileInfo(String emailWorker) {
        this.emailWorkerTextField.setText(emailWorker);
        bean.setEmailWorker(emailWorker);}
}
