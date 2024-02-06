package com.example.progetto_ispw.searchdinamica;


import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.home.ResultElement;
import com.example.progetto_ispw.home.ResultSetEntity; //vedere se è giusto
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.utile.CustomTilePane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;


public class SearchDinamicaView{

    @FXML
    public Text textError;
    private SearchDinamicaBean bean2;

    @FXML
    public Button profileButton;
    @FXML
    public Button favoritesButton;
    @FXML
    public Button homeButton;

    @FXML
    public Button fillOutForm;
    @FXML
    public VBox myVBox;
    @FXML
    public Pane paneDinamico;
    @FXML
    public ScrollPane scrollPane;
    public String emailWorker;

    UserEntity user = UserEntity.getInstance();
    String emailsearch= user.getEmail();


    public void profileMethod(ActionEvent actionEvent) throws IOException, UserNotFoundException {

        String type = user.getTipoaccesso();
        System.out.println(type);
        UIController viewController = UIController.getUIControllerInstance();

        SearchDinamicaBean searchDBean = new SearchDinamicaBean();
        searchDBean.setEmail(emailsearch);
        SearchDinamicaController searchDController = new SearchDinamicaController();
        searchDController.searchInfo(searchDBean);
        String namesearch = user.getName();
        String surnamesearch = user.getSurname();


        System.out.println("namesearch " + namesearch);
        System.out.println("surnamesearch " + surnamesearch);


        if (!"Worker".equals(type)) {

            viewController.insertInfoUser(namesearch, surnamesearch, emailsearch);
        } else {


            viewController.insertInfoWorker(namesearch, surnamesearch, emailsearch);

        }
    }

    public void favoritesMethod(ActionEvent actionEvent) { //da fare
    }

    public void homeMethod(ActionEvent actionEvent) throws IOException { //da fare
        UIController viewController = UIController.getUIControllerInstance();//è singletone

        viewController.showHome();
    }

    public void showIntForm(ActionEvent event) throws UserNotFoundException {
         Button clickedButton =(Button) event.getSource();
         String email = (String) clickedButton.getUserData() ;

         SearchDinamicaBean searchDBean=new SearchDinamicaBean();
        searchDBean.setEmail(emailsearch);
        SearchDinamicaController ctrl= new SearchDinamicaController();
        ctrl.searchInfo(searchDBean);

        String emailCl= user.getEmail();
        String nameCl= user.getName();
        String surnameCl= user.getSurname();

        UIController viewController = UIController.getUIControllerInstance();
        viewController.showForm(email,emailCl,nameCl,surnameCl);

    }
}






