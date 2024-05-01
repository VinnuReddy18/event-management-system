package org.example.eventmanagementsystem.controllers;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.example.eventmanagementsystem.models.Event;
import org.example.eventmanagementsystem.dtos.ParticipantDto;
import org.example.eventmanagementsystem.services.EventService;
import org.example.eventmanagementsystem.services.ParticipantService;

@RestController
@RequestMapping("/participant")
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
    @PostMapping("/{id}")
    public ParticipantDto createParticipant(@PathVariable Long id , @RequestBody ParticipantDto participantDto){
        return participantService.createParticipant(id , participantDto);
    }
    @DeleteMapping("/{id}")
    public ParticipantDto removeParticipant(@PathVariable("id") Long id){
        return participantService.removeParticipant(id);
    }
    @GetMapping()
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }
}
