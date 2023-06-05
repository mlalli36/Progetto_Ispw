package com.example.progetto_ispw.home;

import com.example.progetto_ispw.user.UserDAO;

import java.io.IOException;

public class HomeController {
    public void workInfo(HomeBean bean) throws IOException {
        UserDAO dao = UserDAO.getInstance();
        dao.getWorker(bean.getNameWork(), bean.getJobWork(),bean.getLocationWork() );
    }

}
