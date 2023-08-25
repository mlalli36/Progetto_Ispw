package com.example.progetto_ispw.bookedServicesUser;

import com.example.progetto_ispw.workerprofile.AppointmentResultEntity;

public class BookedServicesUserBean {
    private AppointmentResultEntity appointmentResultSet;
    private String email;
    public void setEmail(String email) {this.email=email;}

    public String getEmail() {return email;}

    public void setAppointmentResultSet(AppointmentResultEntity appointmentResultSet) {
        this.appointmentResultSet= appointmentResultSet;
    }

    public AppointmentResultEntity getAppointmentResultSet() {return appointmentResultSet;
    }

    public String getemailsearch() { return email;
    }
}
