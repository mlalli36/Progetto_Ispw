package com.example.progetto_ispw.worker;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.progetto_ispw.fillform.FillFormBean;
import com.example.progetto_ispw.fillform.FillFormController;
import com.example.progetto_ispw.worker.InfoAppoinEntity;
import com.example.progetto_ispw.worker.WorkerDAO;
        import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class  test3 {

    @Test
    public void testUpdateAppointmentStatus() throws SQLException  {
        // Creare un oggetto WorkerDAO

        WorkerDAO workerDAO = WorkerDAO.getInstance();

        // Mock dati per l'appuntamento
        String workerEmail = "filippo@gmail.com";
        String date = "2022-09-18";
        String time = "12:54";
        int accept= 0;

        // Creare un appuntamento nel database

        workerDAO.addAppointment(workerEmail, "ClientName", "ClientSurname", "client@example.com",
                date, "123456789", "Work Description", time, accept);

        // Chiamare il metodo updateAppointmentStatus per accettare l'appuntamento
        workerDAO.updateAppointmentStatus(workerEmail, date, time);

        // Verificare che l'appuntamento sia stato aggiornato correttamente come accettato
        assertEquals(1, workerDAO.getAppointmentStatus(workerEmail, date, time));
    }
}
