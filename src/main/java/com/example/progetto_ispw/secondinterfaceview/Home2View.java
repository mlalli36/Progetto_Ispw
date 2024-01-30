package com.example.progetto_ispw.secondinterfaceview;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.home.HomeBean;
import com.example.progetto_ispw.home.HomeController;
import com.example.progetto_ispw.home.ResultElement;
import com.example.progetto_ispw.home.ResultSetEntity;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.utile.CustomTilePane;
import com.example.progetto_ispw.worker.WorkerEmailEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class Home2View {
    @FXML
    public TextField jobWorkerTextField;
    @FXML
    public TextField locationWorkerTextField;
    @FXML
    public Button searchButton;
    @FXML
    public Button profileButton;
    @FXML
    public Button homeButton;
    @FXML
    public AnchorPane anchorPaneHome;

    public Text errorLabel;

    public ScrollPane scrollPane;
    public String emailWorker;


    private  UserEntity user = UserEntity.getInstance();

    public void searchMethod() throws IOException {
        HomeBean bean= new HomeBean();
        String normalizedjobWorker= jobWorkerTextField.getText().toLowerCase();

        String normalizedlocationbWorker= locationWorkerTextField.getText().toLowerCase();
        bean.setJobWork(normalizedjobWorker);
        bean.setLocationWork(normalizedlocationbWorker);

        HomeController controller= new HomeController();
        controller.workInfo(bean);

        ResultSetEntity resultSet = bean.getResultSet();
        if (resultSet.getElements().isEmpty()) {

            this.errorLabel.setOpacity(1);

        }else {
            CustomTilePane customTilePane = new CustomTilePane();
            customTilePane.createCustomTilePane();
            scrollPane.setVisible(true);


            for (ResultElement r : resultSet.getElements()) {
                Button newButton = new Button("Fill out form");

                String name = r.getWorkerName();
                String jobWorker = r.getJobWorker();
                String locationWorker = r.getLocationWorker();
                String descriptionWorker = r.getWorkerDescription();
                emailWorker = r.getWorkerEmail();
                newButton.setUserData(emailWorker);

                customTilePane.addElements(name, jobWorker, locationWorker, descriptionWorker, newButton, emailWorker);

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

    }


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
            wkE.setEmailWEE(emailsearch);
            viewController.insertInfoWorker(namesearch,surnamesearch,emailsearch);
        }

    }

    public void homeMethod(ActionEvent actionEvent) throws IOException {
        UIController controller= UIController.getUIControllerInstance();
        controller.showHome();
    }

    public void showIntForm(ActionEvent event) throws UserNotFoundException {
        // tieniamo traccia del bottone che abbiamo premuto
        Button clickedButton =(Button) event.getSource();
        // tieniamo traccia dell'email associata a quel bottone
        String email = (String) clickedButton.getUserData() ;


        HomeBean bean=new HomeBean();
        String emailsearch= user.getEmail();
        bean.setEmail(emailsearch);
        HomeController ctrl= new HomeController();
        ctrl.searchInfo(bean);
        System.out.println("search dinamica nome utente: "+user.getName());
        System.out.println("search dinamica cognnome utente: "+user.getSurname());
        System.out.println("search dinamica email utente: "+user.getEmail());
        System.out.println("search dinamica email worker in form: "+emailWorker);


        String emailCl= user.getEmail();
        String nameCl= user.getName();
        String surnameCl= user.getSurname();

        UIController viewController = UIController.getUIControllerInstance();
        viewController.showForm(email,emailCl,nameCl,surnameCl);

    }



}
