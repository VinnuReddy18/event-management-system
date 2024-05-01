package org.example.eventmanagementsystem.services;

import org.example.eventmanagementsystem.dtos.VenueDto;
import org.example.eventmanagementsystem.exceptions.VenueNotFoundException;
import org.example.eventmanagementsystem.models.Venue;
import org.example.eventmanagementsystem.repositories.VenueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VenueService {

    private final VenueRepo venueRepo;

    @Autowired // Automatic dependency
    public VenueService(VenueRepo venueRepo) {
        this.venueRepo = venueRepo;
    }

    public VenueDto getVenueById(Long id) {
        Optional<Venue> optionalVenue= venueRepo.findById(id);
        if(optionalVenue.isEmpty()){
            throw new VenueNotFoundException("Venue Not Found");
        }
        Venue venue=optionalVenue.get();
        VenueDto venueDto=new VenueDto();
        venueDto.setVenueAvailability(venue.getVenueAvailability());
        venueDto.setVenueLocation(venue.getVenueLocation());
        venueDto.setVenueName(venue.getVenueName());
        venueDto.setCapacity(venueDto.getCapacity());
        venueDto.setVenueLocation(venue.getVenueLocation());
        return venueDto;
    }

    public VenueDto updateVenue(long id, VenueDto venueDto) {
        Optional<Venue> optionalVenue=venueRepo.findById(id);
        if(optionalVenue.isEmpty()){
            throw new VenueNotFoundException("Venue Not Found");
        }
        Venue venue=optionalVenue.get();
        if(venueDto.getVenueAvailability()!=null) {
            venue.setVenueAvailability(venueDto.getVenueAvailability());
        }
        if(venueDto.getVenueLocation()!=null) {
            venue.setVenueLocation(venueDto.getVenueLocation());
        }
        if(venueDto.getVenueName()!=null) {
            venue.setVenueName(venueDto.getVenueName());
        }
        if(venueDto.getCapacity()!=null) {
            venue.setCapacity(venueDto.getCapacity());
        }
        if(venueDto.getVenueLocation()!=null) {
            venue.setVenueLocation(venueDto.getVenueLocation());
        }
        venueRepo.save(venue);
        return venueDto;
    }

    public VenueDto createVenue(VenueDto venueDto) {
        Venue venue=new Venue();
        venue.setVenueAvailability(venueDto.getVenueAvailability());
        venue.setVenueLocation(venueDto.getVenueLocation());
        venue.setVenueName(venueDto.getVenueName());
        venue.setCapacity(venueDto.getCapacity());
        venue.setVenueLocation(venueDto.getVenueLocation());
        venueRepo.save(venue);
        return venueDto;
    }

    public VenueDto removeVenue(Long id) {
        Optional<Venue> optionalVenue=venueRepo.findById(id);
        if(optionalVenue.isEmpty()){
            throw new VenueNotFoundException("Venue Not Found");
        }
        Venue venue=optionalVenue.get();
        VenueDto venueDto=new VenueDto();
        venueDto.setVenueAvailability(venue.getVenueAvailability());
        venueDto.setVenueLocation(venue.getVenueLocation());
        venueDto.setVenueName(venue.getVenueName());
        venueDto.setCapacity(venue.getCapacity());
        venueDto.setVenueLocation(venue.getVenueLocation());
        venueRepo.deleteById(id);
        return venueDto;
    }
}