package com.senai.Flora.Application.DTOs.Entities.IoT;

public record MeasureDTO(
        Long id,
        String measure_name,
        double measure_default
) {
}
