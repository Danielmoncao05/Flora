package com.senai.Flora.Application.DTOs.Entities.IoT;

import com.senai.Flora.Domain.Entities.Entity.IoT.Sens;
import com.senai.Flora.Domain.Entities.Relationships.MeasureSens;

import java.util.List;

public record MeasureDTO(
        Long id,
        String measure_name,
        double measure_default,
        List<MeasureSens> sens
) {
}
