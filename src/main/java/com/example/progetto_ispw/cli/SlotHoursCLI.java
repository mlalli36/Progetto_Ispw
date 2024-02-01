package com.example.progetto_ispw.cli;

import com.example.progetto_ispw.savehoursslots.SaveHoursBean;
import com.example.progetto_ispw.savehoursslots.SaveHoursController;
import com.example.progetto_ispw.savehoursslots.SlotHoursEntity;
import com.example.progetto_ispw.savehoursslots.exception.InvalidTimeException;
import com.example.progetto_ispw.savehoursslots.exception.TimeSlotAlreadyExistsException;
import com.example.progetto_ispw.savehoursslots.observer.Observer;
import com.example.progetto_ispw.user.UserEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class SlotHoursCLI implements Observer {

    public SlotHoursCLI() {
        SlotHoursEntity.getInstance().getSlotHours().attach(this);
    }
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public void slotHoursMethod(String emailsearch) {
        try {
            SaveHoursBean bean = new SaveHoursBean();

            bean.setEmail(emailsearch);
            System.out.println("email:"+emailsearch);

            // Simulate inputting slot hours
            System.out.println("Enter slot 1:");
            String slot1 = reader.readLine();
            bean.setSlot1(slot1);

            System.out.println("Enter slot 2:");
            String slot2 = reader.readLine();
            bean.setSlot2(slot2);

            System.out.println("Enter slot 3:");
            String slot3 = reader.readLine();
            bean.setSlot3(slot3);

            System.out.println("Enter slot 4:");
            String slot4 = reader.readLine();
            bean.setSlot4(slot4);

            System.out.println("Enter slot 5:");
            String slot5 = reader.readLine();
            bean.setSlot5(slot5);

            // Simulate inputting date
            System.out.println("Enter date (YYYY-MM-DD):");
            String dateString = reader.readLine();
           /* LocalDate selectedDate = LocalDate.parse(dateString);
            //
            String dateStringCalendar = selectedDate.toString();

            bean.setDateCalendar(dateStringCalendar);*/
            bean.setDateCalendar(dateString); //selectedDate.toString()

            SaveHoursController controller = new SaveHoursController();
            controller.saveHoursSlots(bean);


        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        } catch (InvalidTimeException | TimeSlotAlreadyExistsException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
    @Override
    public void update() {
        // Aggiorna la visualizzazione dei dati o altre componenti dell'interfaccia utente a riga di comando
        System.out.println("Aggiornamento dell'interfaccia utente...");
        // Puoi aggiornare l'output della console o altre parti dell'interfaccia utente qui
    }
}
