package com.example.progetto_ispw.userprofile;

import com.example.progetto_ispw.bookedServicesUser.BookedServicesUserBean;
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


    public void searchInfo(UserProfileBean bean) throws UserNotFoundException {
        UserDAO userDAO= UserDAO.getInstance();
        userDAO.getUserInfo(bean.getemailsearch());
    }
}

