package com.senai.Flora.Infrastructure.Mapper.Relationships;

import com.senai.Flora.Application.DTOs.Relationships.EnviromentClientDTO;
import com.senai.Flora.Domain.Entities.Entity.Register.enviroment.Enviroment;
import com.senai.Flora.Domain.Entities.Entity.Register.user.ClientFlora;
import com.senai.Flora.Domain.Entities.Relationships.EnviromentClient;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MapperEnviromentClient {

    private final EntityManager entityManager;

    public MapperEnviromentClient(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EnviromentClient toEntity (EnviromentClientDTO dto) {
        if (dto == null) return  null;
        EnviromentClient enviromentClient = new EnviromentClient();

        // Target ClientFlora class existent and associate a new EnviromentClient class
        enviromentClient.setClientFlora(entityManager.getReference(ClientFlora.class, dto.idClient()));

        // Target Enviroment class existent and associate a new EnviromentClient class
        enviromentClient.setEnviroment(entityManager.getReference(Enviroment.class, dto.idEnviroment()));

        enviromentClient.setAttributionDate(LocalDate.now());

        return enviromentClient;
    }

    public EnviromentClientDTO toDTO (EnviromentClient enviromentClient) {
        if (enviromentClient == null) return null;
        return new EnviromentClientDTO(
                enviromentClient.getId(),
                enviromentClient.getClientFlora().getId(),
                enviromentClient.getEnviroment().getId(),
                enviromentClient.getAttributionDate()
        );
    }
}
