package com.example.progetto_ispw.savehoursslots;

import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.savehoursslots.exception.TimeSlotAlreadyExistsException;
import com.example.progetto_ispw.user.UserDAO;
import com.example.progetto_ispw.worker.WorkerDAO;

public class SaveHoursController {
    public void saveHoursSlots(SaveHoursBean bean) throws TimeSlotAlreadyExistsException {
        WorkerDAO dao = WorkerDAO.getInstance();

         SlotHoursEntity slot = dao.getSlots(bean.getemail(), bean.getDateCalendar());


         if (slot != null && slot.getdate().equals(bean.getDateCalendar()) && slot.getemail().equals(bean.getemail())) {



            throw new TimeSlotAlreadyExistsException("Lo data selezionato è già esistente");

        }

         dao.addSlots(bean.getemail(), bean.getSlot1(), bean.getSlot2(), bean.getSlot3(), bean.getSlot4(), bean.getSlot5(), bean.getDateCalendar());
        SlotHoursEntity slotHoursEntity= SlotHoursEntity.getInstance();


        SlotHours slotHours=slotHoursEntity.getSlotHours();

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





