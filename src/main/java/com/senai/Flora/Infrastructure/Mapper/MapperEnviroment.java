package com.senai.Flora.Infrastructure.Mapper;

import com.senai.Flora.Application.DTOs.Entities.Register.EnviromentDTO;
import com.senai.Flora.Domain.Entities.Entity.Register.Enviroment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MapperEnviroment {

    public Enviroment toEntity (EnviromentDTO dto) {
        if (dto == null) return null;
        Enviroment enviroment = new Enviroment();
        enviroment.setNameDescription(dto.nameDescription());
        enviroment.setObservation(dto.observation());
        enviroment.setState(dto.state());
        enviroment.setLocation(LocalDateTime.now());

        return enviroment;
    }

    public EnviromentDTO toDTO (Enviroment enviroment) {
        if (enviroment == null) return null;
        return new EnviromentDTO(
                enviroment.getIdEnviroment(),
                enviroment.getNameDescription(),
                enviroment.getObservation(),
                enviroment.isState(),
                enviroment.getLocation()
        );
    }
}
