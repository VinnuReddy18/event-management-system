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
}
