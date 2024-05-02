package org.example.eventmanagementsystem.repositories;

import org.example.eventmanagementsystem.models.Event;
import org.example.eventmanagementsystem.models.Organizer;
import org.example.eventmanagementsystem.models.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Repository
public interface EventRepo extends JpaRepository<Event,Long> {

     Optional<Event> findById(Long id);

}
