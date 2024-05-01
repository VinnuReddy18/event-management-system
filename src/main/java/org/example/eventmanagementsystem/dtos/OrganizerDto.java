package org.example.eventmanagementsystem.dtos; 

import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.example.eventmanagementsystem.models.Event;

import java.util.List;
@Getter
@Setter
public class OrganizerDto {
    private String name;
    @OneToMany
    private List<Event> events;
    private String contactNumber;
}
