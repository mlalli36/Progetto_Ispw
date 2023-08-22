package com.example.progetto_ispw.workerprofile;

import com.example.progetto_ispw.home.ResultElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppointmentResultEntity {

    private ArrayList<AppointmentResultElement> elementsList = new ArrayList<>();

    public void addElement(AppointmentResultElement appointmentResultElement) {
        elementsList.add(appointmentResultElement);
    }

    public List<AppointmentResultElement> getElements() {
        return this.elementsList;
    }
}
