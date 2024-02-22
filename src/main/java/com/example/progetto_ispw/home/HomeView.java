package com.example.progetto_ispw.home;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.home.exception.AddressNotValidException;
import com.example.progetto_ispw.login.exception.UserNotFoundException;

import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.utile.CustomTilePane;
import com.example.progetto_ispw.worker.WorkerEmailEntity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;


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
    @FXML
    public ScrollPane scrollPane;
    @FXML

    public Text errorLabel;
    @FXML
    public String emailWorker;
    @FXML
    public CheckBox check5km;
    @FXML
    public CheckBox check10km;
    @FXML
    public CheckBox check20km;
    @FXML
    public TextField cityTextField;
    @FXML
    public TextField capTextField;

    private  UserEntity user = UserEntity.getInstance();



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


    public void searchMethod() throws IOException, AddressNotValidException {
            HomeBean bean= new HomeBean();
            String normalizedjobWorker= jobWorkerTextField.getText().toLowerCase();

            String normalizedlocationbWorker= locationWorkerTextField.getText().toLowerCase();
            String city= cityTextField.getText().toLowerCase();
            String cap= capTextField.getText().toLowerCase();
            bean.setJobWork(normalizedjobWorker);
            bean.setLocationWork(normalizedlocationbWorker);
            bean.setCity(city);
            bean.setCAP(cap);

            int radius = 0;

            if(check5km.isSelected()){
                radius=5;
            } else if (check10km.isSelected()) {
                radius=10;
            }else if(check20km.isSelected()){
                radius=20;
            }
        bean.setRadius(radius);

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



    public void showIntForm(ActionEvent event) throws UserNotFoundException {
         Button clickedButton =(Button) event.getSource();
         String email = (String) clickedButton.getUserData() ;


        HomeBean bean=new HomeBean();
        String emailsearch= user.getEmail();
        bean.setEmail(emailsearch);
        HomeController ctrl= new HomeController();
        ctrl.searchInfo(bean);


        String emailCl= user.getEmail();
        String nameCl= user.getName();
        String surnameCl= user.getSurname();

        UIController viewController = UIController.getUIControllerInstance();
        viewController.showForm(email,emailCl,nameCl,surnameCl);

    }




}


