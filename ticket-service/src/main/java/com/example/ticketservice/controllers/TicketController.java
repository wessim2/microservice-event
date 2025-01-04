package com.example.ticketservice.controllers;

import com.example.ticketservice.dto.Ticket.CreateTicketsRequest;
import com.example.ticketservice.entities.Ticket;
import com.example.ticketservice.services.impl.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService _ticketService;

    @PostMapping("/create")
    public ResponseEntity<Object> createTicket(@RequestBody CreateTicketsRequest request) {
        List<Ticket> tickets = _ticketService.createTickets(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(tickets);
    }
}
