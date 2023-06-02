package com.example.progetto_ispw.profileSignUp;

import com.example.progetto_ispw.signup.exception.UserAlreadyExistsException;
import com.example.progetto_ispw.user.UserDAO;

public class ProfileSignUpViewController {

    public void signUpWorker(ProfileSignUpViewBean bean) throws UserAlreadyExistsException {
    UserDAO dao = UserDAO.getInstance();
    dao.addWorker(bean.getEmail(),bean.getDescription(),bean.getWork(),bean.getName(), bean.getSurname(), bean.getAddress(),bean.getLocation());
    }
}
