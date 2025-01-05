package com.example.identityservice.dto;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String username;
    private String email;
    private String password;
    private String role; // Example: Organizer, Admin, Participant
}
