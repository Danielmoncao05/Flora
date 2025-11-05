package com.senai.Flora.Infrastructure.Mapper.Entities.IoT;

import com.senai.Flora.Application.DTOs.Entities.IoT.SensDTO;
import com.senai.Flora.Domain.Entities.Entity.IoT.Sens;
import com.senai.Flora.Domain.Entities.Relationships.MeasureSens;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapperSens {

    public Sens toEntity (SensDTO dto) {
        if (dto == null) return null;
        Sens sens = new Sens();
        sens.setType(dto.type());
        sens.setValueSens(dto.value_sens());
        sens.setSensName(dto.sens_name());
        sens.setAttributionDate(LocalDateTime.now());
        sens.setMeasureSens(new ArrayList<>());



        return sens;
    }

    public SensDTO toDTO (Sens sens) {
        if (sens == null) return null;

//        List<Long> idMeasureSens = null;
//        if (sens.getMeasures() != null) {
//            idMeasureSens = sens.getMeasures().stream().map(MeasureSens::getId_MeasureSens).collect(Collectors.toList())
//        }

        return new SensDTO(
                sens.getId(),
                sens.getType(),
                sens.getValueSens(),
                sens.getSensName(),
                sens.getAttributionDate(),
                sens.getMeasureSens().stream().map(measureSens ->
                        measureSens.getMeasure().getId()).collect(Collectors.toList())
        );
    }
}

