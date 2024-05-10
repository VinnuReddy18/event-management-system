package org.example.eventmanagementsystem.controllers;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.example.eventmanagementsystem.models.Event;
import org.example.eventmanagementsystem.dtos.ParticipantDto;
import org.example.eventmanagementsystem.services.EventService;
import org.example.eventmanagementsystem.services.ParticipantService;

@RestController
@RequestMapping("/participants")
public class ParticipantController {
    private final ParticipantService participantService;
    private final EventService eventService;
    public ParticipantController(ParticipantService participantService, EventService eventService) {
        this.participantService = participantService;
        this.eventService = eventService;
    }
    @GetMapping("/{id}")
    public ParticipantDto getParticipantById(@PathVariable("id") Long id){
        return participantService.getParticipantById(id);
    }
    @PatchMapping("/{id}")
    public ParticipantDto updateParticipant(@PathVariable("id") Long id , @RequestBody ParticipantDto participantDto){
        return participantService.updateParticipant(id,participantDto);
    }
    @PostMapping
    public ParticipantDto createParticipant( @RequestBody ParticipantDto participantDto){
        return participantService.createParticipant(participantDto);
    }
    @DeleteMapping("/{id}")
    public ParticipantDto removeParticipant(@PathVariable("id") Long id){
        return participantService.removeParticipant(id);
    }
    @GetMapping("/events/{id}")
    public List<Event> getAllEvents(@PathVariable("id") Long id){
        return participantService.getAllEvents(id);
    }
}
