package com.example.progetto_ispw.saveHoursSlots;

import com.example.progetto_ispw.saveHoursSlots.exception.TimeSlotAlreadyExistsException;
import com.example.progetto_ispw.worker.WorkerDAO;
import com.example.progetto_ispw.worker.WorkerEntity;

public class SaveHoursController {
    public void saveHoursSlots(SaveHoursBean bean) {
        try {
            WorkerDAO dao = WorkerDAO.getInstance();
            WorkerEntity workerEmail = new WorkerEntity();
            dao.addSlots(workerEmail.getEmail(), bean.getSlot1(), bean.getSlot2(), bean.getSlot3(), bean.getSlot4(), bean.getSlot5(), bean.getDateCalendar());

            //dobbiamo scrivere la query nel workerDAO
        } catch (TimeSlotAlreadyExistsException e) {
            // Gestisci l'eccezione qui, ad esempio, mostrando un messaggio di errore all'utente.
            e.printStackTrace(); // o qualsiasi altra azione di gestione dell'errore desiderata
        }
    }
}
