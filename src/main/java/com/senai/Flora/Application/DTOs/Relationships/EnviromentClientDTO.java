package com.senai.Flora.Application.DTOs.Relationships;

public record EnviromentClientDTO(
        Long id_Enviroment_Client ,
        Long id_Client,
        Long id_Enviroment
) {
}
