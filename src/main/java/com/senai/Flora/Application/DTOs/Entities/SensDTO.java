package com.senai.Flora.Application.DTOs.Entities;

import java.time.LocalDateTime;

public record SensDTO(
        Long id,
        String type,
        Integer value_sens,
        String sens_name,
        LocalDateTime attribuition_date
) {
}
