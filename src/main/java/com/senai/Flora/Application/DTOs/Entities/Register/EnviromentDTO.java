package com.senai.Flora.Application.DTOs.Entities.Register;

import java.time.LocalDateTime;

public record EnviromentDTO(
        long idEnviroment,
        String nameDescription,
        String observation,
        boolean state,
        LocalDateTime location
) {
}
