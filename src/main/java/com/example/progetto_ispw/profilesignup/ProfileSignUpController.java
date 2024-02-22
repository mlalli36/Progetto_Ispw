package com.example.progetto_ispw.profilesignup;

import com.example.progetto_ispw.geolocator.Geolocator;
import com.example.progetto_ispw.signup.exception.UserAlreadyExistsException;
import com.example.progetto_ispw.worker.WorkerDAO;
import com.example.progetto_ispw.worker.WorkerEntity;

public class ProfileSignUpController {

    public void signUpWorker(ProfileSignUpBean bean) throws UserAlreadyExistsException {
        String userAddress = bean.getAddress()+ ", " + bean.getLocation() + ", " + bean.getCap();
        //calcolo le coordinate del worker dall'indirizzo
        Geolocator g = Geolocator.getInstance();
        double lat = g.getLat(userAddress);
        double lng = g.getLng(userAddress);
        System.out.println("lat"+lat);
        System.out.println("lng"+lng);
        if (lat == -1 || lng == -1){
            throw new IllegalArgumentException("The address is incorrect, try again");
        }



        WorkerDAO dao = WorkerDAO.getInstance();
            dao.addWorker(bean.getEmail(),bean.getDescription(),bean.getWork(),bean.getName(), bean.getSurname(), bean.getAddress(),bean.getLocation(), lat, lng);
    }
}
