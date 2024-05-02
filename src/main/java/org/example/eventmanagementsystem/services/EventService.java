package org.example.eventmanagementsystem.services;

import org.example.eventmanagementsystem.exceptions.EventNotFoundException;
import org.example.eventmanagementsystem.exceptions.OrganizerNotFoundException;
import org.example.eventmanagementsystem.exceptions.VenueNotFoundException;
import org.example.eventmanagementsystem.models.Organizer;
import org.example.eventmanagementsystem.models.Venue;
import org.example.eventmanagementsystem.repositories.EventRepo;
import org.example.eventmanagementsystem.repositories.OrganizerRepo;
import org.example.eventmanagementsystem.repositories.VenueRepo;
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
    private final VenueRepo venueRepo;
    private final OrganizerRepo organizerRepo;
    public EventService(EventRepo eventRepo, VenueRepo venueRepo, OrganizerRepo organizerRepo) {
        this.eventRepo = eventRepo;
        this.venueRepo = venueRepo;
        this.organizerRepo = organizerRepo;
    }

    public EventDto createEvent(EventDto event) {
        if(event == null){
            throw new RuntimeException("Event cannot be null");
        }
        Event savedEvent = new Event();
        savedEvent.setDate(event.getDate());
        Optional<Venue> optionalVenue = venueRepo.findById(event.getVenueId());
        Optional<Organizer> optionalOrganizer = organizerRepo.findById(event.getOrganizerId());
        if(optionalOrganizer.isEmpty())throw new OrganizerNotFoundException("Organizer not found");
        if(optionalVenue.isEmpty())throw new VenueNotFoundException("venue not Found");

        optionalVenue.get().getEvents().add(savedEvent);
        savedEvent.setEventName(event.getEventName());
        savedEvent.setEventVenue(optionalVenue.get());
        savedEvent.setEventOrganizer(optionalOrganizer.get());
        savedEvent.setEventDescription(event.getEventDescription());

        return convertToDto(eventRepo.save(savedEvent));
    }

    public EventDto updateEvent(Long id, EventDto event) {
        Optional<Event> optionalEvent = eventRepo.findById(id);
        if (optionalEvent.isPresent()) {
            Event eventUpdated = optionalEvent.get();
            if(event.getDate()!=null)eventUpdated.setDate(event.getDate());
            if(event.getEventName()!=null)eventUpdated.setName(event.getEventName());

            if(event.getVenueId()!=null) {
                Optional<Venue> optionalVenue = venueRepo.findById(event.getVenueId());

                if(optionalVenue.isEmpty())throw new VenueNotFoundException("venue not Found");

                optionalVenue.get().getEvents().add(eventUpdated);
                eventUpdated.setEventVenue(optionalVenue.get());
            }
            if(event.getEventDescription()!=null)eventUpdated.setEventDescription(event.getEventDescription());

            if(event.getOrganizerId()!=null) {
                Optional<Organizer> optionalOrganizer = organizerRepo.findById(event.getOrganizerId());

                if(optionalOrganizer.isEmpty())throw new OrganizerNotFoundException("venue not Found");

                optionalOrganizer.get().getEvents().add(eventUpdated);
                eventUpdated.setEventOrganizer(optionalOrganizer.get());
            }

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
            if(eventDto.getOrganizerId()!=null) {

                Optional<Organizer> optionalOrganizer = organizerRepo.findById(eventDto.getOrganizerId());

                if(optionalOrganizer.isEmpty())throw new OrganizerNotFoundException("venue not Found");

                optionalOrganizer.get().getEvents().add(eventUpdated);
                eventUpdated.setEventOrganizer(optionalOrganizer.get());
            }
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
        eventDto.setId(event.getId());
        eventDto.setEventName(event.getEventName());
        eventDto.setDate(event.getDate());
        eventDto.setVenueId(event.getEventVenue().getId());
        eventDto.setEventDescription(event.getEventDescription());
        eventDto.setOrganizerId(event.getEventOrganizer().getId());
        return eventDto;
    }
}
