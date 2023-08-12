package com.example.progetto_ispw.home;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.searchdinamica.SearchDinamicaController;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.worker.WorkerEmailEntity;
import com.example.progetto_ispw.worker.WorkerEntity;
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




    public void profileMethod(ActionEvent actionEvent) throws IOException, UserNotFoundException {
        UserEntity user = UserEntity.getInstance();
        String type = user.getTipoaccesso();
        System.out.println(type);
        UIController viewController = UIController.getUIControllerInstance();//è singletone

        String emailsearch= user.getEmail();
        HomeBean homeBean=new HomeBean();
        homeBean.setEmail(emailsearch);
        HomeController homeController=new HomeController();
        homeController.searchInfo(homeBean);
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

    public void favoritesMethod(ActionEvent actionEvent) {//da implementare
    }

    public void homeMethod(ActionEvent actionEvent) throws IOException {
        UIController controller= UIController.getUIControllerInstance();
        controller.showHome();
    }


    public void searchMethod() throws IOException {
            HomeBean bean= new HomeBean();
            String normalizedjobWorker= jobWorkerTextField.getText().toLowerCase();

            String normalizedlocationbWorker= locationWorkerTextField.getText().toLowerCase();
            bean.setJobWork(normalizedjobWorker);
            bean.setLocationWork(normalizedlocationbWorker);

            SearchDinamicaController searchController= new SearchDinamicaController();
            searchController.workInfo(bean);


    }

}
