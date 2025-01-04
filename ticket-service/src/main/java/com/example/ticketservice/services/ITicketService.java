package com.example.ticketservice.services;

import com.example.ticketservice.dto.Ticket.CreateTicketsRequest;
import com.example.ticketservice.entities.Ticket;

import java.util.List;

public interface ITicketService {
        List<Ticket> createTickets(CreateTicketsRequest ticketsDTO);
        List<Ticket> getTickets();

}
