package org.example.eventmanagementsystem.exceptions;

public class VenueNotFoundException extends RuntimeException{
    public VenueNotFoundException(String message){
        super(message);
    }
}
