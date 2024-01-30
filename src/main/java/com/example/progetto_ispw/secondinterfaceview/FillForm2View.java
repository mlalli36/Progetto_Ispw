package com.example.progetto_ispw.secondinterfaceview;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.fillform.FillFormBean;
import com.example.progetto_ispw.fillform.FillFormController;
import com.example.progetto_ispw.fillform.SlotTilePane;
import com.example.progetto_ispw.fillform.exception.*;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.savehoursslots.SlotHoursEntity;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.worker.WorkerEmailEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.w3c.dom.Text;

import java.io.IOException;
import java.time.LocalDate;

public class FillForm2View {
    @FXML
    public Button profileButton;
    @FXML
    public Button homeButton;
    @FXML
    public Label emailLabelWorkerProfile;
    @FXML
    public TextField nameTextField;
    @FXML
    public DatePicker date;
    @FXML
    public Button sendForm;
    @FXML
    public TextField surnameTextField;
    @FXML
    public TextField emailUserTextField;
    @FXML
    public TextField phoneUserTextField;
    @FXML
    public TextField descriptionUserTextField;
    @FXML
    public Button back;
    @FXML
    public Button searchDataForm;
    @FXML
    public AnchorPane anchorPaneFillOutForm;
    @FXML
    public Pane paneSlot;
    @FXML
    public Label errorLabel;
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

    public void profileMethod(ActionEvent actionEvent) throws UserNotFoundException, IOException {
        UserEntity user = UserEntity.getInstance();
        String type = user.getTipoaccesso();
        System.out.println(type);
        UIController viewController = UIController.getUIControllerInstance();//è singletone

        String emailsearch= user.getEmail();
        FillFormBean fillForm=new FillFormBean();
        fillForm.setEmail(emailsearch);
        FillFormController fillFormController=new FillFormController();
        fillFormController.searchInfo(fillForm);
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();
        System.out.println("home view nome utente: "+user.getName());
        System.out.println("home view cognnome utente: "+user.getSurname());


        if(!"Worker".equals(type)) {

            viewController.insertInfoUser(namesearch,surnamesearch,emailsearch);
        } else{

            WorkerEmailEntity wkE= WorkerEmailEntity.getInstance();
            //WorkerEntity wkE= new WorkerEntity();
            wkE.setEmailWEE(emailsearch);
            viewController.insertInfoWorker(namesearch,surnamesearch,emailsearch);
        }
    }


    public void homeMethod(ActionEvent actionEvent) throws IOException {
        UIController viewController = UIController.getUIControllerInstance();//è singletone

        viewController.showHome();    }
    FillFormBean bean= new FillFormBean();

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
        } finally{
            errorLabel.setOpacity(1);
        }

    }



    public void backMethod(ActionEvent actionEvent) throws IOException {
        UIController viewController = UIController.getUIControllerInstance();//è singletone
        viewController.showHome();
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

    public void preCompileInfo(String emailWorker, String emailC, String nameC, String surnameC) {
        this.emailLabelWorkerProfile.setText(emailWorker);
        this.emailUserTextField.setText(emailC);
        this.nameTextField.setText(nameC);
        this.surnameTextField.setText(surnameC);
        bean.setEmailWorker(emailWorker);}
}


