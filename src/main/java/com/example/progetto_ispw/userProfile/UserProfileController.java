package com.example.progetto_ispw.userProfile;

import com.example.progetto_ispw.login.LoginBean;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.user.UserDAO;
import com.example.progetto_ispw.user.UserEntity;

import java.io.IOException;

public class UserProfileController {
    public void userInfo(LoginBean bean) throws UserNotFoundException, IOException {
        UserDAO userDAO = new UserDAO();
        userDAO.getUserInfo(bean.getEmail());

        UserEntity user=UserEntity.getInstance();



        //beanPDin è la bean del profilo dinamica chiamata così per non avere più bean con numeri ed essere chiari
        UserProfileBean beanPDin= new UserProfileBean();
        beanPDin.setEmail(bean.getEmail());
        beanPDin.setName(user.getName());
        beanPDin.setSurname(user.getSurname());
      /*  UIController viewController = UIController.getUIControllerInstance();
        viewController.showUserProfile(beanPDin);*/



/*
login --> profilo   vv

- nel loginView passiamo la bean che prende la mail e la passiamo come input al controller del profilo    VV
- profiloController fa la query per trovare nome e cognome      VV
- profiloController scrive i risultati sul profiloBean          VV
- scrivimo nel UIController la profiloBean e poi il profiloView usa la bean precedentemente scritta nel UI
 */
    }
}
