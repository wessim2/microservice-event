package com.example.identityservice.config;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfiguration {

    @Value("http://localhost:7080/auth")
    private String serverUrl;

    @Value("master")
    private String realm;

    @Value("evently-auth")
    private String clientId;

    @Value("NMIlB0z4V7FvOn99n8jN2vFDtqpmDgCY")
    private String clientSecret;

    @Value("admin")
    private String adminUsername;

    @Value("admin")
    private String adminPassword;

    @Bean
    public Keycloak keycloakClient() {
        return KeycloakBuilder.builder()
                .serverUrl("http://localhost:7080")
                .grantType(OAuth2Constants.PASSWORD)
                .realm("master") // Admin realm
                .clientId("admin-cli")
                .clientSecret("9VdwRCgHbods5ZHlYnaCfNQHGrlXtJSH")
                .username("admin")
                .password("admin")
                .build();
    }

    @Bean
    public String keycloakRealm() {
        return realm;
    }
}
