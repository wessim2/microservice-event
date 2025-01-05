package com.example.organizerservice.controller;

import com.example.organizerservice.dto.organizer.OrganizerDTO;
import com.example.organizerservice.entities.Organizer;
import com.example.organizerservice.services.impl.OrganizerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizer")
@RequiredArgsConstructor
public class OrganizerController {
    private final OrganizerService organizerService;
    // Create Organizer
    @PostMapping("/create")
    public ResponseEntity<Organizer> createOrganizer(@RequestBody OrganizerDTO request) {
        Organizer response = organizerService.addOrganizer(request);
        return ResponseEntity.ok(response);
    }
    // Get All Organizers
    @GetMapping
    public ResponseEntity<List<Organizer>> getAllOrganizers() {
        List<Organizer> organizers = organizerService.getOrganizers();
        return ResponseEntity.ok(organizers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organizer> getOrganizerById(@PathVariable Long id) {
        Organizer organizerResponse = organizerService.getOrganizerById(id);
        return ResponseEntity.ok(organizerResponse);
    }

    // Link Organizer to Events
    @PutMapping("/{id}/events")
    public ResponseEntity<Void> linkOrganizerToEvents(@PathVariable Long id, @RequestBody List<Long> eventIds) {
        organizerService.linkOrganizerToEvents(id, eventIds);
        return ResponseEntity.ok().build();
    }

    // Link Organizer to Events
    @PutMapping("/{id}/event")
    public ResponseEntity<Void> linkOrganizerToEvent(@PathVariable Long id, @RequestBody Long eventId) {
        organizerService.linkOrganizerToEvent(id, eventId);
        return ResponseEntity.ok().build();
    }
}
