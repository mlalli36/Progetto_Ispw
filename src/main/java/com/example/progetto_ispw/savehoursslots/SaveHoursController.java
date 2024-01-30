package com.example.progetto_ispw.savehoursslots;

import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.savehoursslots.exception.TimeSlotAlreadyExistsException;
import com.example.progetto_ispw.user.UserDAO;
import com.example.progetto_ispw.worker.WorkerDAO;

public class SaveHoursController {
    public void saveHoursSlots(SaveHoursBean bean) throws TimeSlotAlreadyExistsException {
        WorkerDAO dao = WorkerDAO.getInstance();

        // Eseguire la query per ottenere lo slot dal database
        SlotHoursEntity slot = dao.getSlots(bean.getemail(), bean.getDateCalendar());

        // Verificare se la mail e lo slot esistono nel database e confrontare le date
        if (slot != null && slot.getdate().equals(bean.getDateCalendar()) && slot.getemail().equals(bean.getemail())) {
            // print di controllo
            System.out.println("slot "+slot);
            System.out.println("slot email "+slot.getemail());
            System.out.println("bean email "+bean.getemail());
            System.out.println("slot date "+slot.getdate());
            System.out.println("bean date "+bean.getDateCalendar());


            throw new TimeSlotAlreadyExistsException("Lo data selezionato è già esistente");

        }

        // Se lo slot non esiste o le date non corrispondono, aggiungere lo slot al database
        dao.addSlots(bean.getemail(), bean.getSlot1(), bean.getSlot2(), bean.getSlot3(), bean.getSlot4(), bean.getSlot5(), bean.getDateCalendar());
        SlotHoursEntity slotHoursEntity= SlotHoursEntity.getInstance();


        SlotHours slotHours=slotHoursEntity.getSlotHours();

        // Inizializza slotHours se non è stato ancora fatto(utile per il test)
        if (slotHours == null) {
            slotHours = new SlotHours();
        }

        slotHours.setState(true);
    }

    public void searchInfo(SaveHoursBean bean) throws UserNotFoundException {
        UserDAO userDAO= UserDAO.getInstance();
        userDAO.getUserInfo(bean.getemailsearch());
    }






    }





