package com.example.sbbackend.controllers;

import com.example.sbbackend.models.User;
import com.example.sbbackend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")

public class AccountController {

    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<User>> getAll() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user= (User) authentication.getPrincipal();
        System.out.println("user count " +  user.getFirstname());
        return ResponseEntity.ok(userService.getAll());
    }


}

