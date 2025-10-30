package com.senai.Flora.Infrastructure.dto;

public record PlantDTO(
        Long id,
        String name,
        boolean state,
        String specialHelp
) {
}
