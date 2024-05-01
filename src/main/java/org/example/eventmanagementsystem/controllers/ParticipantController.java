package org.example.eventmanagementsystem.controllers;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.example.eventmanagementsystem.models.Event;
import org.example.eventmanagementsystem.models.Participant;
import org.example.eventmanagementsystem.dtos.ParticipantDto;
import org.example.eventmanagementsystem.services.EventService;
import org.example.eventmanagementsystem.services.ParticipantService;
import org.example.eventmanagementsystem.models.enums.ERegistrationStatus;

@RestController
@RequestMapping("/participant")
public class ParticipantController {
    private final EventService eventService;
    private final ParticipantService participantService;
    public ParticipantController(ParticipantService participantService, EventService eventService) {
        this.participantService = participantService;
        this.eventService = eventService;
    }
    @GetMapping("/{id}")
    public ParticipantDto getParticipantById(@PathVariable("id") Long id){
        return participantService.getParticipantById(id);
    }
    @PatchMapping("/{id}")
    public ParticipantDto updateParticipant(@PathVariable("id") Long id){
        return participantService.updateParticipant(id);
    }
    @PostMapping
    public ParticipantDto createParticipant(@PathVariable("id") Long id){
        return participantService.createParticipant(id);
    }
    @DeleteMapping("/{id}")
    public ParticipantDto removeParticipant(@PathVariable("id") Long id){
        return participantService.removeParticipant(id);
    }
    @GetMapping
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }
//    @PatchMapping("/{id}")
//    public ERegistrationStatus registerForEvent(@PathVariable("id") Long id, Participant participant ){
//        return eventService.addParticipant(participant, id);
//    }
//    @PatchMapping("/{id}")
//    public ERegistrationStatus unregisterForEvent(@PathVariable("id") Long id, Participant participant ){
//        return eventService.removeParticipant(participant, id);
//    }
}
