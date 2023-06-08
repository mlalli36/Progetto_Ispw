package com.example.progetto_ispw.home;

import com.example.progetto_ispw.user.UserDAO;
import com.example.progetto_ispw.worker.WorkerDAO;
import com.example.progetto_ispw.worker.WorkerEntity;

import java.io.IOException;
import java.util.Map;

public class HomeController {
    private ResultSetEntity resultSet;
    public void workInfo(HomeBean bean) throws IOException {
        WorkerDAO dao = WorkerDAO.getInstance();
        dao.getWorker(bean.getNameWork(), bean.getJobWork(),bean.getLocationWork());
        Map<String, String> JobWork = null;
        for(Map.Entry<String, String> entry : JobWork.entrySet()){
            WorkerEntity currentWorker= dao.getWorker(bean.getNameWork(), entry.getKey(), bean.getLocationWork()); //carichiamo workerEntity dal DB
            //Si costruisce il ResultElement
            ResultElement resultElement = new ResultElement();
            resultElement.setNameWorker(currentWorker.getName());
            resultElement.setJobWork(currentWorker.getWork());
            resultElement.setLocationWork(currentWorker.getLocation());
            //Si aggiunge il ResultElement al ResultSet
            this.resultSet.addElement(resultElement);
        }
        bean.setResultSet(this.resultSet);

    }

}
