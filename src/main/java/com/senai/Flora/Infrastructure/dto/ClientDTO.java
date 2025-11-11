package com.senai.Flora.Infrastructure.dto;

public record ClientDTO(
        Long id,
        String name,
        Integer age,
        String email,
        String password
) {
}
