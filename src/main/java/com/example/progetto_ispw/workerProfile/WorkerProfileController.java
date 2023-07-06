package com.example.progetto_ispw.workerProfile;

import com.example.progetto_ispw.home.HomeBean;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.user.UserDAO;

public class WorkerProfileController {
    public void searchInfo(WorkerProfileBean wPB) throws UserNotFoundException {

        UserDAO userDAO= UserDAO.getInstance();
        userDAO.getUserInfo(wPB.getemailsearch());
    }
}
