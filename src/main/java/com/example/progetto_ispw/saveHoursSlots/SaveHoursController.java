package com.example.progetto_ispw.saveHoursSlots;

import com.example.progetto_ispw.saveHoursSlots.exception.TimeSlotAlreadyExistsException;
import com.example.progetto_ispw.signup.exception.UserAlreadyExistsException;
import com.example.progetto_ispw.worker.WorkerDAO;

public class SaveHoursController {
    public void saveHoursSlots(SaveHoursBean bean) throws TimeSlotAlreadyExistsException {
        WorkerDAO dao = WorkerDAO.getInstance();
        dao.addSlots(bean.getSlot1(),bean.getSlot2(), bean.getSlot3(), bean.getSlot4(), bean.getSlot5());

        //dobbiamo scrivere la query nel workerDAO
    }
}
