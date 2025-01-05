package com.example.organizerservice.mapper;


import com.example.organizerservice.dto.organizer.OrganizerDTO;
import com.example.organizerservice.entities.Organizer;

public class OrganizerMapper {
    public static Organizer toOrganizer(OrganizerDTO organizerDTO) {
        Organizer organizer = new Organizer();
        organizer.setEmail(organizerDTO.getEmail());
        organizer.setName(organizerDTO.getName());
        organizer.setPhone(organizerDTO.getPhone());
        organizer.setOrganization(organizerDTO.getOrganization());
        return organizer;
    }
}
