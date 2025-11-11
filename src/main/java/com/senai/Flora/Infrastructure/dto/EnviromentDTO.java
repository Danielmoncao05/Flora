package com.senai.Flora.Infrastructure.dto;

import java.time.LocalDateTime;

public record EnviromentDTO(
        long idEnviroment,
        String nameDescription,
        String observation,
        boolean state,
        String location,
        Long ownerId // *
) {
}
