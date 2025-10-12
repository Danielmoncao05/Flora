package com.senai.Flora.Application.DTOs.Relationships;

import com.senai.Flora.Domain.Entities.Entity.Register.enviroment.Enviroment;
import com.senai.Flora.Domain.Entities.Entity.Register.user.ClientFlora;

public record EnviromentClientDTO(
        Long id ,
        ClientFlora client,
        Enviroment enviroment
) {
}
