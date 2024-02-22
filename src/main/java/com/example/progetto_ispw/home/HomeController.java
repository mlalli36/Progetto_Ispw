package com.example.progetto_ispw.home;

import com.example.progetto_ispw.geolocator.Geolocator;
import com.example.progetto_ispw.home.exception.AddressNotValidException;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.user.UserDAO;
import com.example.progetto_ispw.worker.WorkerDAO;
import com.example.progetto_ispw.worker.WorkerEmailEntity;
import com.example.progetto_ispw.worker.WorkerEntity;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class HomeController {
    private double radius; // Raggio impostato dall'utente
    private boolean isDistanceImportant;
    private boolean isAvailableSlotImportant;
    private ResultSetEntity resultSet= new ResultSetEntity();
    public void searchInfo(HomeBean homeBean) throws UserNotFoundException {

        UserDAO userDAO= UserDAO.getInstance();
        userDAO.getUserInfo(homeBean.getemailsearch());
    }

    public void workInfo(HomeBean bean) throws AddressNotValidException {
        WorkerDAO dao = WorkerDAO.getInstance();
        String userAddress = bean.getLocation()+ ", " + bean.getCity() + ", " + bean.getCAP();
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


        this.radius = bean.getRadius();



        List<WorkerEntity> workerList = dao.getWorker(bean.getJobWork(), latitude, longitude, bean.getRadius());

        for (WorkerEntity worker : workerList) {

             ResultElement resultElement = new ResultElement();
            resultElement.setNameWorker(worker.getName());
            resultElement.setJobWork(worker.getWork());
            resultElement.setLocationWork(worker.getLocation());
            resultElement.setDescriptionWorker(worker.getDescription());
            resultElement.setEmailWorker(worker.getEmail());
            resultElement.setDistance(worker.getDistance());

            //Si aggiunge il ResultElement al ResultSet
            this.resultSet.addElement(resultElement);
        }
         assert !this.resultSet.getElements().isEmpty();

        this.evaluateIndexValues();
        bean.setResultSet(this.resultSet);
    }


    private void evaluateIndexValues() {

        //Setta l'indexValue di ogni ResultElement
        for (ResultElement element : resultSet.getElements())
            element.setIndexValue(this.calculateIndexValue(element));



        Comparator<ResultElement> indexValueComparator = Comparator.comparingDouble(ResultElement::getIndexValue);
        // Il comparatore compara gli index value dei ResultElement


        this.resultSet.getElements().sort(indexValueComparator); //ordiniamo gli elementi in ordine crescente d'indexValue


    }

    private double calculateIndexValue(ResultElement element){

        double selectDistance= this.radius;
        double maxAvaibleSlot=5;
        double highWeight = 5;
        double lowWeight = 1;
        double pondDist = isDistanceImportant ? highWeight : lowWeight;
        System.out.println("pondDist"+ pondDist);
        double pondAvailableSlot = isAvailableSlotImportant ? highWeight : lowWeight;
        double distValue=(element.getDistance()/selectDistance)*pondDist;


        return distValue;
    }
}
