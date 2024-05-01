package org.example.eventmanagementsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.eventmanagementsystem.models.enums.ERegistrationStatus;

import java.util.HashMap;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Participant extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    @OneToOne
    private Event event;
//    @OneToMany
//    private HashMap<Event, ERegistrationStatus> events;
}
