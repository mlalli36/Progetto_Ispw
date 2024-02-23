package com.example.progetto_ispw.worker.exception;

public class UpdateAppointmentAvailabilityException extends Exception {
    public UpdateAppointmentAvailabilityException(String message) {
        super(message);
    }

    public UpdateAppointmentAvailabilityException(String message, Throwable cause) {
        super(message, cause);
    }
}