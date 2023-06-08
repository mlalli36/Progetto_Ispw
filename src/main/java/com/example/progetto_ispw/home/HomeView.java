package com.example.progetto_ispw.home;

import com.example.progetto_ispw.UIController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


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
    private HomeBean bean =new HomeBean();

    public void profileMethod(ActionEvent actionEvent) throws IOException {
        UIController viewController = UIController.getUIControllerInstance();//è singletone

        viewController.showProfiloDinamica();
    }

    public void favoritesMethod(ActionEvent actionEvent) {//da implementare
    }

    public void homeMethod(ActionEvent actionEvent) {  //da implementare
    }


    public void searchMethod(ActionEvent actionEvent) throws IOException {

        try{
            bean.setNameWork(nameWorkerTextField.getText());
            bean.setJobWork(jobWorkerTextField.getText());
            bean.setLocationWork(locationWorkerTextField.getText());
            HomeController controller = new HomeController();
            controller.workInfo(bean);


        }catch(IllegalArgumentException e){

        }
        UIController viewController = UIController.getUIControllerInstance();//è singletone
        viewController.showSearchDinamica();
    }
    ResultSetEntity resultSet = bean.getResultSet();
}
