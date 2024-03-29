package com.example.progetto_ispw.fillform;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.fillform.exception.*;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.savehoursslots.SlotHoursEntity;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.worker.WorkerEmailEntity;
import com.sun.javafx.collections.ObservableMapWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


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
    public Button sendForm;
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
    @FXML
    public TextField dateTextField;


    public void preCompileInfo(String emailWorker, String emailC, String nameC, String surnameC, String date) {
        this.emailWorkerTextField.setText(emailWorker);
        this.emailUserTextField.setText(emailC);
        this.nameTextField.setText(nameC);
        this.surnameTextField.setText(surnameC);
        bean.setEmailWorker(emailWorker);
        this.dateTextField.setText(date);
        bean.setDate(date);

    }

    public void profileMethod( ) throws UserNotFoundException, IOException {
        UserEntity user = UserEntity.getInstance();
        String type = user.getTipoaccesso();
        UIController viewController = UIController.getUIControllerInstance();//è singletone

        String emailsearch= user.getEmail();
        FillFormBean fillForm=new FillFormBean();
        fillForm.setEmail(emailsearch);
        FillFormController fillFormController=new FillFormController();
        fillFormController.searchInfo(fillForm);
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();


        if(!"Worker".equals(type)) {

            viewController.insertInfoUser(namesearch,surnamesearch,emailsearch);
        } else{

            WorkerEmailEntity wkE= WorkerEmailEntity.getInstance();

            wkE.setEmailWEE(emailsearch);
            viewController.insertInfoWorker(namesearch,surnamesearch,emailsearch);
        }
    }



    public void homeMethod( ) throws IOException {
        UIController viewController = UIController.getUIControllerInstance();

        viewController.showHome();    }

    FillFormBean bean= new FillFormBean();




    public void sendFormMethod( ) throws IOException  {
        FillFormController controller= new FillFormController();

       try {

            bean.setEmailUser(emailUserTextField.getText());
            bean.setName(nameTextField.getText());
            bean.setSurname(surnameTextField.getText());
            bean.setDescription(descriptionUserTextField.getText());
            bean.setPhone(phoneUserTextField.getText());

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



           controller.fill(bean);

            UIController viewController = UIController.getUIControllerInstance();//è singletone
            viewController.showHome();

        } catch (TimeAlreadySelectedException e) {
           errorLabel.setText("The selected time is no longer valid.");
        }catch (EmptyNameFieldException e ){
           errorLabel.setText("WARNING: NAME FIELD IS EMPTY!");
        }catch (EmptySurameFieldException e){
           errorLabel.setText("WARNING: SURNAME FIELD IS EMPTY!");
        }catch (EmptyDescriptionFieldException e){
           errorLabel.setText("WARNING: DESCRIPTION FIELD IS EMPTY!");
        }catch(NotValidNumberPhoneException e){
           errorLabel.setText("WARNING: PHONE FIELD ISN'T VALID!");
        }catch(InvalidEmailFormatException e){
           errorLabel.setText("WARNING: INVALID EMAIL FORMAT!");
        }catch(EmptyDateFieldException e){
           errorLabel.setText("WARNING: DATE FIELD IS EMPTY!");
        }catch(NotValidTimeException e){
           errorLabel.setText("WARNING: TIME CHECK IS EMPTY!");
        } finally{
           errorLabel.setOpacity(1);
       }

    }



    public void searchDataFormMethod() {

        FillFormController controller= new FillFormController( );



        SlotTilePane slPane= new SlotTilePane();
        slPane.createSlotTilePane();
        paneSlot.setVisible(true);
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


    public void backMethod() throws IOException {
       //to be implemented
    }
}
