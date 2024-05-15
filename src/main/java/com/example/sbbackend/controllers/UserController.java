package com.example.sbbackend.controllers;

import com.example.sbbackend.dto.AuthRequestDto;
import com.example.sbbackend.dto.AuthResponse;
import com.example.sbbackend.dto.RegisterRequestDto;
import com.example.sbbackend.services.AuthenticationService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationService service;
    private final HttpServletResponse httpServletResponse;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @RequestBody RegisterRequestDto request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(
            @RequestBody AuthRequestDto request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping("/test")
    public ResponseEntity<AuthResponse> authenticate(
            @RequestParam String email, @RequestParam String password, HttpServletResponse response
    ) {
        LoggerFactory.getLogger(this.getClass()).warn(email);
        return ResponseEntity.ok(service.authenticate2(email, password, response));
    }

    @GetMapping("/")
    public ResponseEntity<String> home(
    ) {

        return ResponseEntity.ok("good");

    }


}
