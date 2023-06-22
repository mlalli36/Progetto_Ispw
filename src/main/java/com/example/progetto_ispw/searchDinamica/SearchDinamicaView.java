package com.example.progetto_ispw.searchDinamica;


import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.home.ResultElement;
import com.example.progetto_ispw.home.ResultSetEntity; //vedere se è giusto
import com.example.progetto_ispw.user.UserDAO;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.utile.CustomTilePane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
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

    public void profileMethod(ActionEvent actionEvent)throws IOException {
        UIController viewController = UIController.getUIControllerInstance();//è singletone
        viewController.showProfilo();
        //non sappiamo se bisogna distinguere worker da client qui
        /*UserEntity userEntity = UserEntity.getInstance();
        String tp = userEntity.getTipoaccesso();
        if(tp == "Worker") {
            UIController viewController = UIController.getUIControllerInstance();//è singletone
            viewController.showProfileSignUp();
        } else{
            UIController viewController = UIController.getUIControllerInstance();//è singletone
            viewController.showProfileMyDetails();
        }*/
    }

    public void favoritesMethod(ActionEvent actionEvent) { //da fare
    }

    public void homeMethod(ActionEvent actionEvent) throws IOException { //da fare
        UIController viewController = UIController.getUIControllerInstance();//è singletone

        viewController.showHome();
    }

 /*   @FXML
    public void initialize() throws IOException {
        this.showResult(bean2);
    }*/
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

            customTilePane.addElements(name,jobWorker,locationWorker,descriptionWorker,newButton);
            newButton.setOnAction(event -> {
                try {
                    showIntForm();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        }
        this.scrollPane.setContent(customTilePane.getCustomTP());

    }

    public void showIntForm() throws IOException{
        UIController viewController = UIController.getUIControllerInstance();
        viewController.showForm();

    }

    //public void setBean2(SearchDinamicaBean bean2) {
        //this.bean2 = bean2;
   // }




}






