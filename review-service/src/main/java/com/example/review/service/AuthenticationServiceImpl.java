package com.example.review.service;

import com.example.review.dto.UserDetails;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Value("${jwt.secret-key}")
    private String secretKey;

    @Override
    public Boolean isAuthenticated(UserDetails userDetails) {
        //TODO
        return true;
    }

    @Override
    public String generateJwtToken(UserDetails userDetails) {
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
            .commaSeparatedStringToAuthorityList("ROLE_USER");

        return Jwts
            .builder()
            .setId(UUID.randomUUID().toString())
            .setSubject(userDetails.getUsername())
            .claim("authorities",
                grantedAuthorities.stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList()))
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 600000))
            .signWith(SignatureAlgorithm.HS512,
                secretKey.getBytes()).compact();
    }

}
