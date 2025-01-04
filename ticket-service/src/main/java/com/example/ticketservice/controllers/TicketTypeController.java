package com.example.ticketservice.controllers;

import com.example.ticketservice.dto.TicketType.CreateTicketTypeRequest;
import com.example.ticketservice.entities.TicketType;
import com.example.ticketservice.services.impl.TicketTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ticketTypes")
@RequiredArgsConstructor
public class TicketTypeController {
    private final TicketTypeService _ticketTypeService;

    @PostMapping("/add")
    public ResponseEntity<Object> addTicketType(@RequestBody CreateTicketTypeRequest request) {
        TicketType ticketType = _ticketTypeService.createTicketType(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ticketType);
    }
}
