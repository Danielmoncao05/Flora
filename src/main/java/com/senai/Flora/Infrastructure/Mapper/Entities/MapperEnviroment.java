package com.senai.Flora.Infrastructure.Mapper.Entities;

import com.senai.Flora.Application.DTOs.Entities.Enviroment.EnviromentDTO;
import com.senai.Flora.Domain.Entities.Entity.Register.enviroment.Enviroment;
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
                enviroment.getId(),
                enviroment.getNameDescription(),
                enviroment.getObservation(),
                enviroment.isState(),
                enviroment.getLocation()
        );
    }
}
