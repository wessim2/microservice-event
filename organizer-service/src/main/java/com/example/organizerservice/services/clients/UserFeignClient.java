package com.example.organizerservice.services.clients;

import com.example.organizerservice.dto.user.CreateUserRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "identity-service")

public interface UserFeignClient {
    @PostMapping("/api/users")
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest request);
}
