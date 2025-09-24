package com.senai.Flora.Application.DTOs.Entities;

public record PlantDTO(
        Long id,
        String name,
        boolean state,
        String specialHelp
) {
}
