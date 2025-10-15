package com.senai.Flora.Application.DTOs.Entities.IoT;

import com.senai.Flora.Domain.Entities.Entity.IoT.Sens;

public record MeasureDTO(
        Long id,
        String measure_name,
        double measure_default
) {
}
