package com.senai.Flora.Application.DTOs.Relationships.MeasureSens;

import com.senai.Flora.Application.DTOs.Entities.IoT.MeasureDTO;
import com.senai.Flora.Application.DTOs.Entities.IoT.SensDTO;

public record MeasureSensFullDTO(
        Long id ,
        SensDTO sens,
        MeasureDTO measure
) {
}
