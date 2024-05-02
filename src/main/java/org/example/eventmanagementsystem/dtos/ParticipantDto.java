package org.example.eventmanagementsystem.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.eventmanagementsystem.models.Event;

import java.util.List;
@Getter
@Setter
public class ParticipantDto {
    private Long id;
    private String name;
    private String email;
    private Long eventId;
}
