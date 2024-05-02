package org.example.eventmanagementsystem.dtos;

import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.example.eventmanagementsystem.models.Event;
import org.example.eventmanagementsystem.models.enums.EVenueAvailability;

import java.util.List;

@Getter
@Setter
public class VenueDto {
    private Long id;
    private Long capacity;
    private String venueName;
    private List<Event> events;
    private String venueLocation;
    private EVenueAvailability venueAvailability ;
}
