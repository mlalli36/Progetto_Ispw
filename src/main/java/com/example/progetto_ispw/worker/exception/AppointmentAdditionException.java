package com.example.progetto_ispw.worker.exception;

public class AppointmentAdditionException extends Exception {
    public AppointmentAdditionException(String message) {
        super(message);
    }

    public AppointmentAdditionException(String message, Throwable cause) {
        super(message, cause);
    }
}
