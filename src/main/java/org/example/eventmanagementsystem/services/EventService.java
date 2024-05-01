package org.example.eventmanagementsystem.services;

import org.springframework.stereotype.Service;
import org.example.eventmanagementsystem.dtos.EventDto;
import org.example.eventmanagementsystem.models.Event;
import org.example.eventmanagementsystem.models.Participant;
import org.example.eventmanagementsystem.models.enums.ERegistrationStatus;

import java.util.List;

@Service
public class EventService {
    public EventDto createEvent(EventDto event) {
        return null;
    }

    public EventDto updateEvent(Long id) {
        return null;
    }

    public EventDto getEventById(Long id) {
        return null;
    }

    public EventDto cancelEvent(Long id) {
        return null;
    }

    public EventDto updateEventByOrganizer(Long id) {
        return null;
    }

    public List<Event> getAllEvents() {
        return null;
    }

    public ERegistrationStatus addParticipant(Participant participant, Long id) {
        return null;
    }

    public ERegistrationStatus removeParticipant(Participant participant, Long id) {
        return null;
    }
}
