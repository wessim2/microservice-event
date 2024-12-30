package com.example.eventservice.controllers;

import com.example.eventservice.entities.Event;
import com.example.eventservice.services.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/event")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addEvent(@RequestBody Event request) {
        Event event = eventService.addEvent(request);
        System.out.println(request.getCategory());
        if(event != null) {
            return new ResponseEntity<>(event, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("An event with the same date or venue already exists", HttpStatus.CONFLICT);
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllEvents() {
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
    }

}
