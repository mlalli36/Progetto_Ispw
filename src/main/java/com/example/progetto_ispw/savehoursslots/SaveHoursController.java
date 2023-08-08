package com.example.progetto_ispw.savehoursslots;

import com.example.progetto_ispw.savehoursslots.exception.TimeSlotAlreadyExistsException;
import com.example.progetto_ispw.worker.WorkerDAO;

public class SaveHoursController {
    public void saveHoursSlots(SaveHoursBean bean) throws TimeSlotAlreadyExistsException {
        WorkerDAO dao = WorkerDAO.getInstance();

        // Eseguire la query per ottenere lo slot dal database
        SlotHoursEntity slot = dao.getSlots(bean.getemail(), bean.getDateCalendar());
//secondo me è sbagliato qui, bisogna creare una lista; se la lista è vuola, aggiungi//////////////////////////////////////////////////////////////////////
        //controllo sull'email da controllare per vedere se utenti diversi prendono appuntamenti nello stesso giorno
       // dao.addSlots(bean.getemail(), bean.getSlot1(), bean.getSlot2(), bean.getSlot3(), bean.getSlot4(), bean.getSlot5(), bean.getDateCalendar());

        // Verificare se la mail e lo slot esistono nel database e confrontare le date
        if (slot != null && slot.getdate().equals(bean.getDateCalendar()) && slot.getemail().equals(bean.getemail())) {
            // print di controllo
            System.out.println("slot "+slot);
            System.out.println("slot email "+slot.getemail());
            System.out.println("bean email "+bean.getemail());
            System.out.println("slot date "+slot.getdate());
            System.out.println("bean date "+bean.getDateCalendar());
            System.out.println("bean date "+bean.getDateCalendar());

                throw new TimeSlotAlreadyExistsException("Lo data selezionato è già esistente");

        }

        // Se lo slot non esiste o le date non corrispondono, aggiungere lo slot al database
        dao.addSlots(bean.getemail(), bean.getSlot1(), bean.getSlot2(), bean.getSlot3(), bean.getSlot4(), bean.getSlot5(), bean.getDateCalendar());
    }
}




/*
public class SaveHoursController {
    public void saveHoursSlots(SaveHoursBean bean) throws TimeSlotAlreadyExistsException {

            WorkerDAO dao = WorkerDAO.getInstance();

            dao.addSlots(bean.getemail(),bean.getSlot1(), bean.getSlot2(), bean.getSlot3(), bean.getSlot4(), bean.getSlot5(), bean.getDateCalendar());
            dao.getSlots(bean.getemail(), bean.getDateCalendar());


/*
        SlotHoursEntity shEntity= new SlotHoursEntity();
        String slot1= shEntity.getSlot1();
        String slot2= shEntity.getSlot2();
        String slot3= shEntity.getSlot3();
        String slot4= shEntity.getSlot4();
        String slot5= shEntity.getSlot5();
        String date= shEntity.getdate() ;

        System.out.println(date);
        System.out.println("1 "+slot1);
        System.out.println("2 "+slot2);
        System.out.println("3 "+slot3);
        System.out.println("4 "+slot4);
        System.out.println("5 "+slot5);


        if (date.equals(bean.getDateCalendar()) &&
                (slot1.equals(bean.getSlot1())|
                slot1.equals(bean.getSlot2())|
                slot1.equals(bean.getSlot3())|
                slot1.equals(bean.getSlot4())|
                slot1.equals(bean.getSlot5())|

                    slot2.equals(bean.getSlot1())|
                    slot2.equals(bean.getSlot2())|
                    slot2.equals(bean.getSlot3())|
                    slot2.equals(bean.getSlot4())|
                    slot2.equals(bean.getSlot5())|

                    slot3.equals(bean.getSlot1())|
                    slot3.equals(bean.getSlot2())|
                    slot3.equals(bean.getSlot3())|
                    slot3.equals(bean.getSlot4())|
                    slot3.equals(bean.getSlot5())|

                    slot4.equals(bean.getSlot1())|
                    slot4.equals(bean.getSlot2())|
                    slot4.equals(bean.getSlot3())|
                    slot4.equals(bean.getSlot4())|
                    slot4.equals(bean.getSlot5())|

                    slot5.equals(bean.getSlot1())|
                    slot5.equals(bean.getSlot2())|
                    slot5.equals(bean.getSlot3())|
                    slot5.equals(bean.getSlot4())|
                    slot5.equals(bean.getSlot5())
            )
            )

        {throw new TimeSlotAlreadyExistsException("Lo slot selezione è già esistente");

        }
        dao.addSlots(bean.getemail(),bean.getSlot1(), bean.getSlot2(), bean.getSlot3(), bean.getSlot4(), bean.getSlot5(), bean.getDateCalendar());

*/
/*
    }




}*/
