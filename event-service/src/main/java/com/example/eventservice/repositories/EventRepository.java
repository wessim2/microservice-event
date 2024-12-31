package com.example.eventservice.repositories;

import com.example.eventservice.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findByDateAndVenue(LocalDateTime date, String venue);
    Optional<Event> findByNameIgnoreCase(String name);
}
