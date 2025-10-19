package com.senai.Flora.Infrastructure.Mapper.Relationships;

import com.senai.Flora.Application.DTOs.Relationships.MeasureSensDTO;
import com.senai.Flora.Domain.Entities.Relationships.MeasureSens;
import org.springframework.stereotype.Component;

@Component
public class MapperMeasureSens {

    public MeasureSens toEntity (MeasureSensDTO dto) {
        if (dto == null) return null;
        MeasureSens measureSens = new MeasureSens();
        measureSens.setSens(dto.sens());
        measureSens.setMeasure(dto.measure());

        return measureSens;
    }

    public MeasureSensDTO toDTO (MeasureSens measureSens) {
        if (measureSens == null) return null;

        return new MeasureSensDTO(
                measureSens.getId_MeasureSens(),
                measureSens.getSens(),
                measureSens.getMeasure()
        );
    }
}
