package org.example.eventmanagementsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.eventmanagementsystem.models.enums.EVenueAvailability;

import java.util.*;
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Venue extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long capacity;
    private String venueName;
    @OneToMany
    private List<Event> events;
    private String venueLocation;
    private EVenueAvailability venueAvailability ;
}
