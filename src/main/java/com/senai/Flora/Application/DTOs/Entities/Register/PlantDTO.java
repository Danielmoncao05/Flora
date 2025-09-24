package com.senai.Flora.Application.DTOs.Entities.Register;

public record PlantDTO(
        Long id,
        String name,
        boolean state,
        String specialHelp
) {
}
