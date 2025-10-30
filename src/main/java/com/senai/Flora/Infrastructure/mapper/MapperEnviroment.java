package com.senai.Flora.Infrastructure.mapper;

import com.senai.Flora.Infrastructure.dto.EnviromentDTO;
import com.senai.Flora.domain.Enviroment;
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
