package com.senai.Flora.Infrastructure.Mapper.Relationships;

import com.senai.Flora.Application.DTOs.Relationships.EnviromentClientDTO;
import com.senai.Flora.Application.DTOs.Relationships.EnviromentPlantDTO;
import com.senai.Flora.Domain.Entities.Entity.Register.Plant.Plant;
import com.senai.Flora.Domain.Entities.Entity.Register.enviroment.Enviroment;
import com.senai.Flora.Domain.Entities.Relationships.EnviromentPlant;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MapperEnviromentPlant {

    private final EntityManager entityManager;

    public MapperEnviromentPlant(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public EnviromentPlant toEntity (EnviromentPlantDTO dto) {
        if (dto == null) return null;
        EnviromentPlant enviromentPlant = new EnviromentPlant();

        // Target Plant class existent and associate a new EnviromentPlant class
        enviromentPlant.setPlant(entityManager.getReference(Plant.class, dto.idPlant()));

        // Target Enviroment class existent and associate a new EnviromentPlant class
        enviromentPlant.setEnviroment(entityManager.getReference(Enviroment.class, dto.idEnviroment()));

        enviromentPlant.setAttributionDate(LocalDate.now());

        return enviromentPlant;
    }

    public EnviromentPlantDTO toDTO (EnviromentPlant enviromentPlant) {
        if (enviromentPlant == null) return null;
        return new EnviromentPlantDTO(
                enviromentPlant.getId(),
                enviromentPlant.getPlant().getId(),
                enviromentPlant.getEnviroment().getId(),
                enviromentPlant.getAttributionDate()
        );
    }

}
