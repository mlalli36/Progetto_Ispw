package com.example.progetto_ispw.cli;

import com.example.progetto_ispw.acceptappointment.AcceptBean;
import com.example.progetto_ispw.acceptappointment.AcceptController;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.worker.WorkerEmailEntity;
import com.example.progetto_ispw.workerprofile.AppointmentResultElement;
import com.example.progetto_ispw.workerprofile.AppointmentResultEntity;

import java.util.List;

public class AppointmentAcceptedCLI {
    private AcceptController controller= new AcceptController();
    private AcceptBean bean=new AcceptBean();

    public void appointmentAcceptedMethod() {
        CLIController cliController = CLIController.getIstance(); // È un singleton

        UserEntity user = UserEntity.getInstance();
        String emailsearch = user.getEmail();

        bean.setEmail(emailsearch);

        try {
            controller.searchInfo(bean);
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Simulazione dell'impostazione di scrollPane
        WorkerEmailEntity wkE = WorkerEmailEntity.getInstance();
        String email = wkE.getEmailWEE();
        bean.setEmail(email);
        if (controller.verifica(bean)) {

            AppointmentResultEntity appointmentResultEntity = bean.getAppointmentResultSet();
            List<AppointmentResultElement> elements = appointmentResultEntity.getElements();

            System.out.println("Appointments:");

            for (int i = 0; i < elements.size(); i++) {
                AppointmentResultElement a = elements.get(i);
                String email_client = a.getCEmail();
                String name_client = a.getCName();
                String surname_client = a.getCSurname();
                String phone_client = a.getCNumber();
                String description_work = a.getdescriptionWork();
                String time = a.getTime();
                String date = a.getDAppo();

                System.out.println("Appointment " + (i + 1));
                System.out.println("Client: " + name_client + " " + surname_client);
                System.out.println("Email: " + email_client);
                System.out.println("Description of work: " + description_work);
                System.out.println("Time: " + time);
                System.out.println("Date: " + date);
                System.out.println("Phone: " + phone_client);
                System.out.println();
            }
        } else {
            System.out.println("No appointments found.");
        }
    }

}
