package com.example.review.service;

import com.example.review.dto.UserDetails;

public interface AuthenticationService {

    Boolean isAuthenticated(UserDetails userDetails);

    String generateJwtToken(UserDetails userDetails);

}
