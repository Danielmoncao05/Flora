package com.senai.Flora.Application.DTOs.Entities.Enviroment;

import java.time.LocalDateTime;

public record EnviromentDTO(
        long idEnviroment,
        String nameDescription,
        String observation,
        boolean state,
        LocalDateTime location
) {
}
