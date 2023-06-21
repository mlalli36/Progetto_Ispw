package com.example.progetto_ispw.searchDinamica;


import com.example.progetto_ispw.home.ResultElement;
import com.example.progetto_ispw.home.ResultSetEntity; //vedere se è giusto
import com.example.progetto_ispw.utile.CustomTilePane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;


public class SearchDinamicaView{

    private static SearchDinamicaBean bean2;

    @FXML
    public Button profile;
    @FXML
    public Button favorites;
    @FXML
    public Button home;

    @FXML
    public Button fillOutForm;
    @FXML
    public VBox myVBox;
    @FXML
    public Pane paneDinamico;
    @FXML
    public ScrollPane scrollPane;

    public void profileMethod(ActionEvent actionEvent) { //da fare
    }

    public void favoritesMethod(ActionEvent actionEvent) { //da fare
    }

    public void homeMethod(ActionEvent actionEvent) { //da fare
    }


    public void showResult(SearchDinamicaBean bean2) throws IOException {
        //ScrollPane scrollPane=new ScrollPane();

        ResultSetEntity resultSet = bean2.getResultSet();

        CustomTilePane customTilePane = new CustomTilePane();
        customTilePane.createCustomTilePane();
        scrollPane.setVisible(true);


        for(ResultElement r: resultSet.getElements()){
            Button newButton = new Button("Fill out form");
            String name = r.getWorkerName();
            String jobWorker= r.getJobWorker();
            String locationWorker = r.getLocationWorker();
            customTilePane.addElements(newButton,name,jobWorker,locationWorker);

        }
        this.scrollPane.setContent(customTilePane.getCustomTP());

    }

    public static SearchDinamicaBean getBean2() {
        return bean2;
    }

    public static void setBean2(SearchDinamicaBean bean2) {
        SearchDinamicaView.bean2 = bean2;
    }

    @FXML
    public void initialize() throws IOException {
        this.showResult(bean2);
    }


}






