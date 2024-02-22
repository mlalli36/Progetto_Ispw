package com.example.progetto_ispw.home;

import com.example.progetto_ispw.geolocator.Geolocator;
import com.example.progetto_ispw.home.exception.AddressNotValidException;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.user.UserDAO;
import com.example.progetto_ispw.worker.WorkerDAO;
import com.example.progetto_ispw.worker.WorkerEntity;

import java.util.Comparator;
import java.util.List;

public class HomeController {
    private double radius;
    private boolean isDistanceImportant;
    private boolean isAvailabilityImportant;
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

        this.isDistanceImportant=bean.getIsDistanceIsImportant();
        this.isAvailabilityImportant=bean.getIsAvailabilityIsImportant();


        if (g.getLat(userAddress) == -1 || g.getLng(userAddress) == -1)
            throw new AddressNotValidException();


        this.radius = bean.getRadius();



        List<WorkerEntity> workerList = dao.getWorker(bean.getJobWork(), latitude, longitude, bean.getRadius(), bean.getDate());

        for (WorkerEntity worker : workerList) {

             ResultElement resultElement = new ResultElement();
            resultElement.setNameWorker(worker.getName());
            resultElement.setJobWork(worker.getWork());
            resultElement.setLocationWork(worker.getLocation());
            resultElement.setDescriptionWorker(worker.getDescription());
            resultElement.setEmailWorker(worker.getEmail());
            resultElement.setDistance(worker.getDistance());
            resultElement.setAvailability(worker.getAvailability());


             this.resultSet.addElement(resultElement);
        }
         assert !this.resultSet.getElements().isEmpty();

        this.evaluateIndexValues();
        bean.setResultSet(this.resultSet);
    }

    private void evaluateIndexValues() {
         for (ResultElement element : resultSet.getElements()) {
            element.setIndexValue(this.calculateIndexValue(element));
        }

        Comparator<ResultElement> indexValueComparator = Comparator.comparingDouble(ResultElement::getIndexValue);

         if (isAvailabilityImportant ) {
            indexValueComparator = indexValueComparator.reversed();
        }

        resultSet.getElements().sort(indexValueComparator);
    }



    private double calculateIndexValue(ResultElement element){

        double selectDistance= this.radius;
        double maxAvaibility=5;
        double highWeight = 2;
        double lowWeight = 1;
        double pondDist = isDistanceImportant ? highWeight : lowWeight;
        double pondAvailability = isAvailabilityImportant ? highWeight : lowWeight;
        double distValue=(element.getDistance()/selectDistance)*pondDist;
        double availabilityValue = (element.getAvailability()/(maxAvaibility))*pondAvailability;



        return (distValue + availabilityValue) ;
    }
}
