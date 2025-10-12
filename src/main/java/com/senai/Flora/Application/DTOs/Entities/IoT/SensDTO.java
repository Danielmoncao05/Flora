package com.senai.Flora.Application.DTOs.Entities.IoT;

import com.senai.Flora.Domain.Entities.Relationships.MeasureSens;

import java.time.LocalDateTime;

public record SensDTO(
        Long id,
        String type,
        Integer value_sens,
        String sens_name,
        LocalDateTime attribuition_date
      //  MeasureSens measureSens
) {
}
