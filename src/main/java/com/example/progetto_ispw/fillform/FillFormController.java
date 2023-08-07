package com.example.progetto_ispw.fillform;

import com.example.progetto_ispw.fillform.exception.TimeAlreadySelectedException;
import com.example.progetto_ispw.saveHoursSlots.SlotHoursEntity;
import com.example.progetto_ispw.saveHoursSlots.exception.TimeSlotAlreadyExistsException;
import com.example.progetto_ispw.worker.InfoAppoinEntity;
import com.example.progetto_ispw.worker.WorkerDAO;


public class FillFormController {


    public void fill(FillFormBean bean) {
        WorkerDAO dao = WorkerDAO.getInstance();
        dao.getAppointment(bean.getEmailWorker());

        InfoAppoinEntity iae= new InfoAppoinEntity();

        String emailWorkerCheck= iae.getWEmail();
        String dayDate= iae.getDAppo();  //giorno
        String timeDate= iae.getTime();  //slot
        if("emailWorkerCheck".equals(bean.getEmailWorker()) && "dayDate".equals(bean.getDate()) && "timeDate".equals(bean.getTime()) ){
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
