package com.senai.Flora.Infrastructure.Mapper.Relationships;

import com.senai.Flora.Application.DTOs.Entities.IoT.MeasureDTO;
import com.senai.Flora.Application.DTOs.Entities.IoT.SensDTO;
import com.senai.Flora.Application.DTOs.Relationships.MeasureSens.MeasureSensDTO;
import com.senai.Flora.Application.DTOs.Relationships.MeasureSens.MeasureSensFullDTO;
import com.senai.Flora.Domain.Entities.Entity.IoT.Measure;
import com.senai.Flora.Domain.Entities.Entity.IoT.Sens;
import com.senai.Flora.Domain.Entities.Relationships.MeasureSens;
import com.senai.Flora.Infrastructure.Mapper.Entities.IoT.MapperMeasure;
import com.senai.Flora.Infrastructure.Mapper.Entities.IoT.MapperSens;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MapperMeasureSens {

    private final EntityManager entityManager;



    public MapperMeasureSens(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    // For id
    public MeasureSens toEntity(MeasureSensDTO dto) {
        if (dto == null) return null;
        MeasureSens measureSens = new MeasureSens();

        // Target sens class existent and associate a new MeasureSens class
        measureSens.setSens(entityManager.getReference(Sens.class, dto.idSens()));

        // Target Measure class existent and associate a new MeasureSens class
        measureSens.setMeasure(entityManager.getReference(Measure.class, dto.idMeasure()));

        measureSens.setAttributionDate(LocalDate.now());

        return measureSens;
    }

    public MeasureSensDTO toDTO(MeasureSens measureSens) {
        if (measureSens == null) return null;

        return new MeasureSensDTO(
                measureSens.getId(),
                measureSens.getSens().getId(),
                measureSens.getMeasure().getId(),
                measureSens.getAttributionDate()
        );
    }

    // For complete body

    public MeasureSensFullDTO toFullDTO(MeasureSens entity) {
        return new MeasureSensFullDTO(
                entity.getId(),
                MapperSens.toDTO(entity.getSens()),
                MapperMeasure.toDTO(entity.getMeasure())
        );
    }


}


// how i maked this ? i create two entities for relation in the relationship