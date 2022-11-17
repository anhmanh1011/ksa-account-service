//package com.ksa.accountservice.runner;
//
//import com.ksa.accountservice.service.impl.KeycloakServiceImpl;
//import com.kss.autoconfigure.Utils.JSONUtils;
//import org.keycloak.admin.client.token.TokenManager;
//import org.keycloak.representations.AccessToken;
//import org.keycloak.representations.AccessTokenResponse;
//import org.keycloak.representations.idm.UserRepresentation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Runner implements CommandLineRunner {
//
//    @Autowired
//    KeycloakServiceImpl keycloakService;
//
//    @Override
//    public void run(String... args) throws Exception {
////        AccessTokenResponse userJWT = keycloakService.getUserJWT("220681", "231231313131");
////        System.out.println(JSONUtils.toJsonString(userJWT));
////
////        keycloakService.logoutSession(userJWT.getSessionState());
////        System.out.println("logout success");
//    }
//}
