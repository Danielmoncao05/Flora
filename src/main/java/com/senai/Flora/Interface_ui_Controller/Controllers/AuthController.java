package com.senai.Flora.Interface_ui_Controller.Controllers;

import com.senai.Flora.Application.DTOs.Auth.AuthDTO;
import com.senai.Flora.Application.Services.Auth.AuthService;
import com.senai.Flora.Domain.Repositories.Entity.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService auth;
    private final UserRepository users;

    @PostMapping("/login")
    public ResponseEntity<AuthDTO.AuthResponse> login (@RequestBody AuthDTO.LoginRequest request) {
        var tokens = auth.login(request);
        return ResponseEntity.ok(new AuthDTO.AuthResponse(
                tokens.get("accessToken"),
                tokens.get("refreshToken")
        ));
    }

    @GetMapping("/refresh")
    public ResponseEntity<AuthDTO.AuthResponse> refresh (@RequestBody AuthDTO.RefreshRequest request) {
        var newToken = auth.refresh(request.refreshToken());

        return ResponseEntity.ok(new AuthDTO.AuthResponse(
                newToken.get("accessToken"),
                request.refreshToken()
        ));
    }

    @GetMapping("/me")
    public AuthDTO.UserResponse me (Authentication auth) {
        var user = users.findByEmail(auth.getName())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new AuthDTO.UserResponse(user.getName(), user.getEmail(), user.getRole().name());
    }

}
