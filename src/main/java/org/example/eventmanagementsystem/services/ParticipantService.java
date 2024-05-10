package org.example.eventmanagementsystem.services;

import org.example.eventmanagementsystem.dtos.ParticipantDto;
import org.example.eventmanagementsystem.exceptions.EventNotFoundException;
import org.example.eventmanagementsystem.exceptions.ParticipantNotFoundException;
import org.example.eventmanagementsystem.models.Event;
import org.example.eventmanagementsystem.models.Participant;
import org.example.eventmanagementsystem.repositories.EventRepo;
import org.example.eventmanagementsystem.repositories.ParticipantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {
    private final ParticipantRepo participantRepo;
    private final EventRepo eventRepo;
    @Autowired
    public ParticipantService(ParticipantRepo participantRepo, EventRepo eventRepo) {
        this.participantRepo = participantRepo;
        this.eventRepo = eventRepo;
    }

    public ParticipantDto getParticipantById(Long id) {

        Optional<Participant> optionalParticipant = participantRepo.findById(id);
        if(optionalParticipant.isEmpty()) throw new ParticipantNotFoundException("Participant not found");
        return convertToDto(optionalParticipant.get());
    }

    private ParticipantDto convertToDto(Participant participant) {
        ParticipantDto participantDto = new ParticipantDto();
        participantDto.setId(participant.getId());
        participantDto.setName(participant.getName());
        participantDto.setEmail(participant.getEmail());
        return participantDto;
    }

    public ParticipantDto updateParticipant(Long id, ParticipantDto updatedParticipantDto) {
        Optional<Participant> previousParticipant = participantRepo.findById(id);
        if(previousParticipant.isEmpty()) throw new ParticipantNotFoundException("There is no existing User with +" + id);
        Participant updatedParticipant = previousParticipant.get();
        if(updatedParticipantDto.getName()!=null) updatedParticipant.setName(updatedParticipantDto.getName());
        if(updatedParticipantDto.getEmail()!=null) updatedParticipant.setEmail(updatedParticipantDto.getEmail());
        Optional<Event> optionalEvent = eventRepo.findById(updatedParticipantDto.getEventId());
        optionalEvent.ifPresent(event -> updatedParticipant.getEvent().add(event));
        participantRepo.save(updatedParticipant);

        ParticipantDto participantDto = convertToDto(updatedParticipant);
        participantDto.setEventId(updatedParticipantDto.getEventId());
        return participantDto;
    }

    public ParticipantDto createParticipant(ParticipantDto ParticipantDto) {
        Participant newParticipant = new Participant();
        newParticipant.setName(ParticipantDto.getName());
        newParticipant.setEmail(ParticipantDto.getEmail());
        newParticipant.setEvent(new ArrayList<>());
        Optional<Event> optionalEvent = eventRepo.findById(ParticipantDto.getEventId());
        optionalEvent.ifPresent(event -> newParticipant.getEvent().add(event));
        if(optionalEvent.isEmpty())throw  new EventNotFoundException("Event with event id "+ParticipantDto.getEventId()+" not found");
        participantRepo.save(newParticipant);
        ParticipantDto participantDto = convertToDto(newParticipant);
        participantDto.setEventId(ParticipantDto.getEventId());
        return participantDto;
    }

    public ParticipantDto removeParticipant(Long id) {
        Optional<Participant> participantOptional = participantRepo.findById(id);
        if (participantOptional.isEmpty()) {
            throw new ParticipantNotFoundException("Participant not found with id: " + id);
        }
        Participant participant = participantOptional.get();
        participantRepo.delete(participant);

        return convertToDto(participant);
    }

    public List<Event> getAllEvents(Long id) {
        Optional<Participant> optionalParticipant = participantRepo.findById(id);
        if(optionalParticipant.isPresent())return optionalParticipant.get().getEvent();
        else throw new ParticipantNotFoundException(" Participant not found with id: " + id );
    }
}

