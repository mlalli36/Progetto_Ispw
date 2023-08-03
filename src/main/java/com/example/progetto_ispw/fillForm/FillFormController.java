package com.example.progetto_ispw.fillForm;

import com.example.progetto_ispw.saveHoursSlots.SlotHoursEntity;
import com.example.progetto_ispw.worker.WorkerDAO;


public class FillFormController {
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
