package com.example.organizerservice.repositories;

import com.example.organizerservice.entities.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
    Optional<Organizer> findByEmail(String email);

    Optional<Organizer> findByPhone(String phone);

    Optional<Organizer> findByName(String name);
}
