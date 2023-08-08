package com.example.progetto_ispw.profilesignup;

import com.example.progetto_ispw.signup.exception.UserAlreadyExistsException;
import com.example.progetto_ispw.worker.WorkerDAO;

public class ProfileSignUpController {

    public void signUpWorker(ProfileSignUpBean bean) throws UserAlreadyExistsException {
    WorkerDAO dao = WorkerDAO.getInstance();
    dao.addWorker(bean.getEmail(),bean.getDescription(),bean.getWork(),bean.getName(), bean.getSurname(), bean.getAddress(),bean.getLocation());
    }
}
