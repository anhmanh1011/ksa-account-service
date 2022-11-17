package com.ksa.accountservice.service.impl;

import com.ksa.accountservice.model.request.LoginRequest;
import com.ksa.accountservice.service.AuthService;
import lombok.extern.log4j.Log4j2;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Log4j2
public class KeycloakServiceImpl implements AuthService {
    private Keycloak keycloak;
    @Value("${keycloak.auth-server-url}")
    String authUrl = "http://localhost:8080";
    @Value("${keycloak.realm}")
    String realm;
    @Value("${keycloak.resource}")
    String clientId;
    @Value("${keycloak.credentials.secret}")
    String secretKey = "O1svCxVfYM2b6J5o6dlHjdiFj3Ijrwfj";

    @PostConstruct
    public Keycloak getInstance() {
        if (keycloak == null) {

            keycloak = KeycloakBuilder.builder().serverUrl(authUrl).realm(realm).grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                    .clientId(clientId).clientSecret(secretKey).resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build()).build();
        }
        return keycloak;
    }

    public AccessTokenResponse login(LoginRequest loginRequest) {
        Keycloak keycloakUser = KeycloakBuilder.builder().serverUrl(authUrl).realm(realm).username(loginRequest.getUsername()).password(loginRequest.getPassword()).grantType("password").clientId(clientId).clientSecret(secretKey).build();
        return keycloakUser.tokenManager().getAccessToken();
    }

    public UserRepresentation getUserInfo(String userId) {
        return keycloak.realm(realm).users().search(userId).get(0);
    }

    public void logoutSession(String sessionId) {
        keycloak.realm(realm).deleteSession(sessionId);
    }
}
