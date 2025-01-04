package com.example.ticketservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TicketType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long eventId;         // Associated event ID
    private String typeName;      // e.g., VIP, Standard, General
    private BigDecimal price;     // Price for this ticket type
    private int capacity;
    @JsonIgnore
    @OneToMany(mappedBy = "ticketType")
    List<Ticket> tickets;

}
