package com.senai.Flora.Infrastructure.Mapper;

import com.senai.Flora.Application.DTOs.Entities.SensDTO;
import com.senai.Flora.Domain.Entities.Entity.Sens;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

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

        return new SensDTO(
                sens.getId(),
                sens.getType(),
                sens.getValue_sens(),
                sens.getSens_name(),
                sens.getAttribution_date()
        );
    }
}
