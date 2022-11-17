package com.ksa.accountservice.controller;

import com.ksa.accountservice.model.request.LoginRequest;
import com.ksa.accountservice.service.AuthService;
import com.kss.autoconfigure.Utils.JSONUtils;
import com.kss.autoconfigure.common.ResponseData;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    AuthService authService;


    @PostMapping("/p/login")
    public ResponseData<AccessTokenResponse> login(@RequestBody LoginRequest loginRequest) {
        return new ResponseData<AccessTokenResponse>().success(authService.login(loginRequest));
    }

    @PostMapping("/e/user_info/{user-id}")
    public ResponseData<UserRepresentation> getUserInfo(@PathVariable("user-id") String userId) {
        return new ResponseData<UserRepresentation>().success(authService.getUserInfo(userId));
    }

}
