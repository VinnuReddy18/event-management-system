package org.example.eventmanagementsystem.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.eventmanagementsystem.models.Organizer;
import org.example.eventmanagementsystem.models.Participant;
import org.example.eventmanagementsystem.models.Venue;

import java.util.Date;
import java.util.List;
@Getter
@Setter
public class EventDto {
    private Long id;
    private Date date;
    private String eventName;
    private Long venueId;
    private String eventDescription;
    private Long organizerId;
}
