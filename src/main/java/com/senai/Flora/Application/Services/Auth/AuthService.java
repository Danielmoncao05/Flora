package com.senai.Flora.Application.Services.Auth;

import com.senai.Flora.Application.DTOs.Auth.AuthDTO;
import com.senai.Flora.Domain.Entities.Entity.Abstract.User;
import com.senai.Flora.Domain.Exceptions.BadCrendentialsException;
import com.senai.Flora.Domain.Repositories.Entity.UserRepository;
import com.senai.Flora.Infrastructure.Security.Service.JwtService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtService jwt;


    public Map<String , String> login (AuthDTO.LoginRequest request) {
        User user =  userRepository.findByEmail(request.email())
                .orElseThrow(() -> new UsernameNotFoundException("User not found or not exist!!"));

        if (!encoder.matches(request.password(), user.getPassword())) {
            throw new BadCrendentialsException("Invalid credentials");
        }

        String accessToken = jwt.generateAccessToken(user.getEmail(), user.getRole().name());
        String refreshToken = jwt.generateRefreshToken(user.getEmail());

        return Map.of(
                "accessToken", accessToken,
                "refreshToken" , refreshToken
        );
    }

    public Map<String , String> refresh (String refreshToken) {
        if (!jwt.isValid(refreshToken)) {
            throw new BadCrendentialsException("Refresh token invalid or expired");
        }

        String email = jwt.extractEmail(refreshToken);
        User user = userRepository.findByEmail(email)
                .orElseThrow( () -> new UsernameNotFoundException("User not found"));

        String newAccess = jwt.generateAccessToken(user.getEmail(), user.getRole().name());
        return Map.of("accessToken" , newAccess);
    }
}
