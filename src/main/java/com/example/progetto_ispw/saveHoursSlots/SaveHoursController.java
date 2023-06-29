package com.example.progetto_ispw.saveHoursSlots;

import com.example.progetto_ispw.saveHoursSlots.exception.TimeSlotAlreadyExistsException;
import com.example.progetto_ispw.worker.WorkerDAO;
import com.example.progetto_ispw.worker.WorkerEntity;

public class SaveHoursController {
    public void saveHoursSlots(SaveHoursBean bean) {
        try {
            WorkerDAO dao = WorkerDAO.getInstance();
            WorkerEntity workerEmail = new WorkerEntity();
         //   System.out.println(bean.getemail());
            System.out.println(bean.getSlot1());
            System.out.println(bean.getSlot2());
            System.out.println(bean.getSlot3());
            System.out.println(bean.getSlot4());
            System.out.println(bean.getSlot5());
            System.out.println(bean.getDateCalendar());
            System.out.println(workerEmail.getEmail());

            dao.addSlots(/*bean.getemail(),*/workerEmail.getEmail(), bean.getSlot1(), bean.getSlot2(), bean.getSlot3(), bean.getSlot4(), bean.getSlot5(), bean.getDateCalendar());


            //dobbiamo scrivere la query nel workerDAO
        } catch (TimeSlotAlreadyExistsException e) {
            System.out.println("Lo slot selezionato è già impostato!!");
            // Gestisci l'eccezione qui, ad esempio, mostrando un messaggio di errore all'utente.
            e.printStackTrace(); // o qualsiasi altra azione di gestione dell'errore desiderata
        }
    }




}
