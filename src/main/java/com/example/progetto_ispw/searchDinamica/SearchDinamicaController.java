package com.example.progetto_ispw.searchDinamica;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.home.HomeBean;
import com.example.progetto_ispw.home.ResultElement;
import com.example.progetto_ispw.home.ResultSetEntity;
import com.example.progetto_ispw.worker.WorkerDAO;
import com.example.progetto_ispw.worker.WorkerEntity;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchDinamicaController {

    private ResultSetEntity resultSet= new ResultSetEntity();



    public void workInfo(HomeBean bean) throws IOException {
        WorkerDAO dao = WorkerDAO.getInstance();


       List<WorkerEntity> workerList = dao.getWorker(bean.getJobWork(), bean.getLocationWork());


            for (WorkerEntity worker : workerList) {
                //WorkerEntity currentWorker = dao.getWorker(bean.getNameWork(), entry.getKey(), bean.getLocationWork()); //carichiamo workerEntity dal DB
                //Si costruisce il ResultElement
                ResultElement resultElement = new ResultElement();
                //resultElement.setNameWorker(worker.getName());
                resultElement.setJobWork(worker.getWork());
                resultElement.setLocationWork(worker.getLocation());
                //Si aggiunge il ResultElement al ResultSet
                this.resultSet.addElement(resultElement);
            }
        //Se il result set è vuoto interrompe tutto perchè non dovrebbe succedere con "cris" "programmatrice" "roma"
            assert !this.resultSet.getElements().isEmpty();


            SearchDinamicaBean bean2 = new SearchDinamicaBean();
            bean2.setResultSet(this.resultSet);
//            SearchDinamicaView searchDinamicaView = new SearchDinamicaView();
//            searchDinamicaView.showResult(bean2);
            SearchDinamicaView.setBean2(bean2);
            UIController viewController = UIController.getUIControllerInstance();//è singletone
            viewController.showSearchDinamica();

        /*} else {
            System.out.println("resultset è null!");
        }*/
    }

}
