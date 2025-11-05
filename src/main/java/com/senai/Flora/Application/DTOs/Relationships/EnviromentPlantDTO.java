package com.senai.Flora.Application.DTOs.Relationships;

import java.time.LocalDate;

public record EnviromentPlantDTO(
        Long id,
        Long idPlant,
        Long idEnviroment,
        LocalDate attributionDate
) {
}
