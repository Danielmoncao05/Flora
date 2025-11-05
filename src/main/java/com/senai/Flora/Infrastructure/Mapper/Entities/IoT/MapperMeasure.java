package com.senai.Flora.Infrastructure.Mapper.Entities.IoT;

import com.senai.Flora.Application.DTOs.Entities.IoT.MeasureDTO;
import com.senai.Flora.Domain.Entities.Entity.IoT.Measure;
import com.senai.Flora.Domain.Entities.Relationships.MeasureSens;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class MapperMeasure {

    public Measure toEntity (MeasureDTO dto) {
        if (dto == null) return null;
        Measure measure = new Measure();
        measure.setMeasure_name(dto.measure_name());
        measure.setMeasure_default(dto.measure_default());
        measure.setMeasureSens(new ArrayList<>());

        return measure;
    }

    public MeasureDTO toDTO (Measure measure) {
        if (measure == null) return null;

        return new MeasureDTO(
                measure.getId(),
                measure.getMeasure_name(),
                measure.getMeasure_default(),
                measure.getMeasureSens().stream().map(measureSens ->
                        measureSens.getSens().getId()).collect(Collectors.toList())
        );
    }

}
