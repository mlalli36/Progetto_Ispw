package com.example.progetto_ispw.fillForm;

import com.example.progetto_ispw.saveHoursSlots.SlotHoursEntity;
import com.example.progetto_ispw.worker.WorkerDAO;


public class FillFormController {
    public void TakeSlot(FillFormBean bean) {
        String emailWorker = bean.getEmailWorker();
        String date = bean.getDate();
        WorkerDAO dao = WorkerDAO.getInstance();
        SlotHoursEntity result = new SlotHoursEntity();
        result = dao.getSlots(emailWorker, date);

    }
}
