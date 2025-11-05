package com.senai.Flora.Application.DTOs.Relationships;

import java.time.LocalDate;

public record MeasureSensDTO(
        Long id,
        Long idSens,
        Long idMeasure,
        LocalDate attributionDate
) {
}
