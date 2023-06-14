package com.example.progetto_ispw.searchDinamica;

import com.example.progetto_ispw.home.HomeBean;
import com.example.progetto_ispw.home.ResultElement;
import com.example.progetto_ispw.home.ResultSetEntity;
import com.example.progetto_ispw.worker.WorkerDAO;
import com.example.progetto_ispw.worker.WorkerEntity;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchDinamicaController {
    private ResultSetEntity resultSet= new ResultSetEntity();
    private SearchDinamicaView searchDinamicaView= new SearchDinamicaView();


    public void workInfo(HomeBean bean) throws IOException {
        WorkerDAO dao = WorkerDAO.getInstance();
        dao.getWorker(bean.getNameWork(), bean.getJobWork(),bean.getLocationWork());

        Map<String, String> JobWork = new HashMap<>(); // attenzione a questa dichiarazione, da controllare se funziona!!!
   if(resultSet!=null){
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
   }else{System.out.println("resultset è null!");
    }
    }

}
