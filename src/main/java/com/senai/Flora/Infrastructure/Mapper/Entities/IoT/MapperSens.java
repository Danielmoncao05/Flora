package com.senai.Flora.Infrastructure.Mapper.Entities.IoT;

import com.senai.Flora.Application.DTOs.Entities.IoT.SensDTO;
import com.senai.Flora.Domain.Entities.Entity.IoT.Sens;
import com.senai.Flora.Domain.Entities.Relationships.MeasureSens;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapperSens {

    public Sens toEntity (SensDTO dto) {
        if (dto == null) return null;
        Sens sens = new Sens();
        sens.setType(dto.type());
        sens.setValue_sens(dto.value_sens());
        sens.setSens_name(dto.sens_name());
        sens.setAttribution_date(LocalDateTime.now());



        return sens;
    }

    public SensDTO toDTO (Sens sens) {
        if (sens == null) return null;

//        List<Long> idMeasureSens = null;
//        if (sens.getMeasures() != null) {
//            idMeasureSens = sens.getMeasures().stream().map(MeasureSens::getId_MeasureSens).collect(Collectors.toList())
//        }

        return new SensDTO(
                sens.getId_Sens(),
                sens.getType(),
                sens.getValue_sens(),
                sens.getSens_name(),
                sens.getAttribution_date()
               // sens.getMeasures().stream().map(MeasureSens::getId_MeasureSens).toList()
        );
    }
}

