package org.example.eventmanagementsystem.repositories;

import org.example.eventmanagementsystem.dtos.ParticipantDto;
import org.example.eventmanagementsystem.models.Organizer;
import org.example.eventmanagementsystem.models.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParticipantRepo extends JpaRepository<Participant,Long> {
    @Override
    Optional<Participant> findById(Long id);
    @Override
     Optional<Participant> save(Participant participant);


}
