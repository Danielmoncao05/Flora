package com.senai.Flora.Infrastructure.Mapper.Relationships;

import com.senai.Flora.Application.DTOs.Relationships.EnviromentClientDTO;
import com.senai.Flora.Domain.Entities.Relationships.EnviromentClient;
import org.springframework.stereotype.Component;

@Component
public class MapperEnviromentClient {

    public EnviromentClient toEntity (EnviromentClientDTO dto) {
        if (dto == null) return  null;
        EnviromentClient enviromentClient = new EnviromentClient();
        enviromentClient.setClientFlora(dto.client());
        enviromentClient.setEnviroment(dto.enviroment());

        return enviromentClient;
    }

    public EnviromentClientDTO toDTO (EnviromentClient enviromentClient) {
        if (enviromentClient == null) return null;
        return new EnviromentClientDTO(
                enviromentClient.getId_enviromentClient(),
                enviromentClient.getClientFlora(),
                enviromentClient.getEnviroment()
        );
    }
}
