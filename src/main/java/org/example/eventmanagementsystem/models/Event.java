package org.example.eventmanagementsystem.models;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Event extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    private String eventName;
    @OneToOne
    private Venue eventVenue;
    private String eventDescription;
    @OneToOne
    private Organizer eventOrganizer;
    @OneToMany
    private List<Participant> participants;

    public void setName(Object name) {
    }

    public Object getName() {
        return null;
    }
}
