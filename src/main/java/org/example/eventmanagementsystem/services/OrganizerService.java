package org.example.eventmanagementsystem.services;

import org.example.eventmanagementsystem.dtos.OrganizerDto;
import org.example.eventmanagementsystem.exceptions.OrganizerNotFoundException;
import org.example.eventmanagementsystem.models.Organizer;
import org.example.eventmanagementsystem.repositories.OrganizerRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizerService {
    private final OrganizerRepo organizerRepo;

    public OrganizerService(OrganizerRepo organizerRepo) {
        this.organizerRepo = organizerRepo;
    }

    public OrganizerDto getOrganizerById(Long id) {
        Optional<Organizer> optionalOrganizer = organizerRepo.findById(id);
        if (optionalOrganizer.isEmpty()) {
            throw new OrganizerNotFoundException("Organizer not found");
        }
        Organizer organizer=optionalOrganizer.get();
        OrganizerDto organizerDto=new OrganizerDto();
        organizerDto.setName(organizer.getName());
        organizerDto.setEvents(organizer.getEvents());
        organizerDto.setContactNumber(organizer.getContactNumber());
        return organizerDto;
    }
    public OrganizerDto createOrganizer(OrganizerDto organizerDto){
        Organizer organizer = new Organizer();
        organizer.setContactNumber(organizerDto.getContactNumber());
        organizer.setEvents(organizerDto.getEvents());
        organizer.setName(organizerDto.getName());
        organizerRepo.save(organizer);
        organizerDto.setId(organizer.getId());
        return organizerDto;
    }
    public List<OrganizerDto> getAllOrganizers() {
        List<Organizer> optionalOrganizerList = organizerRepo.findAll();
        if (optionalOrganizerList.isEmpty()) {
            throw new OrganizerNotFoundException("Organizers List is Empty");
        }
        List<OrganizerDto> dtos = new ArrayList<>();
        for(Organizer organizer:optionalOrganizerList){
            OrganizerDto organizerDto=new OrganizerDto();
            organizerDto.setName(organizer.getName());
            organizerDto.setEvents(organizer.getEvents());
            organizerDto.setContactNumber(organizer.getContactNumber());
            dtos.add(organizerDto);
        }
        return dtos;
    }

    public OrganizerDto updateOrganizerById(Long id, OrganizerDto organizerDto) {
        Optional<Organizer> optionalOrganizer= organizerRepo.findById(id);
        if(optionalOrganizer.isEmpty()){
            throw new OrganizerNotFoundException("Organizer Not Found");
        }
        Organizer organizer=optionalOrganizer.get();
        if(organizerDto.getContactNumber()!=null) {
            organizer.setContactNumber(organizerDto.getContactNumber());
        }
        if(organizerDto.getEvents()!=null) {
            organizer.setEvents(organizerDto.getEvents());
        }
        if(organizerDto.getName()!=null) {
            organizer.setName(organizerDto.getName());
        }
        organizerRepo.save(organizer);
        return organizerDto;
    }

}
