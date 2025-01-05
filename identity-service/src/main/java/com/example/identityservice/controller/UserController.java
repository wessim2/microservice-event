package com.example.identityservice.controller;

import com.example.identityservice.dto.CreateUserRequest;
import com.example.identityservice.service.KeycloakUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final KeycloakUserService keycloakUserService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest request) {
        String userId = keycloakUserService.createUser(request.getUsername(), request.getEmail(), request.getPassword(), request.getRole());
        return ResponseEntity.ok("User created with ID: " + userId);
    }
}
