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
    public EventDto createEvent(EventDto event) {

        Event Event = new Event();
        event.setName(EventDto.getName());
        event.setDate(EventDto.getDate());
        event.setEventVenue(EventDto.getEventVenue());
        event.setEventDescription(EventDto.getEventDescription());


        Event savedEvent = EventRepo.save(Event);

//        EventDto savedEventDto = new EventDto();
//        savedEventDto.setId(savedEvent.getId());
//        savedEventDto.setName(savedEvent.getName());
//        savedEventDto.Date(savedEvent.getDate());

        return event;
    }

    public EventDto updateEvent(Long id, EventDto event) {
        Optional<Event> optionalEvent = EventRepo.findById(id);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();

            event.setName(EventDto.getName());
            event.setDate(EventDto.getDate());
            event.setEventVenue(EventDto.getEventVenue());
            event.setEventDescription(EventDto.getEventDescription());

            Event updatedEvent = EventRepo.save(event);

            EventDto updatedEventDto = new EventDto();
            updatedEventDto.setId(updatedEvent.getId());
            updatedEventDto.setName(updatedEvent.getName());
            updatedEventDto.setDate(updatedEvent.getDate());
            updatedEventDto.setEventVenue(updatedEvent.getEventVenue());
            updatedEventDto.setEventDescription(updatedEvent.getEventDescription());

            return updatedEventDto;
        } else {
            throw new RuntimeException("Event not found with id: " + id);
        }
    }

    public EventDto getEventById(Long id) {
Optional<Event> optionalEvent = EventRepo.findById(id);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();

            EventDto eventDto = new EventDto();
            eventDto.setId(event.getId());
            eventDto.setName(event.getName());
            eventDto.setDate(event.getDate());
            eventDto.setEventVenue(event.getEventVenue());
            eventDto.setEventDescription(event.getEventDescription());

            return eventDto;
        } else {
            throw new RuntimeException("Event not found with id: " + id);
        }
    }

    public EventDto cancelEvent(Long id) {
        Optional<Event> optionalEvent = EventRepo.findById(id);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            event.getEventVenue().setVenueAvailability(AVAILABLE);
            EventDto eventDto = new EventDto();
            eventDto.setId(event.getId());
            eventDto.setName(event.getName());
            eventDto.setDate(event.getDate());
            eventDto.setEventVenue(event.getEventVenue());
            eventDto.setEventDescription(event.getEventDescription());

            EventRepo.delete(event);

            return eventDto;
        } else {
            throw new RuntimeException("Event not found with id: " + id);
        }

//        Optional<Event> optionalEvent = EventRepo.findById(id);
//        if (optionalEvent.isPresent()) {
//            Event event = optionalEvent.get();
//
//            EventDto eventDto = new EventDto();
//            eventDto.setId(event.getId());
//            eventDto.setName(event.getName());
//            eventDto.setDate(event.getDate());
//            eventDto.setEventVenue(event.getEventVenue());
//            eventDto.setEventDescription(event.getEventDescription());
//
//            EventRepo.delete(event);
//
//            return eventDto;
//        } else {
//            throw new RuntimeException("Event not found with id: " + id);
//        }


    }

    public EventDto updateEventByOrganizer(Long id,EventDto eventDto){
        Optional<Event> optionalEvent = EventRepo.findById(id);

        if (optionalEvent.isPresent()) {
            Event updatedEvent = optionalEvent.get();

            updatedEvent.setName(eventDto.getName());
            updatedEvent.setDate(eventDto.getDate());
            updatedEvent.setEventDescription(eventDto.getEventDescription());

            Event updatedEvent = EventRepo.save(updatedEvent);

            EventDto updatedEventDto = new EventDto();
            updatedEventDto.setId(updatedEvent.getId());
            updatedEventDto.setName(updatedEvent.getName());
            updatedEventDto.setDate(updatedEvent.getDate());
            updatedEventDto.setEventVenue(updatedEvent.getEventVenue());
            updatedEventDto.setEventDescription(updatedEvent.getEventDescription());

            return updatedEventDto;
        } else {
            throw new EventNotFoundException("Event not found with id: " + id);
        }
        return eventDto;
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
