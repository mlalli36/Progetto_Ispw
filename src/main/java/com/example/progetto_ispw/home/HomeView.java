package com.example.progetto_ispw.home;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.searchDinamica.SearchDinamicaController;
import com.example.progetto_ispw.user.UserEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;

public class HomeView {
    @FXML
    public AnchorPane anchorPaneHome;
    @FXML
    public Button profile;
    @FXML
    public Button favorites;
    @FXML
    public Button home;
    @FXML
    public TextField nameWorkerTextField;
    @FXML
    public TextField jobWorkerTextField;
    @FXML
    public TextField locationWorkerTextField;
    @FXML
    public Button searchButton;




    public void profileMethod(ActionEvent actionEvent) throws IOException {
        UserEntity user = UserEntity.getInstance();
        String type = user.getTipoaccesso();
        System.out.println(type);
        UIController viewController = UIController.getUIControllerInstance();//è singletone


        if(!"Worker".equals(type)) {
            viewController.showProfiloDinamica();
        } else{
            viewController.showProfilo();
        }

    }

    public void favoritesMethod(ActionEvent actionEvent) {//da implementare
    }

    public void homeMethod(ActionEvent actionEvent) {  //da implementare
    }


    public void searchMethod() throws IOException {
            HomeBean bean= new HomeBean();
            bean.setNameWork(nameWorkerTextField.getText());
            bean.setJobWork(jobWorkerTextField.getText());
            bean.setLocationWork(locationWorkerTextField.getText());

            SearchDinamicaController searchController= new SearchDinamicaController();
            searchController.workInfo(bean);


    }

}
