package org.example.eventmanagementsystem.services;

import org.example.eventmanagementsystem.exceptions.EventNotFoundException;
import org.example.eventmanagementsystem.repositories.EventRepo;
import org.springframework.stereotype.Service;
import org.example.eventmanagementsystem.dtos.EventDto;
import org.example.eventmanagementsystem.models.Event;
import org.example.eventmanagementsystem.models.Participant;
import org.example.eventmanagementsystem.models.enums.ERegistrationStatus;

import java.util.List;
import java.util.Optional;

import static org.example.eventmanagementsystem.models.enums.EVenueAvailability.AVAILABLE;

@Service
public class EventService {
    private final EventRepo eventRepo;

    public EventService(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    public EventDto createEvent(EventDto event) {
        if(event == null){
            throw new RuntimeException("Event cannot be null");
        }
        Event savedEvent = new Event();
        savedEvent.setName(event.getEventName());
        savedEvent.setDate(event.getDate());
        savedEvent.setEventVenue(event.getEventVenue());
        savedEvent.setEventDescription(event.getEventDescription());
        return convertToDto(eventRepo.save(savedEvent));

    }

    public EventDto updateEvent(Long id, EventDto event) {
        Optional<Event> optionalEvent = eventRepo.findById(id);
        if (optionalEvent.isPresent()) {
            Event eventUpdated = optionalEvent.get();
            if(event.getDate()!=null)eventUpdated.setDate(event.getDate());
            if(event.getEventName()!=null)eventUpdated.setName(event.getEventName());
            if(event.getEventVenue()!=null)eventUpdated.setEventVenue(event.getEventVenue());
            if(event.getEventDescription()!=null)eventUpdated.setEventDescription(event.getEventDescription());
            if(event.getEventOrganizer()!=null)eventUpdated.setEventOrganizer(event.getEventOrganizer());

            return convertToDto(eventRepo.save(eventUpdated));
        } else {
            throw new RuntimeException("Event not found with id: " + id);
        }
    }

    public EventDto getEventById(Long id) {
        Optional<Event> optionalEvent = eventRepo.findById(id);
        if (optionalEvent.isPresent()) {
            return convertToDto(optionalEvent.get());
        } else {
            throw new EventNotFoundException("Event not found with id: " + id);
        }
    }

    public EventDto cancelEvent(Long id) {
        Optional<Event> optionalEvent = eventRepo.findById(id);
        if (optionalEvent.isPresent()) {
            Event eventToCancel = optionalEvent.get();
            eventToCancel.getEventVenue().setVenueAvailability(AVAILABLE);
            eventRepo.delete(eventToCancel);
            return convertToDto(eventToCancel);
        } else {
            throw new EventNotFoundException("Event not found with id: " + id +"could not perform delete operation");
        }
    }

    public EventDto updateEventByOrganizer(Long id,EventDto eventDto){
        Optional<Event> optionalEvent = eventRepo.findById(id);
        if (optionalEvent.isPresent()) {
            Event eventUpdated = optionalEvent.get();
            if(eventDto.getDate()!=null)eventUpdated.setDate(eventDto.getDate());
            if(eventDto.getEventName()!=null)eventUpdated.setName(eventDto.getEventName());
            if(eventDto.getEventDescription()!=null)eventUpdated.setEventDescription(eventDto.getEventDescription());
            if(eventDto.getEventOrganizer()!=null)eventUpdated.setEventOrganizer(eventDto.getEventOrganizer());
            return convertToDto(eventRepo.save(eventUpdated));
        } else {
            throw new EventNotFoundException("Event not found with id: " + id);
        }
    }

    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }
    public EventDto convertToDto(Event event) {
        EventDto eventDto = new EventDto();
        eventDto.setEventName(event.getEventName());
        eventDto.setDate(event.getDate());
        eventDto.setEventVenue(event.getEventVenue());
        eventDto.setEventDescription(event.getEventDescription());
        eventDto.setEventOrganizer(event.getEventOrganizer());
        return eventDto;
    }
}
