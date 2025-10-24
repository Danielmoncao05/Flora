package com.senai.Flora.Application.DTOs.Relationships;

import com.senai.Flora.Domain.Entities.Entity.Register.enviroment.Enviroment;
import com.senai.Flora.Domain.Entities.Entity.Register.user.ClientFlora;

public record EnviromentClientDTO(
        Long id_Enviroment_Client ,
        Long id_client,
        Long id_enviroment
) {
}
