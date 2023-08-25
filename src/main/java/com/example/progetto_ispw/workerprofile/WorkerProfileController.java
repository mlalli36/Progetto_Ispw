package com.example.progetto_ispw.workerprofile;

import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.user.UserDAO;
import com.example.progetto_ispw.worker.InfoAppoinEntity;
import com.example.progetto_ispw.worker.WorkerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static com.example.progetto_ispw.utile.DBConnector.getConnector;

public class WorkerProfileController {
    public void searchInfo(WorkerProfileBean wPB) throws UserNotFoundException {

        UserDAO userDAO= UserDAO.getInstance();
        userDAO.getUserInfo(wPB.getemailsearch());
    }


    private AppointmentResultEntity appointmentResultSet = new AppointmentResultEntity();


    public void deleteAppoW(String email, String date, String time) {
        try (Connection con = getConnector()) {
            if (con == null)
                throw new SQLException();

            String query = "DELETE FROM `databaseispw`.`appointment_request` WHERE Worker_email=? AND Date_appointment=? AND Time_date=?; ";
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
