package com.example.eventservice.controllers;

import com.example.eventservice.dto.ResponseDto;
import com.example.eventservice.dto.eventDto.EventDto;
import com.example.eventservice.dto.eventDto.EventResponse;
import com.example.eventservice.entities.Event;
import com.example.eventservice.mapper.event.EventMapper;
import com.example.eventservice.services.IEventService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {

    private final IEventService _eventService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> addEvent(@RequestBody EventDto request) {
        _eventService.addEvent(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto("201","Event created"));
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllEvents() {
        return new ResponseEntity<>(_eventService.getAllEvents(), HttpStatus.OK);
    }
    @GetMapping("/get")
    public ResponseEntity<Event> getEventByName(@RequestParam String name) {
        Event event = _eventService.getEventByName(name);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(event);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EventResponse> getEvent(@PathVariable Long id) {
        Event event = _eventService.getEventById(id);
        EventResponse eventResponse = EventMapper.mapToEventResponse(event);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(eventResponse);
    }
}
