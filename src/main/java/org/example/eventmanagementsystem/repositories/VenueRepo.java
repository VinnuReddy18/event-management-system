package org.example.eventmanagementsystem.repositories;
import org.example.eventmanagementsystem.models.Participant;
import org.example.eventmanagementsystem.models.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VenueRepo extends JpaRepository<Venue,Long> {
    @Override
    Optional<Venue> findById(Long id);
    @Override
    Venue save(Venue venue);
}
