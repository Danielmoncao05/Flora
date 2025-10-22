package com.senai.Flora.Infrastructure.Mapper.Relationships;

import com.senai.Flora.Application.DTOs.Relationships.MeasureSensDTO;
import com.senai.Flora.Domain.Entities.Entity.IoT.Measure;
import com.senai.Flora.Domain.Entities.Entity.IoT.Sens;
import com.senai.Flora.Domain.Entities.Relationships.MeasureSens;
import org.springframework.stereotype.Component;

@Component
public class MapperMeasureSens {

    public MeasureSens toEntity (MeasureSensDTO dto) {
        if (dto == null) return null;
        MeasureSens measureSens = new MeasureSens();

        Sens sens = new Sens();
        sens.setId_Sens(dto.id_sens());
        measureSens.setSens(sens);


        Measure measure = new Measure();
        measureSens.setMeasure(measure);
        measureSens.getMeasure().setId_measure(dto.id_measure());

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