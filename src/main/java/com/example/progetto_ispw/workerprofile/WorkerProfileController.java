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







}
