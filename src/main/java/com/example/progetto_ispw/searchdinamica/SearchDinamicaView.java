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

import java.io.IOException;


public class SearchDinamicaView{

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
        UIController viewController = UIController.getUIControllerInstance();//è singletone
        String namesearch= user.getName();
        String surnamesearch= user.getSurname();
        SearchDinamicaBean searchDBean=new SearchDinamicaBean();
        searchDBean.setEmail(emailsearch);
        SearchDinamicaController searchDController =new SearchDinamicaController();
        searchDController.searchInfo(searchDBean);


        System.out.println("namesearch "+namesearch);
        System.out.println("surnamesearch "+surnamesearch);


        if(!"Worker".equals(type)) {

            viewController.insertInfoUser(namesearch,surnamesearch,emailsearch);
        } else{


            viewController.insertInfoWorker(namesearch,surnamesearch,emailsearch);
        }
    }

    public void favoritesMethod(ActionEvent actionEvent) { //da fare
    }

    public void homeMethod(ActionEvent actionEvent) throws IOException { //da fare
        UIController viewController = UIController.getUIControllerInstance();//è singletone

        viewController.showHome();
    }

    public void showResult(SearchDinamicaBean bean2) throws IOException {


        ResultSetEntity resultSet = bean2.getResultSet();

        CustomTilePane customTilePane = new CustomTilePane();
        customTilePane.createCustomTilePane();
        scrollPane.setVisible(true);



        for(ResultElement r: resultSet.getElements()){
            Button newButton = new Button("Fill out form");
            String name = r.getWorkerName();
            String jobWorker= r.getJobWorker();
            String locationWorker = r.getLocationWorker();
            String descriptionWorker= r.getWorkerDescription();
            emailWorker= r.getWorkerEmail();
            newButton.setUserData(emailWorker);

            customTilePane.addElements(name,jobWorker,locationWorker,descriptionWorker,newButton, emailWorker);

            newButton.setOnAction(event -> {
                try {
                    showIntForm(event);
                } catch (UserNotFoundException e) {
                    throw new RuntimeException(e);
                }
            });

        }
        this.scrollPane.setContent(customTilePane.getCustomTP());

    }

    public void showIntForm(ActionEvent event) throws UserNotFoundException {
        // tieniamo traccia del bottone che abbiamo premuto
        Button clickedButton =(Button) event.getSource();
        // tieniamo traccia dell'email associata a quel bottone
        String email = (String) clickedButton.getUserData() ;

      //  UserEntity user= UserEntity.getInstance();
        SearchDinamicaBean searchDBean=new SearchDinamicaBean();
        searchDBean.setEmail(emailsearch);
        SearchDinamicaController ctrl= new SearchDinamicaController();
        ctrl.searchInfo(searchDBean);
        System.out.println("search dinamica nome utente: "+user.getName());
        System.out.println("search dinamica cognnome utente: "+user.getSurname());
        System.out.println("search dinamica email utente: "+user.getEmail());


        String emailCl= user.getEmail();
        String nameCl= user.getName();
        String surnameCl= user.getSurname();

        UIController viewController = UIController.getUIControllerInstance();
        viewController.showForm(email,emailCl,nameCl,surnameCl);

    }
}






