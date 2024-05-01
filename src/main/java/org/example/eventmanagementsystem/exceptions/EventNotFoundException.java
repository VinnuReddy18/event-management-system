package org.example.eventmanagementsystem.exceptions;

public class EventNotFoundException extends RuntimeException{
    public EventNotFoundException(String message){
        super(message);
    }
}
