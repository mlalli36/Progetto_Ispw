package com.example.progetto_ispw.profilesignup;

import com.example.progetto_ispw.geolocator.Geolocator;
import com.example.progetto_ispw.signup.exception.UserAlreadyExistsException;
import com.example.progetto_ispw.worker.WorkerDAO;
import com.example.progetto_ispw.worker.WorkerEntity;

public class ProfileSignUpController {

    public void signUpWorker(ProfileSignUpBean bean) throws UserAlreadyExistsException {

        //calcolo le coordinate del worker dall'indirizzo
        Geolocator g = Geolocator.getInstance();
        double lat = g.getLat(bean.getAddress());
        double lng = g.getLng(bean.getAddress());
        if (lat == -1 || lng == -1){
            throw new IllegalArgumentException("The address is incorrect, try again");
        }



        WorkerDAO dao = WorkerDAO.getInstance();
            dao.addWorker(bean.getEmail(),bean.getDescription(),bean.getWork(),bean.getName(), bean.getSurname(), bean.getAddress(),bean.getLocation(), lat, lng);
    }
}
