package com.example.parkingapi.controller;

import com.example.parkingapi.dto.JwtAuthenticationResponse;
import com.example.parkingapi.dto.SignInRequest;
import com.example.parkingapi.dto.SignUpRequest;
import com.example.parkingapi.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/sign-up")
    public JwtAuthenticationResponse signUp(@RequestBody SignUpRequest request) {
        return authenticationService.signUp(request);
    }
    @PostMapping("/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody SignInRequest request, HttpServletRequest req) {
        return authenticationService.signIn(request);
    }
}
