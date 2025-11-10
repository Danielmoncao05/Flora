package com.senai.Flora.Application.DTOs.Entities.Client;

public record ClientDTO(
        Long id,
        String name,
        Integer age,
        String email
) {
}
