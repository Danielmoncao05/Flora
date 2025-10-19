package com.senai.Flora.Application.DTOs.Entities.IoT;

import com.senai.Flora.Domain.Entities.Relationships.MeasureSens;

import java.time.LocalDateTime;
import java.util.List;

public record SensDTO(
        Long id,
        String type,
        Integer value_sens,
        String sens_name,
        LocalDateTime attribuition_date,
        List<MeasureSens> measures
) {
}
