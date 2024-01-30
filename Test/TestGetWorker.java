import com.example.progetto_ispw.home.HomeBean;
import com.example.progetto_ispw.home.HomeController;
import com.example.progetto_ispw.home.ResultSetEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


//Author: Pamela Longo
    public class TestGetWorker {
        @Test
        void testGetWorker(){
            /* Vogliamo testare la correttezza dell'output prodotto dal metodo searchMethod() di HomeView,
             * che ha la funzionalità di restituire la lista dei worker nel luogo e del tipo inseriti dal cliente per la ricerca
             */
            HomeBean bean= new HomeBean();
            bean.setLocationWork("agnone");
            bean.setJobWork("sarto");

            HomeController controller= new HomeController();
            controller.workInfo(bean);

            ResultSetEntity resultSet = bean.getResultSet();
            System.out.println("mi chiamo: "+ resultSet.getElements().get(0).getWorkerName()+ ", sono: " + resultSet.getElements().get(0).getJobWorker() + ", mi trovo:"+
                    resultSet.getElements().get(0).getLocationWorker()+", per conoscere meglio: "+ resultSet.getElements().get(0).getWorkerDescription()+", la mail è: "+ resultSet.getElements().get(0).getWorkerEmail());
            boolean isCorrect = resultSet.getElements().size() == 1 && !(resultSet.getElements().get(0).getLocationWorker()=="agnone") && !(resultSet.getElements().get(0).getJobWorker()=="sarto");
            assertTrue(isCorrect);
        }
    }


