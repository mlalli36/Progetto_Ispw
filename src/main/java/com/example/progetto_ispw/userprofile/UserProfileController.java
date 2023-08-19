package com.example.progetto_ispw.userprofile;

import com.example.progetto_ispw.login.LoginBean;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.user.UserDAO;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.worker.WorkerDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.example.progetto_ispw.utile.DBConnector.getConnector;

public class UserProfileController {
    public void userInfo(LoginBean bean) throws UserNotFoundException, IOException {
        UserDAO userDAO = new UserDAO();
        userDAO.getUserInfo(bean.getEmail());

        UserEntity user=UserEntity.getInstance();



        //beanPDin è la bean del profilo dinamica chiamata così per non avere più bean con numeri ed essere chiari
        UserProfileBean beanPDin= new UserProfileBean();
        beanPDin.setEmail(bean.getEmail());
        beanPDin.setName(user.getName());
        beanPDin.setSurname(user.getSurname());
      /*  UIController viewController = UIController.getUIControllerInstance();
        viewController.showUserProfile(beanPDin);*/



/*
login --> profilo   vv

- nel loginView passiamo la bean che prende la mail e la passiamo come input al controller del profilo    VV
- profiloController fa la query per trovare nome e cognome      VV
- profiloController scrive i risultati sul profiloBean          VV
- scrivimo nel UIController la profiloBean e poi il profiloView usa la bean precedentemente scritta nel UI
 */
    }

    public boolean verifica(UserProfileBean bean) {
       UserDAO dao= UserDAO.getInstance();
        String e= bean.getEmail();
        System.out.println("query nel ctrl:"+dao.getAppointmentforUser(e));
        if(dao.getAppointmentforUser(e)==null){return false;}else{
            return true;}
    }

    public void deleteAppoU(String email, String date, String time) {
        try (Connection con = getConnector()) {
            if (con == null)
                throw new SQLException();

            String query = "DELETE FROM `databaseispw`.`appointment_request` WHERE Client_email=? AND Date_appointment=? AND Time_date=?; ";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, date);
                preparedStatement.setString(3, time);

                System.out.println("UPC email :"+email);
                System.out.println("UPC date :"+date);
                System.out.println("UPC time :"+time);

                int del= preparedStatement.executeUpdate();
                if(del>0){System.out.println("Appuntamento eliminato!!");}else{System.out.println("Non c'erano appuntamenti da eliminare");}

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    }

