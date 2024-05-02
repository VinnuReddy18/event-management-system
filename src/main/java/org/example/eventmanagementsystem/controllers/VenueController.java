package org.example.eventmanagementsystem.controllers;

import org.example.eventmanagementsystem.dtos.EventDto;
import org.example.eventmanagementsystem.dtos.VenueDto;
import org.example.eventmanagementsystem.services.VenueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venues")
public class VenueController {
    private final VenueService venueService ;

     VenueController(VenueService venueService) {
        this.venueService = venueService;
     }

    @GetMapping("/{id}")
    public VenueDto getVenueById(@PathVariable("id") Long id){
         return venueService.getVenueById(id);
    }
    @PatchMapping("/{id}")
    public VenueDto updateVenue(@PathVariable("id") Long id, @RequestBody VenueDto venueDto){
        return venueService.updateVenue(id,venueDto);
    }
    @PostMapping
    public VenueDto createVenue(@RequestBody VenueDto venueDto){
         return venueService.createVenue(venueDto);
    }
    @DeleteMapping("/{id}")
    public VenueDto removeVenue(@PathVariable("id") Long id){
        return venueService.removeVenue(id);
    }
    @GetMapping
    public List<VenueDto> getAllVenues(){
        return venueService.getAllVenues();
    }
}
