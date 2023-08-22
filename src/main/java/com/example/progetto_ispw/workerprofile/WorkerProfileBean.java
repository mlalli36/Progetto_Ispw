package com.example.progetto_ispw.workerprofile;

public class WorkerProfileBean {
    private String emailsearch;

    private AppointmentResultEntity appointmentResultSet;

    public void setEmail(String emailsearch) { this.emailsearch = emailsearch;}

    public String getemailsearch() {return emailsearch;}

    public void setAppointmentResultSet(AppointmentResultEntity appointmentResultSet) {
        this.appointmentResultSet= appointmentResultSet;
    }

    public AppointmentResultEntity getAppointmentResultSet() {
        return appointmentResultSet;
    }
}
