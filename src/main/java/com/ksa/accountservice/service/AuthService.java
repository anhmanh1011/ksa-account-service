package com.ksa.accountservice.service;

import com.ksa.accountservice.model.request.LoginRequest;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.UserRepresentation;

public interface AuthService {
    AccessTokenResponse login(LoginRequest loginRequest);
    UserRepresentation getUserInfo(String userId);
}
