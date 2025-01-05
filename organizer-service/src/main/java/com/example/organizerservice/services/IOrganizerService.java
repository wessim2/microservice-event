package com.example.organizerservice.services;


import com.example.organizerservice.dto.organizer.OrganizerDTO;
import com.example.organizerservice.entities.Organizer;

import java.util.List;

public interface IOrganizerService {
    public Organizer addOrganizer(OrganizerDTO organizerDto);
    public List<Organizer> getOrganizers();
    public Organizer getOrganizerByName(String name);
    public Organizer getOrganizerById(Long id);
    public void linkOrganizerToEvents(Long organizerId, List<Long> eventIds);
    public void linkOrganizerToEvent(Long organizerId, Long eventId);

}
