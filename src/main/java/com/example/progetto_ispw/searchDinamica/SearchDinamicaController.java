package com.example.progetto_ispw.searchDinamica;

import com.example.progetto_ispw.home.HomeBean;
import com.example.progetto_ispw.home.ResultElement;
import com.example.progetto_ispw.home.ResultSetEntity;
import com.example.progetto_ispw.worker.WorkerDAO;
import com.example.progetto_ispw.worker.WorkerEntity;

import java.util.List;
import java.util.Map;

public class SearchDinamicaController {
    private ResultSetEntity resultSet;
    private SearchDinamicaView searchDinamicaView;


    public void workInfo(HomeBean bean){
        WorkerDAO dao = WorkerDAO.getInstance();
        dao.getWorker(bean.getNameWork(), bean.getJobWork(),bean.getLocationWork());

        Map<String, String> JobWork = null; // attenzione a questa dichiarazione, da controllare se funziona!!!|
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
        SearchDinamicaBean bean2 = new SearchDinamicaBean();
        bean2.setResultSet(this.resultSet);
        searchDinamicaView.showResult(bean2);
    }

}
