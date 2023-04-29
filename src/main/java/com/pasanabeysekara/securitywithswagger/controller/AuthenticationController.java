package com.pasanabeysekara.securitywithswagger.controller;

import com.pasanabeysekara.securitywithswagger.dto.AuthenticationRequest;
import com.pasanabeysekara.securitywithswagger.dto.AuthenticationResponse;
import com.pasanabeysekara.securitywithswagger.dto.RegisterRequest;
import com.pasanabeysekara.securitywithswagger.service.AuthenticationService;
import com.pasanabeysekara.securitywithswagger.util.StandardResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Auth", description = "Auth management APIs")
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequest request) {
        return new ResponseEntity(new StandardResponse("200", "Done", service.register(request)), HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return new ResponseEntity(new StandardResponse("200", "Done", service.authenticate(request)), HttpStatus.OK);
    }

    @PostMapping("/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.refreshToken(request, response);
    }

}
