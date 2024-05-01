package org.example.eventmanagementsystem.services;

import org.example.eventmanagementsystem.dtos.ParticipantDto;
import org.example.eventmanagementsystem.exceptions.ParticipantNotFoundException;
import org.example.eventmanagementsystem.models.Participant;
import org.example.eventmanagementsystem.repositories.ParticipantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ParticipantService {
    private final ParticipantRepo participantRepo;
    @Autowired
    public ParticipantService(ParticipantRepo participantRepo) {
        this.participantRepo = participantRepo;
    }

    public ParticipantDto getParticipantById(Long id) {

        Optional<Participant> optionalParticipant = participantRepo.findById(id);
        if(optionalParticipant.isEmpty()) throw new ParticipantNotFoundException("Participant not found");
        return convertToDto(optionalParticipant.get());
    }

    private ParticipantDto convertToDto(Participant participant) {
        ParticipantDto participantDto = new ParticipantDto();
        participantDto.setName(participant.getName());
        participantDto.setEmail(participant.getEmail());
        participantDto.setEvents(participant.getEvent());
        return participantDto;
    }

    public ParticipantDto updateParticipant(Long id, ParticipantDto updatedParticipantDto) {
        Optional<Participant> previousParticipant = participantRepo.findById(id);
        if(previousParticipant.isEmpty()) throw new ParticipantNotFoundException("There is no existing User with +" + id);
        Participant updatedParticipant = previousParticipant.get();
        if(updatedParticipantDto.getName()!=null) updatedParticipant.setName(updatedParticipantDto.getName());
        if(updatedParticipantDto.getEmail()!=null) updatedParticipant.setEmail(updatedParticipantDto.getEmail());
        if(updatedParticipantDto.getEvents() != null) {
            updatedParticipant.setEvent(updatedParticipantDto.getEvents());
        }

        if(previousParticipant.get().getEvent() == null) {
            updatedParticipant.setEvent(updatedParticipantDto.getEvents());
        }
        participantRepo.save(updatedParticipant);
        return updatedParticipantDto;
    }

    public ParticipantDto createParticipant(Long id , ParticipantDto ParticipantDto) {
        Participant newParticipant = new Participant();
        newParticipant.setName(ParticipantDto.getName());
        newParticipant.setEmail(ParticipantDto.getEmail());
        newParticipant.setEvent(ParticipantDto.getEvents());
        participantRepo.save(newParticipant);
        return convertToDto(newParticipant);
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

}

