package com.pasanabeysekara.securitywithswagger.service;

import com.pasanabeysekara.securitywithswagger.dto.AuthenticationRequest;
import com.pasanabeysekara.securitywithswagger.dto.AuthenticationResponse;
import com.pasanabeysekara.securitywithswagger.dto.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AuthenticationService {

    public AuthenticationResponse register(RegisterRequest request);

    public AuthenticationResponse authenticate(AuthenticationRequest request);

    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
