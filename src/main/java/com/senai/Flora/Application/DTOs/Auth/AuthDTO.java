package com.senai.Flora.Application.DTOs.Auth;

public class AuthDTO {

    public record LoginRequest(String email, String password) {}

    public record TokenResponse(String token) {}

    public record AuthResponse(String accessToken, String refreshToken) {}

    public record RefreshRequest(String refreshToken) {}

    public record UserResponse(String name, String email, String role) {}

}
