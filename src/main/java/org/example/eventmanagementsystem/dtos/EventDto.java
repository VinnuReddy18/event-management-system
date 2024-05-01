package org.example.eventmanagementsystem.dtos;

import org.example.eventmanagementsystem.models.Organizer;
import org.example.eventmanagementsystem.models.Participant;
import org.example.eventmanagementsystem.models.Venue;

import java.util.Date;
import java.util.List;

public class EventDto {
    private Date date;
    private String eventName;
    private Venue eventVenue;
    private String eventDescription;
    private Organizer eventOrganizer;
    private List<Participant> participants;

    public static Object getName() {
        return null;
    }

    public static Date getDate() {
        return null;
    }

    public static Venue getEventVenue() {
        return null;
    }

    public static String getEventDescription() {
        return null;
    }

    public void setName(Object name) {
    }

    public void setDate(Object date) {
    }

    public void setId(Long id) {
    }

    public void Date(Date date) {
    }

    public void setEventVenue(Object eventVenue) {
    }

    public void setEventDescription(Object eventDescription) {
    }
}
