package com.example.progetto_ispw.home;

import com.example.progetto_ispw.geolocator.Geolocator;
import com.example.progetto_ispw.home.exception.AddressNotValidException;
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

    public void workInfo(HomeBean bean) throws AddressNotValidException {
        WorkerDAO dao = WorkerDAO.getInstance();
        String userAddress = bean.getLocationWork();
        Geolocator g = Geolocator.getInstance();
        double latitude = g.getLat(userAddress);
        double longitude = g.getLng(userAddress);

        // Stampa le coordinate
        if (latitude != -1 && longitude != -1) {
            System.out.println("Coordinate per l'indirizzo '" + userAddress + "':");
            System.out.println("Latitudine: " + latitude);
            System.out.println("Longitudine: " + longitude);
        } else {
            System.out.println("Impossibile ottenere le coordinate per l'indirizzo '" + userAddress + "'.");
        }
        if (g.getLat(userAddress) == -1 || g.getLng(userAddress) == -1)
            throw new AddressNotValidException();

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
