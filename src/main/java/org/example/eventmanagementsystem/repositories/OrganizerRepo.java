package org.example.eventmanagementsystem.repositories;
import org.example.eventmanagementsystem.models.Event;
import org.example.eventmanagementsystem.models.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizerRepo extends JpaRepository<Organizer,Long> {
    @Override
    Optional<Organizer> findById(Long id);
    @Override
    Organizer save(Organizer organizer);
}
