package com.senai.Flora.Application.DTOs.Entities.Plant;

public record PlantDTO(
        Long id,
        String name,
        boolean state,
        String specialHelp,
        String especie
) {
}
