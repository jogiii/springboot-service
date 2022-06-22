package com.example.review.controller;

import com.example.review.dto.UserDetails;
import com.example.review.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody UserDetails userDetails) throws Exception {

        if (authenticationService.isAuthenticated(userDetails)) {
            return ResponseEntity.ok(authenticationService.generateJwtToken(userDetails));
        } else {
            throw new UsernameNotFoundException("Username or password is not valid");
        }
    }

}

