package com.senai.Flora.Application.DTOs.Entities.Register;

import java.time.LocalDate;
import java.util.List;

public record PlantCategoryDTO(
        Long id_PlantCategory,
        LocalDate implantationDate,
        String type,
        String observation,
        List<Long> id_Plant
) {
}
