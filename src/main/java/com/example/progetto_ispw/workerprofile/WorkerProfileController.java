package com.example.progetto_ispw.workerprofile;

import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.user.UserDAO;
import com.example.progetto_ispw.worker.WorkerDAO;

public class WorkerProfileController {
    public void searchInfo(WorkerProfileBean wPB) throws UserNotFoundException {

        UserDAO userDAO= UserDAO.getInstance();
        userDAO.getUserInfo(wPB.getemailsearch());
    }

    public boolean verfica(WorkerProfileBean bean) {
        WorkerDAO dao= WorkerDAO.getInstance();
        String e= bean.getemailsearch();
        System.out.println("query nel ctrl:"+dao.getAppointmentforWoker(e));
        if(dao.getAppointmentforWoker(e)==null){return false;}else{
        return true;}
    }
}
