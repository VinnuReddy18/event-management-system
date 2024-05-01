package org.example.eventmanagementsystem.dtos; 

import jakarta.persistence.OneToMany;
import org.example.eventmanagementsystem.models.Event;

import java.util.List;

public class OrganizerDto {
    private String name;
    @OneToMany
    private List<Event> events;
    private String contactNumber;
}
