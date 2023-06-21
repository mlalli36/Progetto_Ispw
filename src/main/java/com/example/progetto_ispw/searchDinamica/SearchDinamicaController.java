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

                //Si costruisce il ResultElement
                ResultElement resultElement = new ResultElement();
                resultElement.setNameWorker(worker.getName());
                resultElement.setJobWork(worker.getWork());
                resultElement.setLocationWork(worker.getLocation());
                resultElement.setDescriptionWorker(worker.getDescription());
                //Si aggiunge il ResultElement al ResultSet
                this.resultSet.addElement(resultElement);
            }
        //Se il result set è vuoto interrompe tutto perchè non dovrebbe succedere con "cris" "programmatrice" "roma"
            assert !this.resultSet.getElements().isEmpty();


            SearchDinamicaBean bean2 = new SearchDinamicaBean();
            bean2.setResultSet(this.resultSet);
            //trovare un modo per non farlo static
//            SearchDinamicaView.setBean2(bean2); -> questo lo usavamo per la classe statica;
        //il problema che abbiamo qui si può risolvere in vari modi : facendo la bean singleton (da evitare perchè la bean poi non può essere usata in paralello da qualcun altro e perchè poi dobbiamo usare qualcuno che ogni volta si assicura che è stata pulita)
        //usando il metodo static, ma non è mai consigliato (sentire audio fili su metodo static)
        //fare come "abbiamo" fatto : far gestire tutto al controller grafico (UIcontroller)-> è lui che dice al controller e alla view a quale bean si devono riferire -> in sostanza colleghiamo controller-bean2 e view-bean2 dicendo quale controller è presente sul file fxml per collegare il tutto.
            UIController viewController = UIController.getUIControllerInstance();//è singletone
            viewController.showSearchDinamica(bean2);

    }

}
