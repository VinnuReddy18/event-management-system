package org.example.eventmanagementsystem.repositories;

import org.example.eventmanagementsystem.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepo extends JpaRepository<Event,Long> {

    static Optional<Event> findById(Long id) {
        return null;
    }

    static Event save(Event event) {
        return null;
    }
}
