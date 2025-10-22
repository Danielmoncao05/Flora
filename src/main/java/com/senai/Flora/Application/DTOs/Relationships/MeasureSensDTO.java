package com.senai.Flora.Application.DTOs.Relationships;

import com.senai.Flora.Domain.Entities.Entity.IoT.Measure;
import com.senai.Flora.Domain.Entities.Entity.IoT.Sens;

public record MeasureSensDTO(
        Long id_MeasureSens,
        Long id_sens,
        Long id_measure
) {
}
