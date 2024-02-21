package com.example.progetto_ispw.home.exception;

public class AddressNotValidException extends Throwable {
    public AddressNotValidException(){
        super("Address geolocation didn't produce a valid result");
    }
}
