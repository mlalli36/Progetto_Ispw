package com.example.progetto_ispw.home;

import com.example.progetto_ispw.geolocator.Geolocator;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.user.UserDAO;
import com.example.progetto_ispw.worker.WorkerDAO;
import com.example.progetto_ispw.worker.WorkerEmailEntity;
import com.example.progetto_ispw.worker.WorkerEntity;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class HomeController {
    private ResultSetEntity resultSet= new ResultSetEntity();
    public void searchInfo(HomeBean homeBean) throws UserNotFoundException {

        UserDAO userDAO= UserDAO.getInstance();
        userDAO.getUserInfo(homeBean.getemailsearch());
    }

    public void workInfo(HomeBean bean) {
        WorkerDAO dao = WorkerDAO.getInstance();
        Geolocator g = Geolocator.getInstance();

        List<WorkerEntity> workerList = dao.getWorker(bean.getJobWork(), g.getLat(bean.getLocationWork()), g.getLng(bean.getLocationWork()), bean.getRadius());

      // List<WorkerEntity> workerList = dao.getWorker(bean.getJobWork(), bean.getLocationWork());

        for (WorkerEntity worker : workerList) {

             ResultElement resultElement = new ResultElement();
            resultElement.setNameWorker(worker.getName());
            resultElement.setJobWork(worker.getWork());
            resultElement.setLocationWork(worker.getLocation());
            resultElement.setDescriptionWorker(worker.getDescription());
            resultElement.setEmailWorker(worker.getEmail());
            //Si aggiunge il ResultElement al ResultSet
            this.resultSet.addElement(resultElement);
        }
         assert !this.resultSet.getElements().isEmpty();


        bean.setResultSet(this.resultSet);
    }
}
