package com.example.ticketservice.services.impl;

import com.example.ticketservice.dto.Ticket.CreateTicketsRequest;
import com.example.ticketservice.dto.clients.EventResponse;
import com.example.ticketservice.entities.Ticket;
import com.example.ticketservice.entities.TicketType;
import com.example.ticketservice.exceptions.ResourceNotFoundException;
import com.example.ticketservice.repositories.TicketRepository;
import com.example.ticketservice.repositories.TicketTypeRepository;
import com.example.ticketservice.services.ITicketService;
import com.example.ticketservice.services.clients.EventFeignClient;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService implements ITicketService {

    private final TicketRepository _ticketRepository;
    private final TicketTypeRepository _ticketTypeRepository;
    private final EventFeignClient _eventFeignClient;
    @Override
    public List<Ticket> createTickets(CreateTicketsRequest request) {

        // verify if event exists
        EventResponse event = _eventFeignClient.getEvent(request.getEventId()).getBody();

        // verify if type exists
        TicketType type = _ticketTypeRepository.findByTypeNameAndEventId(request.getTicketType(), request.getEventId())
                .orElseThrow(()-> new ResourceNotFoundException("TicketType","typeName",request.getTicketType()));



        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < request.getCount(); i++) {
            Ticket ticket = new Ticket();
            ticket.setTicketType(type);
            ticket.setEventId(request.getEventId());
            ticket.setPurchaseDate(null);
            ticket.setParticipantId(null);
            ticket.setStatus("AVAILABLE");
            tickets.add(ticket);
        }
        return _ticketRepository.saveAll(tickets);
    }

    @Override
    public List<Ticket> getTickets() {
        return _ticketRepository.findAll();
    }


}
