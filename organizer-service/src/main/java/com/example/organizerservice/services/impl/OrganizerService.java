package com.example.organizerservice.services.impl;

import com.example.organizerservice.dto.event.EventResponse;
import com.example.organizerservice.dto.organizer.OrganizerDTO;
import com.example.organizerservice.dto.user.CreateUserRequest;
import com.example.organizerservice.entities.Organizer;
import com.example.organizerservice.exceptions.ResourceNotFoundException;
import com.example.organizerservice.exceptions.organizer.OrganizerFoundEmailException;
import com.example.organizerservice.exceptions.organizer.OrganizerFoundPhoneException;
import com.example.organizerservice.mapper.OrganizerMapper;
import com.example.organizerservice.repositories.OrganizerRepository;
import com.example.organizerservice.services.IOrganizerService;
import com.example.organizerservice.services.clients.EventFeignClient;
import com.example.organizerservice.services.clients.UserFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrganizerService implements IOrganizerService {
    private final OrganizerRepository organizerRepository;
    private final EventFeignClient eventFeignClient;
    private final UserFeignClient userFeignClient;
    @Override
    public Organizer addOrganizer(OrganizerDTO organizerDto) {
        Optional<Organizer> organizerByEmail = organizerRepository.findByEmail(organizerDto.getEmail());
        if (organizerByEmail.isPresent()){
            throw new OrganizerFoundEmailException("Email already exists");
        }
        Optional<Organizer> organizerByPhone = organizerRepository.findByPhone(organizerDto.getPhone());
        if(organizerByPhone.isPresent()){
            throw new OrganizerFoundPhoneException("Phone number already in user");
        }

        Organizer organizer = OrganizerMapper.toOrganizer(organizerDto);
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setEmail(organizer.getEmail());
        createUserRequest.setUsername(organizer.getEmail());
        createUserRequest.setPassword("HelloWorld");
        createUserRequest.setRole("ORGANIZER");
        userFeignClient.createUser(createUserRequest);
        return organizerRepository.save(organizer);
    }

    @Override
    public List<Organizer> getOrganizers() {
        return organizerRepository.findAll();
    }

    @Override
    public Organizer getOrganizerByName(String name) {
        return organizerRepository.findByName(name).orElseThrow(
                ()-> new ResourceNotFoundException("Organizer","Name",name)
        );
    }

    @Override
    public Organizer getOrganizerById(Long id) {
        return organizerRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Organizer","id",id.toString())
        );
    }

    @Override
    public void linkOrganizerToEvents(Long organizerId, List<Long> eventIds) {
        Organizer organizer = organizerRepository.findById(organizerId)
                .orElseThrow(() -> new ResourceNotFoundException("Organizer not found","orgainzer","this"));
        for(Long eventId :eventIds){
            if(!organizer.getEventIds().contains(eventId)){
                organizer.getEventIds().add(eventId);
            }
        }

        organizerRepository.save(organizer);
    }

    @Override
    public void linkOrganizerToEvent(Long organizerId, Long eventId) {
        Organizer organizer = organizerRepository.findById(organizerId)
                .orElseThrow(() -> new ResourceNotFoundException("Organizer not found","orgainzer","this"));

        EventResponse event = eventFeignClient.getEvent(eventId);
        if(event == null){
            throw new ResourceNotFoundException("Event not found","eventId",eventId.toString());
        }
        if(!organizer.getEventIds().contains(eventId)){
            organizer.getEventIds().add(eventId);
        }

        organizerRepository.save(organizer);
    }
}
