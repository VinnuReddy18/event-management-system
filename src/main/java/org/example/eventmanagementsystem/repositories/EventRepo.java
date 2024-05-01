package org.example.eventmanagementsystem.repositories;

import org.example.eventmanagementsystem.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepo extends JpaRepository<Event,Long> {
    @Override
    Optional<Event> findById(Long id);
    @Override
    Event save(Event event);
}
