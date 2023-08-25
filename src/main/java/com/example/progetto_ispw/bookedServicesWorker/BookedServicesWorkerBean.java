package com.example.progetto_ispw.bookedServicesWorker;

import com.example.progetto_ispw.workerprofile.AppointmentResultEntity;

public class BookedServicesWorkerBean {
    private AppointmentResultEntity appointmentResultSet;
    private String emailsearch;
    public void setEmail(String emailsearch) {this.emailsearch = emailsearch;}

    public String getemailsearch() { return emailsearch;
    }


    public void setAppointmentResultSet(AppointmentResultEntity appointmentResultSet) {
        this.appointmentResultSet= appointmentResultSet;
    }

    public AppointmentResultEntity getAppointmentResultSet() {
        return appointmentResultSet;
    }
}
