package com.example.ticketservice.repositories;

import com.example.ticketservice.entities.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketTypeRepository extends JpaRepository<TicketType,Long> {
    public Optional<TicketType> findByTypeNameAndEventId(String typeName,Long eventId);
}
