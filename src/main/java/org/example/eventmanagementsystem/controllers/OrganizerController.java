package org.example.eventmanagementsystem.controllers;

import org.aspectj.weaver.ast.Or;
import org.example.eventmanagementsystem.dtos.EventDto;
import org.example.eventmanagementsystem.dtos.OrganizerDto;
import org.example.eventmanagementsystem.services.EventService;
import org.example.eventmanagementsystem.services.OrganizerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping
    public OrganizerDto createOrganizer(@RequestBody OrganizerDto organizerDto){
        return organizerService.createOrganizer(organizerDto);
    }
    @GetMapping
    public List<OrganizerDto> getAllOrganizers(){
        return organizerService.getAllOrganizers();
    }
    @PatchMapping("/{id}")
    public OrganizerDto updateOrganizerById(@PathVariable("id") Long id , @RequestBody OrganizerDto organizerDto){
        return organizerService.updateOrganizerById(id,organizerDto);
    }
    @PatchMapping
    public EventDto updateEventById( Long id){
        return eventService.updateEventByOrganizer(id);
    }


}
