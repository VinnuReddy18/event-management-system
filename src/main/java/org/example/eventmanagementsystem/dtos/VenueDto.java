package org.example.eventmanagementsystem.dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.example.eventmanagementsystem.models.Event;
import org.example.eventmanagementsystem.models.enums.EVenueAvailability;

import java.util.List;

public class VenueDto {
    private Long capacity;
    private String venueName;

    private List<Event> events;
    private String venueLocation;
    private EVenueAvailability venueAvailability ;
}
