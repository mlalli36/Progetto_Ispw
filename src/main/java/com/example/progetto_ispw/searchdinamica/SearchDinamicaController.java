package com.example.progetto_ispw.searchdinamica;


import com.example.progetto_ispw.home.ResultSetEntity;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.user.UserDAO;




public class SearchDinamicaController {

   private ResultSetEntity resultSet= new ResultSetEntity();



    public void searchInfo(SearchDinamicaBean searchDBean) throws UserNotFoundException {

        UserDAO userDAO= UserDAO.getInstance();
        userDAO.getUserInfo(searchDBean.getemailsearch());
    }
}
