package com.example.progetto_ispw.acceptappointment;

import com.example.progetto_ispw.workerprofile.AppointmentResultEntity;

public class AcceptBean {
    private AppointmentResultEntity appointmentResultSet;
    private String emailsearch;
    public void setEmail(String email) {
        this.emailsearch = email;
    }

    public String getemailsearch() {return emailsearch;
    }

    public void setAppointmentResultSet(AppointmentResultEntity appointmentResultSet) {
        this.appointmentResultSet= appointmentResultSet;
    }

    public AppointmentResultEntity getAppointmentResultSet() { return appointmentResultSet;
    }
}
