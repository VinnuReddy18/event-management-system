package org.example.eventmanagementsystem.controllers;
import org.example.eventmanagementsystem.dtos.EventDto;
import org.example.eventmanagementsystem.models.Event;
import org.example.eventmanagementsystem.services.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    EventController(EventService eventService){

        this.eventService = eventService;
    }
    @PostMapping
    public EventDto createEvent(@RequestBody EventDto event){
        return eventService.createEvent(event);
    }
    @PatchMapping("/{id}")
    public EventDto updateEvent(@PathVariable("id") Long id,@RequestBody EventDto event){
        return eventService.updateEvent(id,event);
    }
    @GetMapping("/{id}")
    public EventDto getEventById(@PathVariable("id") Long id){
        return eventService.getEventById(id);
    }
    @GetMapping
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }
    @DeleteMapping("/{id}")
    public EventDto cancelEvent(@PathVariable("id") Long id){
        return eventService.cancelEvent(id);
    }

}
