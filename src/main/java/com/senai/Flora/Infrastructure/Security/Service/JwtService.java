package com.senai.Flora.Infrastructure.Security.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Instant;
import java.util.Date;

@Service
public class JwtService {

    private final Key key;

    public JwtService(
            @Value("${security.jwt.secret}") String secret
    ) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    // create access token in hour
    public String generateAccessToken(String email, String role) {
        Instant now = Instant.now();
        return Jwts.builder()
                .setSubject(email)
                .claim("role" , role)
                .setIssuedAt(Date.from(now))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    //
    public String generateRefreshToken(String email) {
        Instant now = Instant.now();
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(Date.from(now))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractEmail (String token) {
        return parseClaims(token).getSubject();
    }

    public String extractRole(String token) {
       return  (String) parseClaims(token).get("role");
    }

    private Claims parseClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)  // token ja assinado
                .getBody();
    }

    public boolean isTokenValid(String token , UserDetails userDetails) {
        final String email = extractEmail(token);
        return (email.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public boolean isTokenExpired(String token) {
        Date expiration = parseClaims(token).getExpiration();
        if (expiration == null) {
            return false;
        }
        return expiration.before(new Date());
    }

    public boolean isValid (String token) {
        try {
            parseClaims(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}
