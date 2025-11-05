package com.senai.Flora.Application.DTOs.Relationships;

import java.time.LocalDate;

public record EnviromentClientDTO(
        Long id ,
        Long idClient,
        Long idEnviroment,
        LocalDate attributionDate
) {
}
