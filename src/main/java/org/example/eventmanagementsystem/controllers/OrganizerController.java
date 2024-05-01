package org.example.eventmanagementsystem.controllers;

import org.aspectj.weaver.ast.Or;
import org.example.eventmanagementsystem.dtos.EventDto;
import org.example.eventmanagementsystem.dtos.OrganizerDto;
import org.example.eventmanagementsystem.services.EventService;
import org.example.eventmanagementsystem.services.OrganizerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/organizer")

public class OrganizerController {
    private final OrganizerService organizerService;
    private final EventService eventService;

    public OrganizerController(OrganizerService organizerService, EventService eventService) {
        this.organizerService = organizerService;
        this.eventService = eventService;
    }

    @GetMapping("/{id}")
    public OrganizerDto getOrganizerById(@PathVariable("id") Long id){
        return organizerService.getOrganizerById(id);
    }
    @GetMapping
    public OrganizerDto getAllOrganizers(){
        return organizerService.getAllOrganizers();
    }
    @PatchMapping("/{id}")
    public OrganizerDto updateOrganizerById(@PathVariable("id") Long id){
        return organizerService.updateOrganizerById(id);
    }
    @PatchMapping("/{id}")
    public EventDto updateEventById(@PathVariable("id") Long id){
        return eventService.updateEventByOrganizer(id);
    }


}
