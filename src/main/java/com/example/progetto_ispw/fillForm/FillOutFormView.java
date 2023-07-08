package com.example.progetto_ispw.fillForm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class FillOutFormView {
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
    public Button searchDataForm;
    public TextField nameTextField;
    public TextField surnameTextField;
    public TextField emailUserTextField;
    public TextField phoneUserTextField;
    public TextField descriptionUserTextField;
    public DatePicker date;
    public Text emailWorkerTextField;


    public void profileMethod(ActionEvent actionEvent) {
        //da implementare
    }

    public void favoritesMethod(ActionEvent actionEvent) {
        //da implementare
    }

    public void homeMethod(ActionEvent actionEvent) {
        //da implementare
    }

    public void sendFormMethod(ActionEvent actionEvent) {
        //prende i dati dall'interfaccia, tutte le caselle textfield
        // prende i dati e lo slot selezionato dopo la ricerca, quindi fare un controllo se è selezionato un bottone(checkbox?) o no,
        // e poi invia il form al proprietario della mail.
        FillFormBean bean= new FillFormBean();
       bean.setEmailUser(emailUserTextField.getText());
       bean.setName(nameTextField.getText());
       bean.setSurname(surnameTextField.getText());
       bean.setDescription(descriptionUserTextField.getText());
       bean.setPhone(phoneUserTextField.getText());
       //bean.setDate(); da vedere come settare la data prendendola dal metodo sotto !



    }

    public void backMethod(ActionEvent actionEvent) {
        //da implementare
    }

    public void searchDataFormMethod(ActionEvent actionEvent) {
    //data selezionata dall'utente e dobbiamo prendere la mail da un precompile che dobbiamo fare
        //poi usiamo la query getslots
            //mostriamo quei dati in una riga che si compila in automatico con dei bottoni


        }



    public void preCompile(String email) {
        this.emailWorkerTextField.setText(email);
    }
}
