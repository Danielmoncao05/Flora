package com.senai.Flora.Application.DTOs.Entities.Register;

public record ClientDTO(
        Long id,
        String name,
        Integer age,
        String email
) {
}
