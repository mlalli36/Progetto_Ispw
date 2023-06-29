package com.example.progetto_ispw.saveHoursSlots.exception;

import java.time.LocalDate;

public class TimeSlotAlreadyExistsException extends Exception {

    public TimeSlotAlreadyExistsException(){super("*** Time Slot already used ***");}
}
