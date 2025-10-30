package com.senai.Flora.Infrastructure.dto;

public record MeasureDTO(
        Long id,
        String measure_name,
        double measure_default
) {
}
