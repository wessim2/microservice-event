package com.example.identityservice.service;

import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class KeycloakUserService {

    private final Keycloak keycloakClient;
    private final String realm;

    public String createUser(String username, String email, String password, String role) {
        // Create User Representation
        UserRepresentation user = new UserRepresentation();
        user.setUsername(username);
        user.setEmail(email);
        user.setEnabled(true);

        // Set User Credentials
        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue(password);
        credential.setTemporary(false);
        user.setCredentials(Collections.singletonList(credential));

        // Create User in Keycloak
        Response response = keycloakClient.realm(realm).users().create(user);
        if (response.getStatus() == 201) {
            String userId = response.getLocation().getPath().replaceAll(".*/([^/]+)$", "$1");
            assignRoleToUser(userId, role);
            return userId;
        } else {
            String errorMessage = response.readEntity(String.class);
            throw new RuntimeException("Failed to create user. Status: " + response.getStatus() + ", Error: " + errorMessage);
        }
    }

    private void assignRoleToUser(String userId, String roleName) {
        // Fetch Role Representation
        RoleRepresentation role = keycloakClient.realm(realm).roles().get(roleName).toRepresentation();

        // Assign Role to User
        keycloakClient.realm(realm).users().get(userId).roles().realmLevel().add(Collections.singletonList(role));
    }
}
