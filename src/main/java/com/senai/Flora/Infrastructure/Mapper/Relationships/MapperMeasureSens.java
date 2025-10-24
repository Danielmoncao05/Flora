package com.senai.Flora.Infrastructure.Mapper.Relationships;

import com.senai.Flora.Application.DTOs.Relationships.MeasureSensDTO;
import com.senai.Flora.Domain.Entities.Entity.IoT.Measure;
import com.senai.Flora.Domain.Entities.Entity.IoT.Sens;
import com.senai.Flora.Domain.Entities.Relationships.MeasureSens;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Component;

@Component
public class MapperMeasureSens {

    private final EntityManager entityManager;

    public MapperMeasureSens(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public MeasureSens toEntity (MeasureSensDTO dto) {
        if (dto == null) return null;
        MeasureSens measureSens = new MeasureSens();

        // Target sens class existent and associate a new MeasureSens class
       measureSens.setSens(entityManager.getReference(Sens.class, dto.id_sens()));

        // Target Measure class existent and associate a new MeasureSens class
        measureSens.setMeasure(entityManager.getReference(Measure.class, dto.id_measure()));

        return measureSens;
    }

    public MeasureSensDTO toDTO (MeasureSens measureSens) {
        if (measureSens == null) return null;

        return new MeasureSensDTO(
                measureSens.getId_MeasureSens(),
                measureSens.getSens().getId_Sens(),
                measureSens.getMeasure().getId_measure()
        );
    }
}


// how i maked this ? i create two entities for relation in the relationship