package com.example.progetto_ispw.fillform;

import com.example.progetto_ispw.fillform.exception.*;
import com.example.progetto_ispw.savehoursslots.SlotHoursEntity;
import com.example.progetto_ispw.worker.InfoAppoinEntity;
import com.example.progetto_ispw.worker.WorkerDAO;


public class FillFormController {




    // PRIMA COSA DA FARE è LA CORREZIONE DELL'ERRORE SE RIEMPI POI BENE I CAMPI (PROVA UN'ECCEZIONE E CAPIRAI)





    public void fill(FillFormBean bean) {
        WorkerDAO dao = WorkerDAO.getInstance();

        if(bean.getTime()==null){
            throw new NotValidTimeException("");
        }
        InfoAppoinEntity info =  dao.getAppointment(bean.getEmailWorker(), bean.getDate(), bean.getTime());

        if(info !=null && info.getWEmail().equals(bean.getEmailWorker()) && info.getDAppo().equals(bean.getDate()) && info.getTime().equals(bean.getTime())){
            throw new TimeAlreadySelectedException("The selected time is no longer valid.");
        }

        dao.addAppointment(bean.getEmailWorker(), bean.getName(),bean.getSurname(),bean.getEmailUser(),bean.getDate(),bean.getPhone(),bean.getDescription(),bean.getTime());

    }


    public void TakeSlot(FillFormBean bean) {
        String emailWorker = bean.getEmailWorker();
        String date = bean.getDate();
        System.out.println("FFC date: "+date);
        System.out.println("FFC email: "+emailWorker);


        WorkerDAO dao = WorkerDAO.getInstance();
        SlotHoursEntity result =  SlotHoursEntity.getInstance();
        result = dao.getSlots(emailWorker, date);
        System.out.println("result: "+result);
    }
}
