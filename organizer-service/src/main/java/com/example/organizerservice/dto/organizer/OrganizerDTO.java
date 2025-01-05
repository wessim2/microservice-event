package com.example.organizerservice.dto.organizer;


import lombok.Data;

import java.util.List;


@Data
public class OrganizerDTO {

    private String name;
    private String email;
    private String phone;
    private String organization;
    private List<Long> eventIds;
}
